package com.hastanerandevu.model;

import java.util.Date;

// TODO mapping gerekli
public class ReviewsAboutDoctorsModel {
  private long pk;
  private PatientModel patientModel;
  private DoctorModel doctorModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;
  private char isAppropriate;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public PatientModel getPatientModel () {
    return patientModel;
  }

  public void setPatientModel (PatientModel patientModel) {
    this.patientModel = patientModel;
  }

  public DoctorModel getDoctorModel () {
    return doctorModel;
  }

  public void setDoctorModel (DoctorModel doctorModel) {
    this.doctorModel = doctorModel;
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

  public char getIsAppropriate () {
    return isAppropriate;
  }

  public void setIsAppropriate (char isAppropriate) {
    this.isAppropriate = isAppropriate;
  }
}
