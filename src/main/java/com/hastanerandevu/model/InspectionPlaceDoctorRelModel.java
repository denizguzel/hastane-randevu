package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "T_INSPECTION_PLACE_DOCTOR_REL")
public class InspectionPlaceDoctorRelModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (generator = "inspection_place_doctor_pk")
  @SequenceGenerator (name = "inspection_place_doctor_pk", sequenceName = "SEQ_INSPECTIONPLACEDOCTOR_PK", allocationSize = 1)
  private long pk;

  @Column (name = "ACTIVE_FROM")
  private Date activeFrom;

  @Column (name = "ACTIVE_TO")
  private Date activeTo;

  @Column (name = "CREATION_TIME",insertable = false, updatable = false)
  private Date creationTime;

  @Column (name = "MODIFIED_TIME",insertable = false, updatable = false)
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE",insertable = false)
  private char isActive;

  @OneToMany (mappedBy = "inspectionPlaceDoctorRel")
  private List<AppointmentChartModel> appointmentChartModels;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_INSPECTION_PLACE")
  private InspectionPlaceModel inspectionPlace;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_DOCTOR")
  private DoctorModel doctor;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public Date getActiveFrom () {
    return activeFrom;
  }

  public void setActiveFrom (Date activeFrom) {
    this.activeFrom = activeFrom;
  }

  public Date getActiveTo () {
    return activeTo;
  }

  public void setActiveTo (Date activeTo) {
    this.activeTo = activeTo;
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

  public List<AppointmentChartModel> getAppointmentChartModels () {
    return appointmentChartModels;
  }

  public void setAppointmentChartModels (List<AppointmentChartModel> appointmentChartModels) {
    this.appointmentChartModels = appointmentChartModels;
  }

  public InspectionPlaceModel getInspectionPlace () {
    return inspectionPlace;
  }

  public void setInspectionPlace (InspectionPlaceModel inspectionPlace) {
    this.inspectionPlace = inspectionPlace;
  }

  public DoctorModel getDoctor () {
    return doctor;
  }

  public void setDoctor (DoctorModel doctor) {
    this.doctor = doctor;
  }
}

