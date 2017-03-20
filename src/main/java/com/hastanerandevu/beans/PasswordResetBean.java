package com.hastanerandevu.beans;

import com.hastanerandevu.converter.PasswordEncryptor;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.PatientServiceImpl;
import com.hastanerandevu.utility.Mailer;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.net.URISyntaxException;

@ManagedBean(name = "passwordReset")
@SessionScoped
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
      return "/";
    }
    return "/";
  }

  public String passwordUpdate() throws URISyntaxException {
    String salt          = "498#2D83B631%3800EBD!801600D*7E3CC13";
    String encryptedSalt = PasswordEncryptor.encryptPassword(salt + patientModel.getEmail());

    if(urlParam.equals(encryptedSalt)) {
      patientModel = patientService.getUserByEmail(patientModel);
      patientModel.setPassword(PasswordEncryptor.encryptPassword(patientModel.getPassword()));
      patientService.update(patientService.getUserByEmail(patientModel).getPk(), patientModel);

      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifreniz değiştirildi.", null));
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifreniz değiştirilemedi.", null));
    }
    return "/";
  }
}
