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

  private boolean appointmentTable = false;
  private String hospitalName;
  private String policlinicName;
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
  private List<AppointmentModel> appointments;

  @SuppressWarnings("unchecked")
  @PostConstruct
  public void init() {
    cities = new LinkedHashMap();
    districts = new LinkedHashMap();
    hospitals = new LinkedHashMap();
    policlinics = new LinkedHashMap();
    inspectionPlaces = new LinkedHashMap();
    appointments = new ArrayList<>();

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

  public List<AppointmentModel> getAppointments() {
    return appointments;
  }

  public void setAppointments(List<AppointmentModel> appointments) {
    this.appointments = appointments;
  }

  public boolean isAppointmentTable() {
    return appointmentTable;
  }

  public void setAppointmentTable(boolean appointmentTable) {
    this.appointmentTable = appointmentTable;
  }

  public String getHospitalName() {
    return hospitalName;
  }

  public String getPoliclinicName() {
    return policlinicName;
  }

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
  }

  public void changeInspectionPlace(AjaxBehaviorEvent event) {
    appointments.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedInspectionPlace = (Long) input.getValue();
    }

    inspectionPlaceService = new InspectionPlaceServiceImpl();

    for(AppointmentModel appointmentModel : inspectionPlaceService.getAllAppointmentsByInspectionPlace(inspectionPlaceService.find(selectedInspectionPlace))) {
      appointments.add(new AppointmentModel(appointmentModel.getAppointmentDate(), appointmentModel.getAppointmentStatus(), appointmentModel.getInspectionPlace()));
    }
  }

  public void listAppointments() {
    appointmentTable = true;
    hospitalName = hospitalService.find(selectedHospital).getHospitalName();
    policlinicName = hospitalPoliclinicRelService.find(selectedPoliclinic).getPoliclinic().getPoliclinicName();
  }
}
