package com.hastanerandevu.model;

import java.util.Date;

// TODO mapping gerekli
public class InspectionPlaceDoctorRelModel {
  private long pk;
  private InspectionPlaceModel inspectionPlaceModel;
  private DoctorModel doctorModel;
  private Date activeFrom;
  private Date activeTo;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public InspectionPlaceModel getInspectionPlaceModel () {
    return inspectionPlaceModel;
  }

  public void setInspectionPlaceModel (InspectionPlaceModel inspectionPlaceModel) {
    this.inspectionPlaceModel = inspectionPlaceModel;
  }

  public DoctorModel getDoctorModel () {
    return doctorModel;
  }

  public void setDoctorModel (DoctorModel doctorModel) {
    this.doctorModel = doctorModel;
  }

  public Date getActiveFrom () {
    return activeFrom;
  }

  public void setActiveFrom (Date activeFrom) {
    this.activeFrom = activeFrom;
  }

  public Date getActiveTo () {
    return activeTo;
  }

  public void setActiveTo (Date activeTo) {
    this.activeTo = activeTo;
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

