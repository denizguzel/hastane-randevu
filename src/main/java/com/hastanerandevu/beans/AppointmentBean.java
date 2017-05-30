package com.hastanerandevu.beans;

import com.hastanerandevu.converter.NameConverter;
import com.hastanerandevu.model.*;
import com.hastanerandevu.service.impl.*;
import com.hastanerandevu.utility.Mailer;
import com.hastanerandevu.utility.SessionUtils;
import com.hastanerandevu.utility.UTF8Control;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@ManagedBean(name = "appointment")
@ViewScoped
public class AppointmentBean implements Serializable {

  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  private ResourceBundle bundle = ResourceBundle.getBundle("com.hastanerandevu.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale(), new UTF8Control());

  private HospitalPoliclinicRelServiceImpl hospitalPoliclinicRelService;
  private CityServiceImpl cityService;
  private DistrictServiceImpl districtService;
  private HospitalServiceImpl hospitalService;
  private PoliclinicServiceImpl policlinicService;
  private InspectionPlaceServiceImpl inspectionPlaceService;
  private AppointmentServiceImpl appointmentService;
  private PatientServiceImpl patientService;
  private ReviewsAboutDoctorsServiceImpl reviewsAboutDoctorsService;

  private AppointmentModel appointmentModel;
  private ReviewsAboutDoctorsModel reviewsAboutDoctorsModel;
  private PatientModel patientModel;
  private InspectionPlaceModel inspectionPlaceModel;
  private HospitalPoliclinicRelModel hospitalPoliclinicRelModel;
  private AppointmentModel closestAppointment;

  private boolean appointmentClockPanel = false;
  private boolean appointmentPanel = false;
  private boolean appointmentSearchNull = false;

  private String selectedCity;
  private String selectedDistrict;
  private String selectedHospital;
  private String selectedPoliclinic;
  private String selectedInspectionPlace;
  private String daysLeft;
  private String doctorComment;

  private Date appointmentDateStart;
  private Date appointmentDateEnd;
  private Date closestDate;

  private Map<Long, String> cities;
  private Map<Long, String> districts;
  private Map<Long, String> hospitals;
  private Map<Long, String> policlinics;
  private Map<Long, String> inspectionPlaces;

  private List<InspectionPlaceModel> appointmentsHeaders;
  private List<List<AppointmentModel>> appointmentTimes;
  private List<AppointmentModel> appointmentDays;
  private List<AppointmentModel> appointmentHistory;
  private List<ReviewsAboutDoctorsModel> doctorReviewList;

  @SuppressWarnings("unchecked")
  @PostConstruct
  public void init() {
    cities = new LinkedHashMap();
    districts = new LinkedHashMap();
    hospitals = new LinkedHashMap();
    policlinics = new LinkedHashMap();
    inspectionPlaces = new LinkedHashMap();

    cityService = new CityServiceImpl();
    districtService = new DistrictServiceImpl();
    hospitalPoliclinicRelService = new HospitalPoliclinicRelServiceImpl();
    hospitalService = new HospitalServiceImpl();
    inspectionPlaceService = new InspectionPlaceServiceImpl();
    policlinicService = new PoliclinicServiceImpl();
    appointmentService = new AppointmentServiceImpl();
    patientService = new PatientServiceImpl();
    reviewsAboutDoctorsService = new ReviewsAboutDoctorsServiceImpl();

    appointmentModel = new AppointmentModel();
    reviewsAboutDoctorsModel = new ReviewsAboutDoctorsModel();
    patientModel = loginBean.getPatientModel();
    inspectionPlaceModel = new InspectionPlaceModel();
    hospitalPoliclinicRelModel = new HospitalPoliclinicRelModel();

    appointmentsHeaders = new ArrayList<>();
    appointmentDays = new ArrayList<>();
    doctorReviewList = new ArrayList<>();
    appointmentTimes = new LinkedList<>();
    appointmentHistory = new LinkedList<>();

    for(CityModel cityModel : cityService.getCities()) {
      cities.put(cityModel.getPk(), cityModel.getCityName());
    }

    if(SessionUtils.getSession().getAttribute("userType").equals("patient")) {
      if(patientService.getAppointmentHistory(patientModel).size() > 0) {
        appointmentHistory.addAll(patientService.getAppointmentHistory(patientModel));
      }
      if(patientService.getActiveAppointmentsOfPatient(patientModel).size() > 0) {
        closestAppointment = patientService.getActiveAppointmentsOfPatient(patientModel).get(0);
        closestDate = closestAppointment.getAppointmentDate();
        Date today = new Date();

        long diff = closestDate.getTime() - today.getTime();
        daysLeft = String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
      }
    }
  }

  public void setLoginBean(LoginBean loginBean) {
    this.loginBean = loginBean;
  }

  public AppointmentModel getAppointmentModel() {
    return appointmentModel;
  }

  public void setAppointmentModel(AppointmentModel appointmentModel) {
    this.appointmentModel = appointmentModel;
  }

  public String getSelectedCity() {
    return selectedCity;
  }

  public void setSelectedCity(String selectedCity) {
    this.selectedCity = selectedCity;
  }

  public String getSelectedDistrict() {
    return selectedDistrict;
  }

  public void setSelectedDistrict(String selectedDistrict) {
    this.selectedDistrict = selectedDistrict;
  }

  public String getSelectedHospital() {
    return selectedHospital;
  }

  public void setSelectedHospital(String selectedHospital) {
    this.selectedHospital = selectedHospital;
  }

  public String getSelectedPoliclinic() {
    return selectedPoliclinic;
  }

  public void setSelectedPoliclinic(String selectedPoliclinic) {
    this.selectedPoliclinic = selectedPoliclinic;
  }

  public String getSelectedInspectionPlace() {
    return selectedInspectionPlace;
  }

  public void setSelectedInspectionPlace(String selectedInspectionPlace) {
    this.selectedInspectionPlace = selectedInspectionPlace;
  }

  public Map<Long, String> getCities() {
    return cities;
  }

  public void setCities(Map<Long, String> cities) {
    this.cities = cities;
  }

  public Map<Long, String> getDistricts() {
    return districts;
  }

  public void setDistricts(Map<Long, String> districts) {
    this.districts = districts;
  }

  public Map<Long, String> getHospitals() {
    return hospitals;
  }

  public void setHospitals(Map<Long, String> hospitals) {
    this.hospitals = hospitals;
  }

  public Map<Long, String> getPoliclinics() {
    return policlinics;
  }

  public void setPoliclinics(Map<Long, String> policlinics) {
    this.policlinics = policlinics;
  }

  public Map<Long, String> getInspectionPlaces() {
    return inspectionPlaces;
  }

  public void setInspectionPlaces(Map<Long, String> inspectionPlaces) {
    this.inspectionPlaces = inspectionPlaces;
  }

  public List<InspectionPlaceModel> getAppointmentsHeaders() {
    return appointmentsHeaders;
  }

  public void setAppointmentsHeaders(List<InspectionPlaceModel> appointmentsHeaders) {
    this.appointmentsHeaders = appointmentsHeaders;
  }

  public boolean isAppointmentPanel() {
    return appointmentPanel;
  }

  public void setAppointmentPanel(boolean appointmentPanel) {
    this.appointmentPanel = appointmentPanel;
  }

  public boolean isAppointmentClockPanel() {
    return appointmentClockPanel;
  }

  public void setAppointmentClockPanel(boolean appointmentClockPanel) {
    this.appointmentClockPanel = appointmentClockPanel;
  }

  public boolean isAppointmentSearchNull() {
    return appointmentSearchNull;
  }

  public void setAppointmentSearchNull(boolean appointmentSearchNull) {
    this.appointmentSearchNull = appointmentSearchNull;
  }

  public List<List<AppointmentModel>> getAppointmentTimes() {
    return appointmentTimes;
  }

  public void setAppointmentTimes(List<List<AppointmentModel>> appointmentTimes) {
    this.appointmentTimes = appointmentTimes;
  }

  public List<AppointmentModel> getAppointmentDays() {
    return appointmentDays;
  }

  public void setAppointmentDays(List<AppointmentModel> appointmentDays) {
    this.appointmentDays = appointmentDays;
  }

  public List<AppointmentModel> getAppointmentHistory() {
    return appointmentHistory;
  }

  public void setAppointmentHistory(List<AppointmentModel> appointmentHistory) {
    this.appointmentHistory = appointmentHistory;
  }

  public ReviewsAboutDoctorsModel getReviewsAboutDoctorsModel() {
    return reviewsAboutDoctorsModel;
  }

  public void setReviewsAboutDoctorsModel(ReviewsAboutDoctorsModel reviewsAboutDoctorsModel) {
    this.reviewsAboutDoctorsModel = reviewsAboutDoctorsModel;
  }

  public List<ReviewsAboutDoctorsModel> getDoctorReviewList() {
    return doctorReviewList;
  }

  public void setDoctorReviewList(List<ReviewsAboutDoctorsModel> doctorReviewList) {
    this.doctorReviewList = doctorReviewList;
  }

  public String getDaysLeft() {
    return daysLeft;
  }

  public Date getAppointmentDateStart() {
    return appointmentDateStart;
  }

  public void setAppointmentDateStart(Date appointmentDateStart) {
    this.appointmentDateStart = appointmentDateStart;
  }

  public Date getAppointmentDateEnd() {
    return appointmentDateEnd;
  }

  public void setAppointmentDateEnd(Date appointmentDateEnd) {
    this.appointmentDateEnd = appointmentDateEnd;
  }

  public Date getClosestDate() {
    return closestDate;
  }

  public AppointmentModel getClosestAppointment() {
    return closestAppointment;
  }

  public ReviewsAboutDoctorsServiceImpl getReviewsAboutDoctorsService() {
    return reviewsAboutDoctorsService;
  }

  public String getDoctorComment() {
    return doctorComment;
  }

  public void setDoctorComment(String doctorComment) {
    this.doctorComment = doctorComment;
  }

  // Functions
  private void clearMapComponentsWithChange(Map... maps) {
    for(Map map : maps) {
      map.clear();
    }
  }

  private void clearListComponentsWithChange(List... lists) {
    for(List list : lists) {
      list.clear();
    }
  }

  public void changeCity(AjaxBehaviorEvent event) {

    clearMapComponentsWithChange(districts, hospitals, policlinics, inspectionPlaces);

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedCity = input.getValue().toString();
    }

    for(DistrictModel districtModel : cityService.getAllDistrictsByCity(cityService.find(Long.parseLong(selectedCity)))) {
      districts.put(districtModel.getPk(), districtModel.getDistrictName());
    }

    appointmentPanel = false;
    appointmentClockPanel = false;
    appointmentSearchNull = false;
  }

