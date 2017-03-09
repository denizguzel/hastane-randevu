package com.hastanerandevu.model;

import com.hastanerandevu.enums.AppointmentStatusEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "appointment")
public class AppointmentModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "APPOINTMENT_DATE")
  private Date appointmentDate;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @Enumerated (EnumType.STRING)
  @JoinColumn (name = "APPOINTMENT_STATUS")
  private AppointmentStatusEnum appointmentStatus;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_APPOINTMENT_CHART")
  private AppointmentChartModel appointmentChart;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_PATIENT")
  private PatientModel patient;

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

  public AppointmentChartModel getAppointmentChart() {
    return appointmentChart;
  }

  public void setAppointmentChart(AppointmentChartModel appointmentChart) {
    this.appointmentChart = appointmentChart;
  }

  public PatientModel getPatient() {
    return patient;
  }

  public void setPatient(PatientModel patient) {
    this.patient = patient;
  }

  public AppointmentStatusEnum getAppointmentStatus() {
    return appointmentStatus;
  }

  public void setAppointmentStatus(AppointmentStatusEnum appointmentStatus) {
    this.appointmentStatus = appointmentStatus;
  }
}
