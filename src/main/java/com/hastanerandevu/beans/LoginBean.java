package com.hastanerandevu.beans;

import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.converter.NameConverter;
import com.hastanerandevu.enums.BloodGroupEnum;
import com.hastanerandevu.enums.GenderEnum;
import com.hastanerandevu.enums.SecretQuestionEnum;
import com.hastanerandevu.model.DoctorModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.DoctorServiceImpl;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import com.hastanerandevu.utility.Mailer;
import com.hastanerandevu.utility.SessionUtils;
import com.hastanerandevu.validation.CaptchaValidator;
import org.apache.log4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {

  private static final Logger LOG = Logger.getLogger(LoginBean.class);

  private Mailer mailer = new Mailer();
  private PatientServiceImpl patientService = new PatientServiceImpl();
  private DoctorServiceImpl doctorService = new DoctorServiceImpl();
  private PatientModel patientModel = new PatientModel();
  private DoctorModel doctorModel = new DoctorModel();

  private BloodGroupEnum[] bloodGroupEnums = BloodGroupEnum.values();
  private GenderEnum[] genderEnums = GenderEnum.values();
  private SecretQuestionEnum[] secretQuestionEnums = SecretQuestionEnum.values();

  private byte loginCounter = 0;
  private boolean showCaptcha = false;
  private boolean verifyCaptcha = false;
  private boolean verifyLogin = false;
  private String loggedUsername;
  private String password;

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

  // Functions
  public void patientCreate() {
    if(patientService.haveUserRegistration(patientModel)) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bu kullanıcı sistemde zaten kayıtlı", null));
    } else {
      patientModel.setPassword(Encryptor.encryptPassword(patientModel.getPassword()));
      try {
        patientService.create(patientModel);
        mailer.sendRegisterMail(patientModel);
        patientModel = new PatientModel(); // form reset
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt Başarılı", null));
      } catch(Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kayıt Başarısız", null));
        LOG.info(e.getMessage());
      }
    }
  }

  public void patientUpdate() {
    try {
      patientService.update(patientModel);
      loggedUsername = NameConverter.getName(patientModel.getFirstName(), patientModel.getLastName());

      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Güncelleme Başarılı", null));
    } catch(Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Güncelleme Başarısız", null));
      LOG.error(e.getMessage());
    }
  }

  public void patientPasswordUpdate() {
    try {
      patientModel.setPassword(Encryptor.encryptPassword(getPassword()));
      patientService.update(patientModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifre Değiştirildi", null));
    } catch(Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre Değiştirilemedi", null));
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

    if(loginCheck.equals("patient")) {
      if(patientService.loginPatient(patientModel) != null) {
        patientModel = patientService.loginPatient(patientModel);
        loggedUsername = NameConverter.getName(patientModel.getFirstName(), patientModel.getLastName());
        SessionUtils.getSession().setAttribute("loggedUsername", loggedUsername);
        verifyLogin = true;
      } else
        verifyLogin = false;

      if(showCaptcha) {
        if(verifyCaptcha && verifyLogin) {
          return "view/dashboard?faces-redirect=true";
        } else {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bilgileri kontrol ediniz", null));
          return "/login/patient";
        }
      }
      if(verifyLogin) {
        return "view/dashboard?faces-redirect=true";
      } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bilgileri kontrol ediniz", null));
        return "/login/patient";
      }
    } else if(loginCheck.equals("doctor")) {
      if(doctorService.loginDoctor(doctorModel) != null) {
        doctorModel = doctorService.loginDoctor(doctorModel);
        loggedUsername = doctorModel.getFirstName() + " " + doctorModel.getLastName();
        SessionUtils.getSession().setAttribute("loggedUsername", loggedUsername);
        verifyLogin = true;
      } else
        verifyLogin = false;

      if(showCaptcha) {
        if(verifyCaptcha) {
          return "view/dashboard?faces-redirect=true";
        } else {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bilgileri kontrol ediniz", null));
          return "/login/doctor";
        }
      }
      if(verifyLogin) {
        return "view/dashboard?faces-redirect=true";
      } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bilgileri kontrol ediniz", null));
        return "/login/doctor";
      }
    }
    return null;
  }

  public String logout() {
    HttpSession session = SessionUtils.getSession();
    session.invalidate();
    return "/index?faces-redirect=true";
  }
}
