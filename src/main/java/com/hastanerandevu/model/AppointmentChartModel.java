package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_APPOINTMENT_CHART")
public class AppointmentChartModel {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "appointment_chart_pk")
  @SequenceGenerator(name = "appointment_chart_pk", sequenceName = "SEQ_APPOINTMENT_CHART_PK", allocationSize = 1)
  private long pk;

  @Column(name = "ACTIVE_FROM")
  private Date activeFrom;

  @Column(name = "ACTIVE_TO")
  private Date activeTo;

  @Column(name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column(name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @OneToMany(mappedBy = "appointmentChart")
  private List<AppointmentModel> appointmentModels;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_INSPECTION_PLACE_DOCTOR_REL")
  private InspectionPlaceDoctorRelModel inspectionPlaceDoctorRel;

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
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

  public List<AppointmentModel> getAppointmentModels() {
    return appointmentModels;
  }

  public void setAppointmentModels(List<AppointmentModel> appointmentModels) {
    this.appointmentModels = appointmentModels;
  }

  public InspectionPlaceDoctorRelModel getInspectionPlaceDoctorRel() {
    return inspectionPlaceDoctorRel;
  }

  public void setInspectionPlaceDoctorRel(InspectionPlaceDoctorRelModel inspectionPlaceDoctorRel) {
    this.inspectionPlaceDoctorRel = inspectionPlaceDoctorRel;
  }

  public Date getActiveFrom() {
    return activeFrom;
  }

  public void setActiveFrom(Date activeFrom) {
    this.activeFrom = activeFrom;
  }

  public Date getActiveTo() {
    return activeTo;
  }

  public void setActiveTo(Date activeTo) {
    this.activeTo = activeTo;
  }
}
