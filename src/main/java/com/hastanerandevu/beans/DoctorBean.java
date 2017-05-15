package com.hastanerandevu.beans;

import com.hastanerandevu.converter.NameConverter;
import com.hastanerandevu.model.*;
import com.hastanerandevu.service.impl.*;
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
  private PatientAlergyRelServiceImpl patientAlergyRelService;
  private PatientAssayRelServiceImpl patientAssayRelService;
  private PatientDiseaseRelServiceImpl patientDiseaseRelService;
  private PatientServiceImpl patientService;
  private DoctorModel doctorModel;
  private AppointmentModel appointmentModel;

  private int appointmentCount;
  private String password;

  private List<AppointmentModel> appointmentHistory;
  private List<PatientAlergyRelModel> patientAlergies;
  private List<PatientAssayRelModel> patientAssays;
  private List<PatientDiseaseRelModel> patientDiseases;

  @PostConstruct
  public void init() {
    doctorService = new DoctorServiceImpl();
    patientAlergyRelService = new PatientAlergyRelServiceImpl();
    patientAssayRelService = new PatientAssayRelServiceImpl();
    patientDiseaseRelService = new PatientDiseaseRelServiceImpl();
    patientService = new PatientServiceImpl();
    doctorModel = loginBean.getDoctorModel();
    appointmentModel = new AppointmentModel();


    appointmentHistory = new LinkedList<>();
    patientAlergies = new LinkedList<>();
    patientAssays = new LinkedList<>();
    patientDiseases = new LinkedList<>();

    for(AppointmentModel appointmentModel : doctorService.getAppointmentHistoryByDoctor(doctorModel.getInspectionPlace())) {
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

  public AppointmentModel getAppointmentModel() {
    return appointmentModel;
  }

  public void setAppointmentModel(AppointmentModel appointmentModel) {
    this.appointmentModel = appointmentModel;
  }

  public List<PatientAlergyRelModel> getPatientAlergies() {
    return patientAlergies;
  }

  public void setPatientAlergies(List<PatientAlergyRelModel> patientAlergies) {
    this.patientAlergies = patientAlergies;
  }

  public List<PatientAssayRelModel> getPatientAssays() {
    return patientAssays;
  }

  public void setPatientAssays(List<PatientAssayRelModel> patientAssays) {
    this.patientAssays = patientAssays;
  }

  public List<PatientDiseaseRelModel> getPatientDiseases() {
    return patientDiseases;
  }

  public void setPatientDiseases(List<PatientDiseaseRelModel> patientDiseases) {
    this.patientDiseases = patientDiseases;
  }

  private void clearListComponentsWithChange(List... lists) {
    for(List list : lists) {
      list.clear();
    }
  }

  public void doctorUpdate() {
    try {
      doctorService.update(doctorModel);
      loginBean.setLoggedUsername(NameConverter.getName(doctorModel.getFirstName(), doctorModel.getLastName()));

      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Güncelleme Başarılı", null));
    } catch(Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Güncelleme Başarısız", null));
      LOG.error(e.getMessage());
    }
  }

  public void patientInfo() {
    clearListComponentsWithChange(patientAlergies, patientAssays, patientDiseases);

    patientAlergies.addAll(patientService.getPatientAlergies(appointmentModel.getPatient()));
    patientAssays.addAll(patientService.getPatientAssays(appointmentModel.getPatient()));
    patientDiseases.addAll(patientService.getPatientDiseases(appointmentModel.getPatient()));
  }
}
