package com.hastanerandevu.beans;

import com.hastanerandevu.dao.impl.PatientDaoImpl;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.utility.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean (name = "patient")
@SessionScoped
public class PatientBean {
  private PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
  private PatientModel patientModel = new PatientModel();

  public PatientModel getPatientModel () {
    return patientModel;
  }

  public void setPatientModel (PatientModel patientModel) {
    this.patientModel = patientModel;
  }

  public String validateLogin () {
    patientModel = patientDaoImpl.loginPatient(patientModel.getFirstName(), patientModel.getPassword());
    if ( patientModel != null ) {
      HttpSession session = SessionUtils.getSession();
      session.setAttribute("firstName", patientModel.getFirstName());
      return "view/dashboard?faces-redirect=true";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Kullanıcı adı ya da şifre yanlış", "Lütfen kullanıcı adı ve şifrenizi tekrar giriniz"));
      return "/";
    }
  }

  public String validateCreate () {
    patientModel = patientDaoImpl.createPatient(patientModel.getFirstName(), patientModel.getPassword());
    if ( patientModel != null ) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt başarılı", null));
      return "/";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kullaıcı kaydı yapılamadı", "Bilgileri tekrar kontrol edin"));
      return "/";
    }
  }

  public String logout () {
    HttpSession session = SessionUtils.getSession();
    session.invalidate();
    return "/index?faces-redirect=true";
  }

}