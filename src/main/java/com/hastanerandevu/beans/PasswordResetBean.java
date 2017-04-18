package com.hastanerandevu.beans;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import com.hastanerandevu.utility.Mailer;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.net.URISyntaxException;

@ManagedBean(name = "passwordReset")
@ViewScoped
public class PasswordResetBean {
  private PatientServiceImpl patientService = new PatientServiceImpl();
  private String urlParam;
  private String password;
  private String email;

  public String getUrlParam() {
    return urlParam;
  }

  public void setUrlParam(String urlParam) {
    this.urlParam = urlParam;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void passwordReset() {
    if(patientService.getUserByEmail(getEmail()) != null) {
      new Mailer().sendPasswordResetMail(getEmail());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifre sıfırlama maili gönderildi.", null));
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email sistemde kayıtlı değil.", null));
    }
  }

  public void passwordUpdate() throws URISyntaxException {
    String encryptedSalt = Encryptor.encryptEmail(ProjectConstants.SALT + getEmail());
    if(urlParam.equals(encryptedSalt)) {
      PatientModel patientModel = patientService.getUserByEmail(getEmail());
      patientModel.setPassword(Encryptor.encryptPassword(getPassword()));
      patientService.update(patientModel);

      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifreniz değiştirildi.", null));
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifreniz değiştirilemedi.", null));
    }
  }
}
