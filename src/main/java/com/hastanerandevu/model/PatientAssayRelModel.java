package com.hastanerandevu.model;

import java.util.Date;

// TODO mapping gerekli
public class PatientAssayRelModel {
  private long pk;
  private AssayModel assayModel;
  private PatientModel patientModel;
  private String assayResult;
  private String assayDetail;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public AssayModel getAssayModel () {
    return assayModel;
  }

  public void setAssayModel (AssayModel assayModel) {
    this.assayModel = assayModel;
  }

  public PatientModel getPatientModel () {
    return patientModel;
  }

  public void setPatientModel (PatientModel patientModel) {
    this.patientModel = patientModel;
  }

  public String getAssayResult () {
    return assayResult;
  }

  public void setAssayResult (String assayResult) {
    this.assayResult = assayResult;
  }

  public String getAssayDetail () {
    return assayDetail;
  }

  public void setAssayDetail (String assayDetail) {
    this.assayDetail = assayDetail;
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