  public void changeDistrict(AjaxBehaviorEvent event) {

    clearMapComponentsWithChange(hospitals, policlinics, inspectionPlaces);

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedDistrict = input.getValue().toString();
    }

    for(HospitalModel hospitalModel : districtService.getHospitalsByDistrict(districtService.find(Long.parseLong(selectedDistrict)))) {
      hospitals.put(hospitalModel.getPk(), hospitalModel.getHospitalName());
    }

    appointmentPanel = false;
    appointmentClockPanel = false;
    appointmentSearchNull = false;
  }

  public void changeHospital(AjaxBehaviorEvent event) {

    clearMapComponentsWithChange(policlinics, inspectionPlaces);

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedHospital = input.getValue().toString();
    }

    for(HospitalPoliclinicRelModel hospitalPoliclinicRelModel : hospitalService.getPoliclinicByHospital(hospitalService.find(Long.parseLong(selectedHospital)))) {
      policlinics.put(hospitalPoliclinicRelModel.getPk(), hospitalPoliclinicRelModel.getPoliclinic().getPoliclinicName());
    }

    appointmentPanel = false;
    appointmentClockPanel = false;
    appointmentSearchNull = false;
  }

  public void changePoliclinic(AjaxBehaviorEvent event) {

    clearMapComponentsWithChange(inspectionPlaces);

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedPoliclinic = input.getValue().toString();
    }

    for(InspectionPlaceModel inspectionPlaceModel : policlinicService.getInspectionPlacesByHospitalPoliclinicRel(hospitalPoliclinicRelService.find(Long.parseLong(selectedPoliclinic)))) {
      StringBuilder str = new StringBuilder(inspectionPlaceModel.getPlaceName());
      if(inspectionPlaceModel.getDoctor() != null) {
        str.append(" ").append(NameConverter.getName(inspectionPlaceModel.getDoctor().getFirstName(), inspectionPlaceModel.getDoctor().getLastName()));
      }
      inspectionPlaces.put(inspectionPlaceModel.getPk(), String.valueOf(str));
    }

    appointmentPanel = false;
    appointmentClockPanel = false;
    appointmentSearchNull = false;
  }

  public void changeInspectionPlace(AjaxBehaviorEvent event) {

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedInspectionPlace = input.getValue().toString();
    }

    appointmentPanel = false;
    appointmentClockPanel = false;
    appointmentSearchNull = false;
  }

  public void searchAppointment() {

    clearListComponentsWithChange(appointmentTimes, appointmentsHeaders, appointmentDays, doctorReviewList);

    if(selectedInspectionPlace != null && !selectedInspectionPlace.isEmpty()) {
      inspectionPlaceModel = inspectionPlaceService.find(Long.parseLong(selectedInspectionPlace));
      if(appointmentDateStart == null && appointmentDateEnd == null) {
        appointmentsHeaders.addAll(inspectionPlaceService.getAppointmentHeaderByInspectionPlace(inspectionPlaceModel));
      } else if(appointmentDateStart != null && appointmentDateEnd == null) {
        appointmentsHeaders.addAll(inspectionPlaceService.getAppointmentHeaderByInspectionPlace(inspectionPlaceModel, appointmentDateStart));
      } else {
        appointmentsHeaders.addAll(inspectionPlaceService.getAppointmentHeaderByInspectionPlace(inspectionPlaceModel, appointmentDateStart, appointmentDateEnd));
      }
      if(appointmentsHeaders.size() == 0) {
        appointmentSearchNull = true;
      }
    } else if(selectedPoliclinic != null && !selectedPoliclinic.isEmpty()) {
      hospitalPoliclinicRelModel = hospitalPoliclinicRelService.find(Long.parseLong(selectedPoliclinic));
      if(appointmentDateStart == null && appointmentDateEnd == null) {
        appointmentsHeaders.addAll(policlinicService.getAppointmentHeadersByPoliclinic(hospitalPoliclinicRelModel));
      } else if(appointmentDateStart != null && appointmentDateEnd == null) {
        appointmentsHeaders.addAll(policlinicService.getAppointmentHeadersByPoliclinic(hospitalPoliclinicRelModel, appointmentDateStart));
      } else {
        appointmentsHeaders.addAll(policlinicService.getAppointmentHeadersByPoliclinic(hospitalPoliclinicRelModel, appointmentDateStart, appointmentDateEnd));
      }
      if(appointmentsHeaders.size() == 0) {
        appointmentSearchNull = true;
      }
    }
    appointmentPanel = true;
  }

  public void selectAppointment(InspectionPlaceModel inspectionPlaceModel) {

    clearListComponentsWithChange(appointmentTimes, appointmentDays);

    List<AppointmentModel> appointmentsByFilter = appointmentService.getAllAppointmentsByInspectionPlace(inspectionPlaceModel);

    byte partitionSize = 17;

    int totalSize;


    if(appointmentDateStart != null && appointmentDateEnd != null) {
      appointmentsByFilter = appointmentsByFilter.stream().filter(p -> p.getAppointmentDate().after(appointmentDateStart) && p.getAppointmentDate().before(appointmentDateEnd)).collect(Collectors.toList());
    } else if(appointmentDateStart != null && appointmentDateEnd == null) {
      appointmentsByFilter = appointmentsByFilter.stream().filter(p -> p.getAppointmentDate().after(appointmentDateStart)).collect(Collectors.toList());
    }

    totalSize = appointmentsByFilter.size();


    for(int i = 0; i < totalSize; i += partitionSize) {
      appointmentTimes.add(appointmentsByFilter.subList(i, Math.min(i + partitionSize, totalSize)));
      appointmentDays.add(appointmentsByFilter.get(i));
    }
    appointmentClockPanel = true;
  }

  public void holdAppointment() {
    appointmentService.holdAppointmentForPatient(appointmentModel, patientModel);
  }

  public void clearAppointment() {
    appointmentService.clearAppointment(appointmentModel);
  }

  public String confirmAppointment() {
    if(patientService.haveAnAppointmentForThatDay(patientModel, appointmentModel.getAppointmentDate())) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("appointment.confirm.sameday"), null));
      appointmentService.clearAppointment(appointmentModel);
    } else if(patientService.getActiveAppointmentsOfPatient(patientModel).size() >= 3) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("appointment.confirm.maxlimit"), null));
      appointmentService.clearAppointment(appointmentModel);
    } else {
      appointmentService.confirmAppointment(appointmentModel, patientModel);
      new Mailer().sendAppointmentMail(appointmentModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("appointment.confirm.successful"), null));
    }
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/take-appointment?faces-redirect=true";
  }

  public void clearSearch() {
    clearMapComponentsWithChange(cities, districts, hospitals, policlinics, inspectionPlaces);
    clearListComponentsWithChange(appointmentsHeaders, appointmentTimes, appointmentDays, doctorReviewList);
    appointmentPanel = false;
    appointmentClockPanel = false;
    appointmentSearchNull = false;

    for(CityModel cityModel : cityService.getCities()) {
      cities.put(cityModel.getPk(), cityModel.getCityName());
    }
    selectedCity = bundle.getString("label.selectCity");
  }

  public String cancelAppointment() {
    Calendar today = Calendar.getInstance();
    today.setTime(new Date());

    Calendar appointmentDate = Calendar.getInstance();
    appointmentDate.setTime(appointmentModel.getAppointmentDate());

    boolean sameDay = today.get(Calendar.YEAR) == appointmentDate.get(Calendar.YEAR) && today.get(Calendar.DAY_OF_YEAR) == appointmentDate.get(Calendar.DAY_OF_YEAR);

    if(sameDay) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("appointment.cancel.sameday"), null));
    } else {
      appointmentService.clearAppointment(appointmentModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("appointment.cancel.successful"), null));
    }

    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/appointments?faces-redirect=true";
  }

  public String sendDoctorComment() {
    if(getPatientReviewAboutDoctor(patientModel, appointmentModel.getInspectionPlace().getDoctor()).size() > 0) {
      reviewsAboutDoctorsModel = getPatientReviewAboutDoctor(patientModel, appointmentModel.getInspectionPlace().getDoctor()).get(0);
      reviewsAboutDoctorsModel.setReview(doctorComment);
      reviewsAboutDoctorsModel.setIsAppropriate('0');
      reviewsAboutDoctorsService.update(reviewsAboutDoctorsModel);
    } else {
      reviewsAboutDoctorsModel.setPatient(patientModel);
      reviewsAboutDoctorsModel.setDoctor(appointmentModel.getInspectionPlace().getDoctor());
      reviewsAboutDoctorsModel.setReview(doctorComment);
      reviewsAboutDoctorsService.create(reviewsAboutDoctorsModel);
    }

    if(FacesContext.getCurrentInstance().getViewRoot().getViewId().equals("/view/dashboard.xhtml")) {
      return "/view/dashboard?faces-redirect=true";
    } else
      return "/view/appointments?faces-redirect=true";
  }

  public List<ReviewsAboutDoctorsModel> getPatientReviewAboutDoctor(PatientModel patientModel, DoctorModel doctorModel) {
    return reviewsAboutDoctorsService.getPatientReviewAboutDoctor(patientModel, doctorModel);
  }

  public void doctorReviews(DoctorModel doctorModel) {
    clearListComponentsWithChange(doctorReviewList);
    doctorReviewList.addAll(reviewsAboutDoctorsService.getReviewsAboutDoctor(doctorModel));
  }
}
