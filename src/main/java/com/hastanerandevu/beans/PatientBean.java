package com.hastanerandevu.beans;

import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.PatientService;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import com.hastanerandevu.utility.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean (name = "patient")
@SessionScoped
public class PatientBean {
  private PatientService patientService = new PatientServiceImpl();
  private PatientModel patientModel = new PatientModel();

  public PatientModel getPatientModel () {
    return patientModel;
  }

  public void setPatientModel (PatientModel patientModel) {
    this.patientModel = patientModel;
  }

  public String validateLogin () {
    if ( patientService.loginPatient(patientModel.getTcNumber(), patientModel.getPassword()) ) {
      return "view/dashboard?faces-redirect=true";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Kullanıcı adı ya da şifre yanlış", "Lütfen kullanıcı adı ve şifrenizi tekrar giriniz"));
      return "/";
    }
  }

  public String validateCreate () {
    boolean valid = patientService.createPatient(patientModel.getFirstName(), patientModel.getLastName(), patientModel.getPassword(), patientModel.getTcNumber(), patientModel.getDateOfBirth(), patientModel.getPlaceOfBirth(), patientModel.getEmail(), patientModel.getPhoneNumber(), patientModel.getAddress(), patientModel.getFatherName(), patientModel.getMotherName());
    if ( valid ) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt başarılı", null));
      return "/";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kullanıcı kaydı yapılamadı", "Bilgileri tekrar kontrol edin"));
      return "/";
    }
  }

  public String logout () {
    HttpSession session = SessionUtils.getSession();
    session.invalidate();
    return "/index?faces-redirect=true";
  }

}