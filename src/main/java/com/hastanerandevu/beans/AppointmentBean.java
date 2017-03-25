package com.hastanerandevu.beans;

import com.hastanerandevu.model.*;
import com.hastanerandevu.service.CityServiceImpl;
import com.hastanerandevu.service.DistrictServiceImpl;
import com.hastanerandevu.service.HospitalServiceImpl;
import com.hastanerandevu.service.PoliclinicServiceImpl;

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
  private HospitalPoliclinicRelModel hospitalPoliclinicRelModel = new HospitalPoliclinicRelModel();
  private InspectionPlaceModel inspectionPlaceModel = new InspectionPlaceModel();

  private String value = "";
  private Map<String, String> city;
  private Map<String, String> district;
  private Map<String, String> hospital;
  private Map<String, String> policlinic;
  private Map<String, String> inspectionPlace;

  public AppointmentBean() {
    city = new LinkedHashMap<>();
    district = new LinkedHashMap<>();
    hospital = new LinkedHashMap<>();
    policlinic = new LinkedHashMap<>();
    inspectionPlace = new LinkedHashMap<>();
    city = cityService.getCities();
  }

  public Map<String, String> getCity() {
    return city;
  }

  public void setCity(Map<String, String> city) {
    this.city = city;
  }

  public Map<String, String> getDistrict() {
    return district;
  }

  public void setDistrict(Map<String, String> district) {
    this.district = district;
  }

  public Map<String, String> getHospital() {
    return hospital;
  }

  public void setHospital(Map<String, String> hospital) {
    this.hospital = hospital;
  }

  public Map<String, String> getPoliclinic() {
    return policlinic;
  }

  public void setPoliclinic(Map<String, String> policlinic) {
    this.policlinic = policlinic;
  }

  public Map<String, String> getInspectionPlace() {
    return inspectionPlace;
  }

  public void setInspectionPlace(Map<String, String> inspectionPlace) {
    this.inspectionPlace = inspectionPlace;
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
    district.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      value = input.getValue().toString();
    }

    cityModel.setPk(Long.parseLong(value));
    district = cityService.getAllDistrictsByCity(cityModel);
  }

  public void changeDistrict(AjaxBehaviorEvent event) {
    hospital.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      value = input.getValue().toString();
    }

    districtModel.setPk(Long.parseLong(value));
    hospital = districtService.getHospitalByDistrict(districtModel);
  }

  public void changeHospital(AjaxBehaviorEvent event) {
    policlinic.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      value = input.getValue().toString();
    }

    hospitalModel.setPk(Long.parseLong(value));
    policlinic = hospitalService.getPoliclinicByHospital(hospitalModel);
  }

  public void changePoliclinic(AjaxBehaviorEvent event) {
    inspectionPlace.clear();

    if(event == null) {
      System.out.println("Ajax event is null");
    } else {
      UIInput input = (UIInput) event.getSource();
      value = input.getValue().toString();
    }

    hospitalPoliclinicRelModel.setPk(Long.parseLong(value));
    inspectionPlace = policlinicService.getInspectionPlaceByPoliclinic(hospitalPoliclinicRelModel);
  }
}
