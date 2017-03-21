package com.hastanerandevu.beans;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.service.CityServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "appointment")
@SessionScoped
public class AppointmentBean implements Serializable {
  private CityServiceImpl cityService = new CityServiceImpl();

  private CityModel cityModel = new CityModel();
  private DistrictModel districtModel = new DistrictModel();

  public CityServiceImpl getCityService() {
    return cityService;
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

  public List<CityModel> getCities() {
    return cityService.getCities();
  }

  public List<DistrictModel> getDistrictsByCity() {
    return cityService.getAllDistrictsByCity(cityModel);
  }
}
