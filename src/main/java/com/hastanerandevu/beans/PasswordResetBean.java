package com.hastanerandevu.beans;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.exceptions.NoUserException;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import com.hastanerandevu.utility.Mailer;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;

@ManagedBean(name = "passwordReset")
@ViewScoped
public class PasswordResetBean {
  private static final Logger LOG = Logger.getLogger(PasswordResetBean.class);
  private PatientServiceImpl patientService;
  private String urlParam;
  private String password;
  private String email;

  @PostConstruct
  public void init(){
    patientService = new PatientServiceImpl();
  }

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
    try {
      PatientModel patientModel = patientService.getUserByEmail(getEmail());

      new Mailer().sendPasswordResetMail(email);
      Calendar date = Calendar.getInstance();
      long t = date.getTimeInMillis();
      patientModel.setForgottenExpirationDate(new Date(t + (ProjectConstants.PASSWORD_RESET_DURATION * ProjectConstants.ONE_MINUTE_IN_MILLIS)));
      patientService.update(patientModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifre sıfırlama maili gönderildi.", null));

    } catch(Exception e) {
      if(e instanceof NoUserException) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email sistemde kayıtlı değil.", null));
        LOG.warn(e.getMessage());
      } else {
        LOG.error(e.getMessage());
      }

    }
  }

  public void passwordUpdate() throws URISyntaxException {
    String encryptedSalt = Encryptor.encrypt(ProjectConstants.SALT + getEmail());
    try {
      PatientModel patientModel = patientService.getUserByEmail(getEmail());
      if(urlParam.equals(encryptedSalt) && patientService.changingPasswordIsAvailable(patientModel)) {

        patientModel.setPassword(Encryptor.encrypt(getPassword()));
        patientService.update(patientModel);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifreniz değiştirildi.", null));

      } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifreniz değiştirilemedi.", null));
      }
    } catch(Exception e) {
      if(e instanceof NoUserException) {
        LOG.warn(e.getMessage());
      } else {
        LOG.error(e.getMessage());
      }
    }
  }
}
