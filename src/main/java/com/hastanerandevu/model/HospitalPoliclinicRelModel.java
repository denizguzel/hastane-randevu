package com.hastanerandevu.model;

import java.util.Date;

// TODO mapping gerekli
public class HospitalPoliclinicRelModel {
  private long pk;
  private HospitalModel hospitalModel;
  private PoliclinicModel policlinicModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public HospitalModel getHospitalModel () {
    return hospitalModel;
  }

  public void setHospitalModel (HospitalModel hospitalModel) {
    this.hospitalModel = hospitalModel;
  }

  public PoliclinicModel getPoliclinicModel () {
    return policlinicModel;
  }

  public void setPoliclinicModel (PoliclinicModel policlinicModel) {
    this.policlinicModel = policlinicModel;
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
