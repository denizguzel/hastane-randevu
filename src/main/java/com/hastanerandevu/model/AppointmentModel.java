package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

// TODO service ve dao gerekli
@Entity
@Table (name = "appointment")
public class AppointmentModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "APPOINTMENT_DATE")
  private Date appointmentDate;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_APPOINTMENT_STATUS")
  private AppointmentStatusModel appointmentStatusModel;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_APPOINTMENT_CHART")
  private AppointmentChartModel appointmentChartModel;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_PATIENT")
  private PatientModel patientModel;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
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
