package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

// TODO service ve dao gerekli
@Entity
@Table (name = "appointment_chart")
public class AppointmentChartModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "APPOINTMENT_DATE")
  private Date appointmentDate;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_INSPECTION_PLACE_DOCTOR_REL")
  private InspectionPlaceDoctorRelModel inspectionPlaceDoctorRelModel;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @Column (name = "IS_RESERVED")
  private char isReserved;

  @OneToMany (mappedBy = "appointmentChartModel")
  private List<AppointmentModel> appointmentModels;

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

  public InspectionPlaceDoctorRelModel getInspectionPlaceDoctorRelModel() {
    return inspectionPlaceDoctorRelModel;
  }

  public void setInspectionPlaceDoctorRelModel(InspectionPlaceDoctorRelModel inspectionPlaceDoctorRelModel) {
    this.inspectionPlaceDoctorRelModel = inspectionPlaceDoctorRelModel;
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

  public char getIsReserved() {
    return isReserved;
  }

  public void setIsReserved(char isReserved) {
    this.isReserved = isReserved;
  }
}
