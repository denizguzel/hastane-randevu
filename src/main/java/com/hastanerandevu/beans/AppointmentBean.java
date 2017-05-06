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
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "appointment")
@ViewScoped
public class AppointmentBean implements Serializable {

  private static final Logger LOG = Logger.getLogger(AppointmentBean.class);

  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  private HospitalPoliclinicRelServiceImpl hospitalPoliclinicRelService;
  private CityServiceImpl cityService;
  private DistrictServiceImpl districtService;
  private HospitalServiceImpl hospitalService;
  private PoliclinicServiceImpl policlinicService;
  private InspectionPlaceServiceImpl inspectionPlaceService;
  private AppointmentServiceImpl appointmentService;
  private PatientServiceImpl patientService;
  private AppointmentModel appointmentModel;

  private boolean appointmentClockPanel = false;
  private boolean appointmentPanel = false;
  private boolean appointmentSearchNull = false;
  private String selectedCity;
  private String selectedDistrict;
  private String selectedHospital;
  private String selectedPoliclinic;
  private String selectedInspectionPlace;

  private Map<Long, String> cities;
  private Map<Long, String> districts;
  private Map<Long, String> hospitals;
  private Map<Long, String> policlinics;
  private Map<Long, String> inspectionPlaces;
  private List<InspectionPlaceModel> appointmentsHeaders;
  private List<List<AppointmentModel>> appointmentTimes;
  private List<AppointmentModel> appointmentDays;
  private List<AppointmentModel> appointmentHistory;

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
    appointmentModel = new AppointmentModel();

    appointmentsHeaders = new ArrayList<>();
    appointmentDays = new ArrayList<>();
    appointmentTimes = new LinkedList<>();
    appointmentHistory = new LinkedList<>();

    for(CityModel cityModel : cityService.getCities()) {
      cities.put(cityModel.getPk(), cityModel.getCityName());
    }

    appointmentHistory.addAll(patientService.getAppointmentHistory(loginBean.getPatientModel()));
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

  // Functions
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

    clearListComponentsWithChange(appointmentTimes, appointmentsHeaders, appointmentDays);

    if(selectedInspectionPlace != null && !selectedInspectionPlace.isEmpty()) {
      InspectionPlaceModel inspectionPlaceModel = inspectionPlaceService.find(Long.parseLong(selectedInspectionPlace));
      if(inspectionPlaceModel.getDoctor() != null) {
        appointmentsHeaders.add(inspectionPlaceModel);
      } else {
        appointmentSearchNull = true;
      }
    } else {
      for(InspectionPlaceModel inspectionPlaceModel : policlinicService.getInspectionPlacesByHospitalPoliclinicRel(hospitalPoliclinicRelService.find(Long.parseLong(selectedPoliclinic)))) {
        if(inspectionPlaceModel.getDoctor() != null) {
          appointmentsHeaders.add(inspectionPlaceModel);
        } else {
          appointmentSearchNull = true;
        }
      }
    }
    appointmentPanel = true;
  }

  public void selectAppointment(InspectionPlaceModel inspectionPlaceModel) {

    clearListComponentsWithChange(appointmentTimes, appointmentDays);

    byte partitionSize = 17;
    int totalSize = appointmentService.getAllAppointmentsByInspectionPlace(inspectionPlaceModel).size();
    for(int i = 0; i < totalSize; i += partitionSize) {
      appointmentTimes.add(appointmentService.getAllAppointmentsByInspectionPlace(inspectionPlaceModel).subList(i, Math.min(i + partitionSize, totalSize)));
      appointmentDays.add(appointmentService.getAllAppointmentsByInspectionPlace(inspectionPlaceModel).get(i));
    }
    appointmentClockPanel = true;
  }

  public void holdAppointment() {
    appointmentService.holdAppointmentForPatient(appointmentModel, loginBean.getPatientModel());
  }

  public void clearAppointment() {
    appointmentService.clearAppointment(appointmentModel);
  }

  public String confirmAppointment() {
    if(patientService.haveAnAppointmentForThatDay(loginBean.getPatientModel(), appointmentModel.getAppointmentDate())) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aynı güne birden fazla randevu alamazsınız.", null));
      appointmentService.clearAppointment(appointmentModel);
    } else if(patientService.getNumberOfPatientAppointments(loginBean.getPatientModel()) > 3) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "En fazla 3 randevu alabilirsiniz.", null));
      appointmentService.clearAppointment(appointmentModel);
    } else {
      appointmentService.confirmAppointment(appointmentModel, loginBean.getPatientModel());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Randevu Alımı Başarılı", null));
    }
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/take-appointment?faces-redirect=true";
  }

  public void clearSearch() {
    clearMapComponentsWithChange(cities, districts, hospitals, policlinics, inspectionPlaces);
    clearListComponentsWithChange(appointmentsHeaders, appointmentTimes, appointmentDays);
    appointmentPanel = false;
    appointmentClockPanel = false;
    appointmentSearchNull = false;

    for(CityModel cityModel : cityService.getCities()) {
      cities.put(cityModel.getPk(), cityModel.getCityName());
    }
    selectedCity = "İl Seçiniz";
  }

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

  public String cancelAppointment() {
    Calendar today = Calendar.getInstance();
    today.setTime(new Date());

    Calendar appointmentDate = Calendar.getInstance();
    appointmentDate.setTime(appointmentService.find(appointmentModel.getPk()).getAppointmentDate());

    boolean sameDay = today.get(Calendar.YEAR) == appointmentDate.get(Calendar.YEAR) && today.get(Calendar.DAY_OF_YEAR) == appointmentDate.get(Calendar.DAY_OF_YEAR);
    appointmentDate.add(Calendar.DAY_OF_MONTH, -1);

    if(sameDay || today.equals(appointmentDate)) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Randevu İptal Edilemedi", null));
    } else {
      appointmentService.clearAppointment(appointmentModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Randevu İptal Edildi", null));
    }

    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/appointments?faces-redirect=true";
  }
}
