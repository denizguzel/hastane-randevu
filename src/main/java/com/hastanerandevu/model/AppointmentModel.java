package com.hastanerandevu.model;

import com.hastanerandevu.enums.AppointmentStatusEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_APPOINTMENT")
public class AppointmentModel {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "appointment_pk")
  @SequenceGenerator(name = "appointment_pk", sequenceName = "SEQ_APPOINTMENT_PK", allocationSize = 1)
  private long pk;
  @Column(name = "APPOINTMENT_DATE")
  private Date appointmentDate;
  @Column(name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;
  @Column(name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;
  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;
  @Column(name = "MESSAGE_TO_DOCTOR")
  private String messageToDoctor;
  @Enumerated(EnumType.STRING)
  @Column(name = "APPOINTMENT_STATUS")
  private AppointmentStatusEnum appointmentStatus;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_INSPECTION_PLACE")
  private InspectionPlaceModel inspectionPlace;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_PATIENT")
  private PatientModel patient;

  /*public AppointmentModel(Date appointmentDate, AppointmentStatusEnum appointmentStatus, InspectionPlaceModel inspectionPlace) {
    this.appointmentDate = appointmentDate;
    this.appointmentStatus = appointmentStatus;
    this.inspectionPlace = inspectionPlace;
  }*/

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public Date getAppointmentDate() {
    return appointmentDate;
  }

  public void setAppointmentDate(Date appointmentDate) {
    this.appointmentDate = appointmentDate;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public char getIsActive() {
    return isActive;
  }

  public void setIsActive(char isActive) {
    this.isActive = isActive;
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

  public InspectionPlaceModel getInspectionPlace() {
    return inspectionPlace;
  }

  public void setInspectionPlace(InspectionPlaceModel inspectionPlace) {
    this.inspectionPlace = inspectionPlace;
  }

  public String getMessageToDoctor() {
    return messageToDoctor;
  }

  public void setMessageToDoctor(String messageToDoctor) {
    this.messageToDoctor = messageToDoctor;
  }
}
