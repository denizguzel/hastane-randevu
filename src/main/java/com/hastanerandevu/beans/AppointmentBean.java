package com.hastanerandevu.beans;

import com.hastanerandevu.model.*;
import com.hastanerandevu.service.impl.CityServiceImpl;
import com.hastanerandevu.service.impl.DistrictServiceImpl;
import com.hastanerandevu.service.impl.HospitalServiceImpl;
import com.hastanerandevu.service.impl.PoliclinicServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@ManagedBean(name = "appointment")
@ViewScoped
public class AppointmentBean implements Serializable {
  private CityServiceImpl cityService = new CityServiceImpl();
  private DistrictServiceImpl districtService = new DistrictServiceImpl();
  private HospitalServiceImpl hospitalService = new HospitalServiceImpl();
  private PoliclinicServiceImpl policlinicService = new PoliclinicServiceImpl();

  private CityModel cityModel = new CityModel();
  private DistrictModel districtModel = new DistrictModel();
  private HospitalModel hospitalModel = new HospitalModel();
  private PoliclinicModel policlinicModel = new PoliclinicModel();
  private HospitalPoliclinicRelModel hospitalPoliclinicRelModel = new HospitalPoliclinicRelModel();
  private InspectionPlaceModel inspectionPlaceModel = new InspectionPlaceModel();

  private String selectedCity = "";
  private String selectedDistrict = "";
  private String selectedHospital = "";
  private String selectedPoliclinic = "";
  private String selectedInspectionPlace = "";


  private Map<Long,String> cities;
  private Map<Long,String> districts;
  private Map<Long,String> hospitals;
  private Map<Long,String> policlinics;
  private Map<Long,String> inspectionPlaces;

  public AppointmentBean() {
    cities = new LinkedHashMap();
    districts = new LinkedHashMap();
    hospitals = new LinkedHashMap();
    policlinics = new LinkedHashMap();
    inspectionPlaces = new LinkedHashMap();
    for (CityModel cityModel : cityService.getCities()){
      cities.put(cityModel.getPk(),cityModel.getCityName());
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

  public CityModel getCityModel() {
    return cityModel;
  }

  public void setCityModel(CityModel cityModel) {
    this.cityModel = cityModel;
  }

  public DistrictModel getDistrictModel() {
    return districtModel;
  }

  public void setDistrictModel(DistrictModel districtModel) {
    this.districtModel = districtModel;
  }

  public HospitalModel getHospitalModel() {
    return hospitalModel;
  }

  public void setHospitalModel(HospitalModel hospitalModel) {
    this.hospitalModel = hospitalModel;
  }

  public HospitalPoliclinicRelModel getHospitalPoliclinicRelModel() {
    return hospitalPoliclinicRelModel;
  }

  public void setHospitalPoliclinicRelModel(HospitalPoliclinicRelModel hospitalPoliclinicRelModel) {
    this.hospitalPoliclinicRelModel = hospitalPoliclinicRelModel;
  }

  public InspectionPlaceModel getInspectionPlaceModel() {
    return inspectionPlaceModel;
  }

  public void setInspectionPlaceModel(InspectionPlaceModel inspectionPlaceModel) {
    this.inspectionPlaceModel = inspectionPlaceModel;
  }

  public void changeCity(AjaxBehaviorEvent event) {
    districts.clear();
    hospitals.clear();
    policlinics.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedCity = input.getValue().toString();
    }

    for (DistrictModel districtModel : cityService.getAllDistrictsByCity(cityService.find(Long.parseLong(selectedCity)))){
      districts.put(districtModel.getPk(),districtModel.getDistrictName());
    }
  }

  public void changeDistrict(AjaxBehaviorEvent event) {
    hospitals.clear();
    policlinics.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedDistrict = input.getValue().toString();
    }

    //districtModel.setPk(Long.parseLong(value));
    for (HospitalModel hospitalModel : districtService.getHospitalsByDistrict(districtService.find(Long.parseLong(selectedDistrict)))){
      hospitals.put(hospitalModel.getPk(),hospitalModel.getHospitalName());
    }
  }

  public void changeHospital(AjaxBehaviorEvent event) {
    policlinics.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      selectedHospital = input.getValue().toString();
    }


    for (PoliclinicModel policlinicModel : hospitalService.getPoliclinicByHospital(hospitalService.find(Long.parseLong(selectedHospital)))){
      policlinics.put(policlinicModel.getPk(),policlinicModel.getPoliclinicName());
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
    hospitalModel = hospitalService.find(Long.parseLong(selectedHospital));
    policlinicModel = policlinicService.find(Long.parseLong(selectedPoliclinic));

    for (InspectionPlaceModel inspectionPlaceModel : policlinicService.getInspectionPlacesByHospitalPoliclinic(hospitalModel,policlinicModel)){
      inspectionPlaces.put(inspectionPlaceModel.getPk(),inspectionPlaceModel.getPlaceName());
    }
  }
}
