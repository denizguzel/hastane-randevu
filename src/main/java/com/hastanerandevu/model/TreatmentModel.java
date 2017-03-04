package com.hastanerandevu.model;

import java.util.Date;

public class TreatmentModel {
  private long pk;
  private String treatmentName;
  private TreatmentTypeModel treatmentTypeModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getTreatmentName () {
    return treatmentName;
  }

  public void setTreatmentName (String treatmentName) {
    this.treatmentName = treatmentName;
  }

  public TreatmentTypeModel getTreatmentTypeModel () {
    return treatmentTypeModel;
  }

  public void setTreatmentTypeModel (TreatmentTypeModel treatmentTypeModel) {
    this.treatmentTypeModel = treatmentTypeModel;
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
