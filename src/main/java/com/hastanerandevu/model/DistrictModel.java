package com.hastanerandevu.model;

import java.util.Date;

/**
 * Created by Okan on 3.3.2017.
 */
public class DistrictModel {
  long pk;
  String districtName;
  Date creationTime;
  Date modifiedTime;
  char isActive;
  CityModel cityModel;

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public String getDistrictName() {
    return districtName;
  }

  public void setDistrictName(String districtName) {
    this.districtName = districtName;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public char getIsActive() {
    return isActive;
  }

  public void setIsActive(char isActive) {
    this.isActive = isActive;
  }

  public CityModel getCityModel() {
    return cityModel;
  }

  public void setCityModel(CityModel cityModel) {
    this.cityModel = cityModel;
  }
}
