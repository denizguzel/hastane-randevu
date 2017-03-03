package com.hastanerandevu.model;

import java.util.Date;

/**
 * Created by Okan on 3.3.2017.
 */
public class CityModel {
  long pk;
  String cityName;
  Date creationTime;
  Date modifiedTime;
  char isActive;

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
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
}
