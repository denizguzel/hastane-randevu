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
  private Mailer mailer = new Mailer();
  private PatientServiceImpl patientService = new PatientServiceImpl();
  private PatientModel patientModel = new PatientModel();
  private String urlParam;

  public PatientModel getPatientModel() {
    return patientModel;
  }

  public void setPatientModel(PatientModel patientModel) {
    this.patientModel = patientModel;
  }

  public String getUrlParam() {
    return urlParam;
  }

  public void setUrlParam(String urlParam) {
    this.urlParam = urlParam;
  }

  public String passwordReset() {
    if(patientService.haveUserRegistration(patientModel)) {
      mailer.sendPasswordResetMail(patientModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifre sıfırlama maili gönderildi.", null));
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email sistemde kayıtlı değil.", null));
    }
    return "/recovery/reset";
  }

  public String passwordUpdate() throws URISyntaxException {
    String encryptedSalt = Encryptor.encryptEmail(ProjectConstants.SALT + patientModel.getEmail());
    System.out.println(urlParam);
    if(urlParam.equals(encryptedSalt)) {
      patientModel = patientService.getUserByEmail(patientModel);
      patientModel.setPassword(Encryptor.encryptPassword(patientModel.getPassword()));
      patientService.update(patientService.getUserByEmail(patientModel));

      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifreniz değiştirildi.", null));
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifreniz değiştirilemedi.", null));
    }
    return "/recovery/forgot";
  }
}
