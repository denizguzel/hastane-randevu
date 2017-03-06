package com.hastanerandevu.beans;

import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.PatientService;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import com.hastanerandevu.utility.SessionUtils;
import com.hastanerandevu.validation.CaptchaValidator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean (name = "patient")
@SessionScoped
public class PatientBean {
  private PatientService patientService = new PatientServiceImpl();
  private PatientModel patientModel = new PatientModel();
  private int loginCounter = 0;
  private boolean showCaptcha = false;
  private boolean verifyCaptcha = false;

  public boolean isShowCaptcha () {
    return showCaptcha;
  }

  public PatientModel getPatientModel () {
    return patientModel;
  }

  public void setPatientModel (PatientModel patientModel) {
    this.patientModel = patientModel;
  }

  public String validateLogin () throws IOException {

    loginCounter += 1;
    if ( loginCounter > 2 ) {
      showCaptcha = true;
    }
    if ( showCaptcha ) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      verifyCaptcha = CaptchaValidator.validate(facesContext);
    }

    boolean verifyLogin = patientService.loginPatient(patientModel.getTcNumber(), patientModel.getPassword());
    if ( showCaptcha ) {
      if ( verifyCaptcha ) {
        return "view/dashboard?faces-redirect=true";
      } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bilgileri kontrol ediniz", null));
        return "/";
      }
    }
    if ( verifyLogin ) {
      return "view/dashboard?faces-redirect=true";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bilgileri kontrol ediniz", null));
      return "/";
    }
  }

  public String validateCreate () {
    boolean valid = patientService.createPatient(patientModel.getFirstName(), patientModel.getLastName(), patientModel.getPassword(), patientModel.getTcNumber(), patientModel.getDateOfBirth(), patientModel.getPlaceOfBirth(), patientModel.getEmail(), patientModel.getPhoneNumber(), patientModel.getAddress(), patientModel.getFatherName(), patientModel.getMotherName());
    if ( valid ) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt başarılı", null));
      return "/";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kayıt başarısız", null));
      return "/";
    }
  }

  public String logout () {
    HttpSession session = SessionUtils.getSession();
    session.invalidate();
    return "/index?faces-redirect=true";
  }

}