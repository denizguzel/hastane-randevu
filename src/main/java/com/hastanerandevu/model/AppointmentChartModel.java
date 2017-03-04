package com.hastanerandevu.model;

import java.util.Date;

public class AppointmentChartModel {
  private long pk;
  private Date appointmentDate;
  private InspectionPlaceDoctorRelModel inspectionPlaceDoctorRelModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;
  private char isReserved;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public Date getAppointmentDate () {
    return appointmentDate;
  }

  public void setAppointmentDate (Date appointmentDate) {
    this.appointmentDate = appointmentDate;
  }

  public InspectionPlaceDoctorRelModel getInspectionPlaceDoctorRelModel () {
    return inspectionPlaceDoctorRelModel;
  }

  public void setInspectionPlaceDoctorRelModel (InspectionPlaceDoctorRelModel inspectionPlaceDoctorRelModel) {
    this.inspectionPlaceDoctorRelModel = inspectionPlaceDoctorRelModel;
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

  public char getIsReserved () {
    return isReserved;
  }

  public void setIsReserved (char isReserved) {
    this.isReserved = isReserved;
  }
}
