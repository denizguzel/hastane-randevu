package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class CityModel {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  @Column (name = "PK")
  private long pk;

  @Column (name = "CITY_NAME")
  private String cityName;

  @Column (name = "CREATION_TIME")
  private Date modifiedTime;

  @Column (name = "MODIFIED_TIME")
  private Date creationTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "city")
  private List<DistrictModel> districtModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getCityName () {
    return cityName;
  }

  public void setCityName (String cityName) {
    this.cityName = cityName;
  }

  public Date getModifiedTime () {
    return modifiedTime;
  }

  public void setModifiedTime (Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public Date getCreationTime () {
    return creationTime;
  }

  public void setCreationTime (Date creationTime) {
    this.creationTime = creationTime;
  }

  public char getIsActive () {
    return isActive;
  }

  public void setIsActive (char isActive) {
    this.isActive = isActive;
  }

  public List<DistrictModel> getDistrictModels () {
    return districtModels;
  }

  public void setDistrictModels (List<DistrictModel> districtModels) {
    this.districtModels = districtModels;
  }
}
