package com.hastanerandevu.beans;

import com.hastanerandevu.converter.NameConverter;
import com.hastanerandevu.model.*;
import com.hastanerandevu.service.impl.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "appointment")
@ViewScoped
public class AppointmentBean implements Serializable {
  private HospitalPoliclinicRelServiceImpl hospitalPoliclinicRelService;
  private CityServiceImpl cityService;
  private DistrictServiceImpl districtService;
  private HospitalServiceImpl hospitalService;
  private PoliclinicServiceImpl policlinicService;
  private InspectionPlaceServiceImpl inspectionPlaceService;

  private boolean appointmentClockPanel = false;
  private boolean appointmentPanel = false;
  private boolean appointmentSearchNull = false;
  private Long selectedCity;
  private Long selectedDistrict;
  private Long selectedHospital;
  private Long selectedPoliclinic;
  private Long selectedInspectionPlace;

  private Map<Long, String> cities;
  private Map<Long, String> districts;
  private Map<Long, String> hospitals;
  private Map<Long, String> policlinics;
  private Map<Long, String> inspectionPlaces;
  private List<InspectionPlaceModel> appointments;
  private List<AppointmentModel> appointmentClocks;

  @SuppressWarnings("unchecked")
  @PostConstruct
  public void init() {
    cities = new LinkedHashMap();
    districts = new LinkedHashMap();
    hospitals = new LinkedHashMap();
    policlinics = new LinkedHashMap();
    inspectionPlaces = new LinkedHashMap();
    appointments = new ArrayList<>();
    appointmentClocks = new ArrayList<>();

    cityService = new CityServiceImpl();
    for(CityModel cityModel : cityService.getCities()) {
      cities.put(cityModel.getPk(), cityModel.getCityName());
    }
  }

  public Long getSelectedCity() {
    return selectedCity;
  }

  public void setSelectedCity(Long selectedCity) {
    this.selectedCity = selectedCity;
  }

  public Long getSelectedDistrict() {
    return selectedDistrict;
  }

  public void setSelectedDistrict(Long selectedDistrict) {
    this.selectedDistrict = selectedDistrict;
  }

  public Long getSelectedHospital() {
    return selectedHospital;
  }

  public void setSelectedHospital(Long selectedHospital) {
    this.selectedHospital = selectedHospital;
  }

  public Long getSelectedPoliclinic() {
    return selectedPoliclinic;
  }

  public void setSelectedPoliclinic(Long selectedPoliclinic) {
    this.selectedPoliclinic = selectedPoliclinic;
  }

  public Long getSelectedInspectionPlace() {
    return selectedInspectionPlace;
  }

  public void setSelectedInspectionPlace(Long selectedInspectionPlace) {
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

  public List<InspectionPlaceModel> getAppointments() {
    return appointments;
  }

  public void setAppointments(List<InspectionPlaceModel> appointments) {
    this.appointments = appointments;
  }

  public List<AppointmentModel> getAppointmentClocks() {
    return appointmentClocks;
  }

  public void setAppointmentClocks(List<AppointmentModel> appointmentClocks) {
    this.appointmentClocks = appointmentClocks;
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

  // Functions
  public void changeCity(AjaxBehaviorEvent event) {
    districts.clear();
    hospitals.clear();
    policlinics.clear();
    inspectionPlaces.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedCity = (Long) input.getValue();
    }

    for(DistrictModel districtModel : cityService.getAllDistrictsByCity(cityService.find(selectedCity))) {
      districts.put(districtModel.getPk(), districtModel.getDistrictName());
    }
    setAppointmentPanel(false);
    setAppointmentClockPanel(false);
    setAppointmentSearchNull(false);
  }

  public void changeDistrict(AjaxBehaviorEvent event) {
    hospitals.clear();
    policlinics.clear();
    inspectionPlaces.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedDistrict = (Long) input.getValue();
    }

    districtService = new DistrictServiceImpl();

    for(HospitalModel hospitalModel : districtService.getHospitalsByDistrict(districtService.find(selectedDistrict))) {
      hospitals.put(hospitalModel.getPk(), hospitalModel.getHospitalName());
    }
    setAppointmentPanel(false);
    setAppointmentClockPanel(false);
    setAppointmentSearchNull(false);
  }

  public void changeHospital(AjaxBehaviorEvent event) {
    policlinics.clear();
    inspectionPlaces.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedHospital = (Long) input.getValue();
    }

    hospitalService = new HospitalServiceImpl();

    for(HospitalPoliclinicRelModel hospitalPoliclinicRelModel : hospitalService.getPoliclinicByHospital(hospitalService.find(selectedHospital))) {
      policlinics.put(hospitalPoliclinicRelModel.getPk(), hospitalPoliclinicRelModel.getPoliclinic().getPoliclinicName());
    }
    setAppointmentPanel(false);
    setAppointmentClockPanel(false);
    setAppointmentSearchNull(false);
  }

  public void changePoliclinic(AjaxBehaviorEvent event) {
    inspectionPlaces.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedPoliclinic = (Long) input.getValue();
    }

    policlinicService = new PoliclinicServiceImpl();
    hospitalPoliclinicRelService = new HospitalPoliclinicRelServiceImpl();

    for(InspectionPlaceModel inspectionPlaceModel : policlinicService.getInspectionPlacesByHospitalPoliclinicRel(hospitalPoliclinicRelService.find(selectedPoliclinic))) {
      StringBuilder str = new StringBuilder(inspectionPlaceModel.getPlaceName());
      if(inspectionPlaceModel.getDoctor() != null) {
        str.append(" ").append(NameConverter.getName(inspectionPlaceModel.getDoctor().getFirstName(), inspectionPlaceModel.getDoctor().getLastName()));
      }
      inspectionPlaces.put(inspectionPlaceModel.getPk(), String.valueOf(str));
    }
    setAppointmentPanel(false);
    setAppointmentClockPanel(false);
    setAppointmentSearchNull(false);
  }

  public void changeInspectionPlace(AjaxBehaviorEvent event) {
    appointments.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedInspectionPlace = (Long) input.getValue();
    }
    setAppointmentPanel(false);
    setAppointmentClockPanel(false);
    setAppointmentSearchNull(false);
  }

  public void searchAppointment() {
    appointmentClocks.clear();

    inspectionPlaceService = new InspectionPlaceServiceImpl();

    for(InspectionPlaceModel inspectionPlaceModel : inspectionPlaceService.getAppointments(inspectionPlaceService.find(selectedInspectionPlace))) {
      if(inspectionPlaceModel.getDoctor() != null) {
        appointments.add(inspectionPlaceModel);
      } else {
        setAppointmentSearchNull(true);
      }
    }
    setAppointmentPanel(true);
  }

  public void selectAppointment() {
    appointmentClocks.addAll(inspectionPlaceService.getAllAppointmentsByInspectionPlace(inspectionPlaceService.find(selectedInspectionPlace)));
    setAppointmentClockPanel(true);
  }
}
