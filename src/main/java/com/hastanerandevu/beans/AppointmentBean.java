package com.hastanerandevu.beans;

import com.hastanerandevu.model.*;
import com.hastanerandevu.service.impl.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@ManagedBean(name = "appointment")
@SessionScoped
public class AppointmentBean implements Serializable {
  private HospitalPoliclinicRelServiceImpl hospitalPoliclinicRelService = new HospitalPoliclinicRelServiceImpl();
  private CityServiceImpl cityService = new CityServiceImpl();
  private DistrictServiceImpl districtService = new DistrictServiceImpl();
  private HospitalServiceImpl hospitalService = new HospitalServiceImpl();
  private PoliclinicServiceImpl policlinicService = new PoliclinicServiceImpl();

  private String selectedCity = "";
  private String selectedDistrict = "";
  private String selectedHospital = "";
  private String selectedPoliclinic = "";
  private String selectedInspectionPlace = "";

  private Map<Long, String> cities;
  private Map<Long, String> districts;
  private Map<Long, String> hospitals;
  private Map<Long, String> policlinics;
  private Map<Long, String> inspectionPlaces;

  public AppointmentBean() {
    cities = new LinkedHashMap();
    districts = new LinkedHashMap();
    hospitals = new LinkedHashMap();
    policlinics = new LinkedHashMap();
    inspectionPlaces = new LinkedHashMap();
    for(CityModel cityModel : cityService.getCities()) {
      cities.put(cityModel.getPk(), cityModel.getCityName());
    }
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

  public void setInspectionPlaces(LinkedHashMap inspectionPlaces) {
    this.inspectionPlaces = inspectionPlaces;
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
      selectedCity = input.getValue().toString();
    }

    for(DistrictModel districtModel : cityService.getAllDistrictsByCity(cityService.find(Long.parseLong(selectedCity)))) {
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
      selectedDistrict = input.getValue().toString();
    }

    for(HospitalModel hospitalModel : districtService.getHospitalsByDistrict(districtService.find(Long.parseLong(selectedDistrict)))) {
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
      selectedHospital = input.getValue().toString();
    }


    for(HospitalPoliclinicRelModel hospitalPoliclinicRelModel : hospitalService.getPoliclinicByHospital(hospitalService.find(Long.parseLong(selectedHospital)))) {
      policlinics.put(hospitalPoliclinicRelModel.getPk(), hospitalPoliclinicRelModel.getPoliclinic().getPoliclinicName());
    }
  }

  public void changePoliclinic(AjaxBehaviorEvent event) {
    inspectionPlaces.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedPoliclinic = input.getValue().toString();
    }

    for(InspectionPlaceModel inspectionPlaceModel : policlinicService.getInspectionPlacesByHospitalPoliclinicRel(hospitalPoliclinicRelService.find(Long.parseLong(selectedPoliclinic)))) {
      inspectionPlaces.put(inspectionPlaceModel.getPk(), inspectionPlaceModel.getPlaceName());
    }
  }
}
