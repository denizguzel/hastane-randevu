package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "appointment_status")
public class AppointmentStatusModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "STATUS_CODE")
  private String statusCode;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "appointmentStatus")
  private List<AppointmentModel> appointmentModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getStatusCode () {
    return statusCode;
  }

  public void setStatusCode (String statusCode) {
    this.statusCode = statusCode;
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

  public List<AppointmentModel> getAppointmentModels() {
    return appointmentModels;
  }

  public void setAppointmentModels(List<AppointmentModel> appointmentModels) {
    this.appointmentModels = appointmentModels;
  }
}
