package com.hastanerandevu.beans;

import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.converter.NameConverter;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.DoctorModel;
import com.hastanerandevu.service.impl.DoctorServiceImpl;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "doctor")
@ViewScoped
public class DoctorBean implements Serializable {

  private static final Logger LOG = Logger.getLogger(DoctorBean.class);

  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  private DoctorServiceImpl doctorService;
  private DoctorModel doctorModel;

  private int appointmentCount;
  private String password;

  private List<AppointmentModel> appointmentHistory;

  @PostConstruct
  public void init() {
    doctorService = new DoctorServiceImpl();
    doctorModel = loginBean.getDoctorModel();

    appointmentHistory = new LinkedList<>();

    for(AppointmentModel appointmentModel : doctorService.getAppointmentHistoryByDoctor(doctorModel.getInspectionPlace())){
      appointmentHistory.add(appointmentModel);
      appointmentCount++;
    }
  }

  public void setLoginBean(LoginBean loginBean) {
    this.loginBean = loginBean;
  }

  public int getAppointmentCount() {
    return appointmentCount;
  }

  public List<AppointmentModel> getAppointmentHistory() {
    return appointmentHistory;
  }

  public void setAppointmentHistory(List<AppointmentModel> appointmentHistory) {
    this.appointmentHistory = appointmentHistory;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void doctorUpdate() {
    try {
      doctorService.update(doctorModel);
      loginBean.setLoggedUsername(NameConverter.getName(doctorModel.getFirstName(),doctorModel.getLastName()));

      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Güncelleme Başarılı", null));
    } catch(Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Güncelleme Başarısız", null));
      LOG.error(e.getMessage());
    }
  }

  public void doctorPasswordUpdate() {
    try {
      doctorModel.setPassword(Encryptor.encryptPassword(getPassword()));
      doctorService.update(doctorModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifre Değiştirildi", null));
    } catch(Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre Değiştirilemedi", null));
      LOG.error(e.getMessage());
    }
  }
}
