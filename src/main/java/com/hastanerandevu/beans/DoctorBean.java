package com.hastanerandevu.beans;

import com.hastanerandevu.converter.NameConverter;
import com.hastanerandevu.model.*;
import com.hastanerandevu.service.impl.DoctorServiceImpl;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import com.hastanerandevu.service.impl.ReviewsAboutDoctorsServiceImpl;
import com.hastanerandevu.utility.SessionUtils;
import com.hastanerandevu.utility.UTF8Control;
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
import java.util.ResourceBundle;

@ManagedBean(name = "doctor")
@ViewScoped
public class DoctorBean implements Serializable {
  private static final Logger LOG = Logger.getLogger(DoctorBean.class);
  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  ResourceBundle bundle = ResourceBundle.getBundle("com.hastanerandevu.messages",new UTF8Control());

  private DoctorServiceImpl doctorService;
  private PatientServiceImpl patientService;
  private ReviewsAboutDoctorsServiceImpl reviewsAboutDoctorsService;

  private DoctorModel doctorModel;
  private AppointmentModel appointmentModel;

  private int appointmentCount;
  private long remainingAppointment;
  private String password;

  private List<AppointmentModel> appointmentHistory;
  private List<PatientAlergyRelModel> patientAlergies;
  private List<PatientAssayRelModel> patientAssays;
  private List<PatientDiseaseRelModel> patientDiseases;
  private List<ReviewsAboutDoctorsModel> doctorReviews;

  @PostConstruct
  public void init() {
    doctorService = new DoctorServiceImpl();
    patientService = new PatientServiceImpl();
    reviewsAboutDoctorsService = new ReviewsAboutDoctorsServiceImpl();

    appointmentModel = new AppointmentModel();

    appointmentHistory = new LinkedList<>();
    patientAlergies = new LinkedList<>();
    patientAssays = new LinkedList<>();
    patientDiseases = new LinkedList<>();
    doctorReviews = new LinkedList<>();

    if(SessionUtils.getSession().getAttribute("userType").equals("doctor")) {
      doctorModel = loginBean.getDoctorModel();
      for(AppointmentModel appointmentModel : doctorService.getAppointmentHistoryByDoctor(doctorModel)) {
        appointmentHistory.add(appointmentModel);
        appointmentCount++;
      }
      remainingAppointment = doctorService.remainingAppointment(doctorModel);

      doctorReviews.addAll(reviewsAboutDoctorsService.getReviewsAboutDoctor(doctorModel));
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

  public List<ReviewsAboutDoctorsModel> getDoctorReviews() {
    return doctorReviews;
  }

  public void setDoctorReviews(List<ReviewsAboutDoctorsModel> doctorReviews) {
    this.doctorReviews = doctorReviews;
  }

  public long getRemainingAppointment() {
    return remainingAppointment;
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

      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("doctor.update.successful"), null));
    } catch(Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("doctor.update.unsuccessful"), null));
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
