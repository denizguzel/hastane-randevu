package com.hastanerandevu.model;

import java.util.Date;

// TODO mapping gerekli
public class AppointmentModel {
  private long pk;
  private Date appointmentDate;
  private AppointmentStatusModel appointmentStatusModel;
  private AppointmentChartModel appointmentChartModel;
  private PatientModel patientModel;
  private Date creationTime;
  private Date modifiedTime;
  private char isActive;

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

  public AppointmentStatusModel getAppointmentStatusModel () {
    return appointmentStatusModel;
  }

  public void setAppointmentStatusModel (AppointmentStatusModel appointmentStatusModel) {
    this.appointmentStatusModel = appointmentStatusModel;
  }

  public AppointmentChartModel getAppointmentChartModel () {
    return appointmentChartModel;
  }

  public void setAppointmentChartModel (AppointmentChartModel appointmentChartModel) {
    this.appointmentChartModel = appointmentChartModel;
  }

  public PatientModel getPatientModel () {
    return patientModel;
  }

  public void setPatientModel (PatientModel patientModel) {
    this.patientModel = patientModel;
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
