package com.hastanerandevu.beans;

import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.enums.BloodGroupEnum;
import com.hastanerandevu.enums.GenderEnum;
import com.hastanerandevu.enums.SecretQuestionEnum;
import com.hastanerandevu.model.AdminModel;
import com.hastanerandevu.model.DoctorModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.AdminServiceImpl;
import com.hastanerandevu.service.impl.DoctorServiceImpl;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import com.hastanerandevu.utility.Mailer;
import com.hastanerandevu.utility.SessionUtils;
import com.hastanerandevu.utility.UTF8Control;
import com.hastanerandevu.validation.CaptchaValidator;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {
  private static final Logger LOG = Logger.getLogger(LoginBean.class);

  private ResourceBundle bundle = ResourceBundle.getBundle("com.hastanerandevu.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale(), new UTF8Control());

  private Mailer mailer;
  private PatientServiceImpl patientService;
  private DoctorServiceImpl doctorService;
  private AdminServiceImpl adminService;

  private PatientModel patientModel;
  private DoctorModel doctorModel;
  private AdminModel adminModel;

  private BloodGroupEnum[] bloodGroupEnums;
  private GenderEnum[] genderEnums;
  private SecretQuestionEnum[] secretQuestionEnums;

  private byte loginCounter = 0;
  private boolean showCaptcha = false;
  private boolean verifyCaptcha = false;
  private boolean verifyLogin = false;
  private String loggedUsername;
  private String password;

  @PostConstruct
  public void init() {
    mailer = new Mailer();

    patientService = new PatientServiceImpl();
    doctorService = new DoctorServiceImpl();
    adminService = new AdminServiceImpl();

    patientModel = new PatientModel();
    doctorModel = new DoctorModel();
    adminModel = new AdminModel();

    bloodGroupEnums = BloodGroupEnum.values();
    genderEnums = GenderEnum.values();
    secretQuestionEnums = SecretQuestionEnum.values();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLoggedUsername() {
    return loggedUsername;
  }

  public void setLoggedUsername(String loggedUsername) {
    this.loggedUsername = loggedUsername;
  }

  public boolean isVerifyLogin() {
    return verifyLogin;
  }

  public void setVerifyLogin(boolean verifyLogin) {
    this.verifyLogin = verifyLogin;
  }

  public boolean isShowCaptcha() {
    return showCaptcha;
  }

  public PatientModel getPatientModel() {
    return patientModel;
  }

  public void setPatientModel(PatientModel patientModel) {
    this.patientModel = patientModel;
  }

  public DoctorModel getDoctorModel() {
    return doctorModel;
  }

  public void setDoctorModel(DoctorModel doctorModel) {
    this.doctorModel = doctorModel;
  }

  public BloodGroupEnum[] getBloodGroupEnums() {
    return bloodGroupEnums;
  }

  public GenderEnum[] getGenderEnums() {
    return genderEnums;
  }

  public SecretQuestionEnum[] getSecretQuestionEnums() {
    return secretQuestionEnums;
  }

  public AdminModel getAdminModel() {
    return adminModel;
  }

  public void setAdminModel(AdminModel adminModel) {
    this.adminModel = adminModel;
  }

  // Functions
  public void patientCreate() {
    if(patientService.haveUserRegistration(patientModel)) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("patient.create.alreadyhave"), null));
    } else {
      patientModel.setPassword(Encryptor.encrypt(patientModel.getPassword()));
      try {
        patientService.create(patientModel);
        mailer.sendRegisterMail(patientModel);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("patient.create.successful"), null));
      } catch(Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("check.error"), null));
        LOG.info(e.getMessage());
      } finally {
        patientModel = new PatientModel(); // form reset
      }
    }
  }

  public void patientUpdate() {
    try {
      patientService.update(patientModel);
      loggedUsername = patientModel.getName();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("patient.update.successful"), null));
    } catch(Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("check.error"), null));
      LOG.error(e.getMessage());
    }
  }

  public void patientPasswordUpdate() {
    try {
      patientModel.setPassword(Encryptor.encrypt(password));
      patientService.update(patientModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("patient.changepassword.successful"), null));
    } catch(Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("check.error"), null));
      LOG.error(e.getMessage());
    }
  }

  private void checkCaptcha() throws IOException {
    loginCounter += 1;
    if(loginCounter > 2) {
      showCaptcha = true;
    }
    if(showCaptcha) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      verifyCaptcha = CaptchaValidator.validate(facesContext);
    }
  }

  public String login() throws IOException {
    checkCaptcha();
    String loginCheck = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("loginCheck");
    SessionUtils.getSession().setAttribute("userType", loginCheck);

    if("patient".equals(loginCheck)) {
      patientModel = ((patientModel = patientService.loginPatient(patientModel)) != null) ? patientModel : null;
      if(patientModel != null) {
        setLoggerUserAndSession(patientModel.getName());
        verifyLogin = true;
      } else
        verifyLogin = false;

      if(showCaptcha) {
        if(verifyCaptcha && verifyLogin) {
          return "view/dashboard?faces-redirect=true";
        } else {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("check.information"), null));
          return "/login/patient";
        }
      }
      if(verifyLogin) {
        return "view/dashboard?faces-redirect=true";
      } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("check.information"), null));
        return "/login/patient";
      }
    } else if("doctor".equals(loginCheck)) {
      doctorModel = ((doctorModel = doctorService.loginDoctor(doctorModel)) != null) ? doctorModel : null;
      if(doctorModel != null) {
        setLoggerUserAndSession(doctorModel.getName());
        verifyLogin = true;
      } else
        verifyLogin = false;

      if(showCaptcha) {
        if(verifyCaptcha) {
          return "view/dashboard?faces-redirect=true";
        } else {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("check.information"), null));
          return "/login/doctor";
        }
      }
      if(verifyLogin) {
        return "view/dashboard?faces-redirect=true";
      } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("check.information"), null));
        return "/login/doctor";
      }
    } else if("admin".equals(loginCheck)) {
      adminModel = ((adminModel = adminService.loginAdmin(adminModel)) != null) ? adminModel : null;
      if(adminModel != null) {
        setLoggerUserAndSession(adminModel.getUserId());
        verifyLogin = true;
      } else
        verifyLogin = false;

      if(showCaptcha) {
        if(verifyCaptcha) {
          return "view/dashboard?faces-redirect=true";
        } else {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("check.information"), null));
          return "/login/admin";
        }
      }
      if(verifyLogin) {
        return "view/dashboard?faces-redirect=true";
      } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("check.information"), null));
        return "/login/admin";
      }
    }
    return null;
  }

  public String logout() {
    HttpSession session = SessionUtils.getSession();
    session.invalidate();
    return "/index?faces-redirect=true";
  }

  private void setLoggerUserAndSession(String name) {
    loggedUsername = name;
    SessionUtils.getSession().setAttribute("loggedUsername", loggedUsername);
  }
}
