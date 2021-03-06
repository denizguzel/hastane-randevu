package com.hastanerandevu.model;

import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.listeners.Creatable;
import com.hastanerandevu.listeners.CreationTimeListener;
import com.hastanerandevu.listeners.ModifiedTimeListener;
import com.hastanerandevu.listeners.Updatable;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners({
  CreationTimeListener.class,
  ModifiedTimeListener.class
})
@Table(name = "T_APPOINTMENT")
public class AppointmentModel implements Creatable, Updatable {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "appointment_pk")
  @SequenceGenerator(name = "appointment_pk", sequenceName = "SEQ_APPOINTMENT_PK", allocationSize = 1)
  private long pk;

  @Column(name = "APPOINTMENT_DATE")
  private Date appointmentDate;

  @Column(name = "CREATION_TIME")
  private Date creationTime;

  @Column(name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @Column(name = "MESSAGE_TO_DOCTOR")
  private String messageToDoctor;

  @Enumerated(EnumType.STRING)
  @Column(name = "APPOINTMENT_STATUS")
  private AppointmentStatusEnum appointmentStatus;

  @Column(name = "EXPIRATION_TIME_FOR_SUSPEND")
  private Date expirationTimeForSuspend;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_INSPECTION_PLACE")
  private InspectionPlaceModel inspectionPlace;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_PATIENT")
  private PatientModel patient;

  public long getPk() {
    return pk;
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

  public Date getExpirationTimeForSuspend() {
    return expirationTimeForSuspend;
  }

  public void setExpirationTimeForSuspend(Date expirationTimeForSuspend) {
    this.expirationTimeForSuspend = expirationTimeForSuspend;
  }
}
