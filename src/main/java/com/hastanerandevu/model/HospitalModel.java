package com.hastanerandevu.model;

import java.util.Date;

public class HospitalModel {
  private long pk;
  private String hospitalName;
  private String hospitalAddress;
  private HospitalTypeModel hospitalTypeModel;
  private DistrictModel districtModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getHospitalName () {
    return hospitalName;
  }

  public void setHospitalName (String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public String getHospitalAddress () {
    return hospitalAddress;
  }

  public void setHospitalAddress (String hospitalAddress) {
    this.hospitalAddress = hospitalAddress;
  }

  public HospitalTypeModel getHospitalTypeModel () {
    return hospitalTypeModel;
  }

  public void setHospitalTypeModel (HospitalTypeModel hospitalTypeModel) {
    this.hospitalTypeModel = hospitalTypeModel;
  }

  public DistrictModel getDistrictModel () {
    return districtModel;
  }

  public void setDistrictModel (DistrictModel districtModel) {
    this.districtModel = districtModel;
  }

  public Date getCreationTime () {
    return creationTime;
  }

  public void setCreationTime (Date creationTime) {
    this.creationTime = creationTime;
  }

  public Date getModifiedTime () {
    return modifiedTime;
  }

  public void setModifiedTime (Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public char getIsActive () {
    return isActive;
  }

  public void setIsActive (char isActive) {
    this.isActive = isActive;
  }
}
