package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

// TODO service ve dao yapısı gerekli
@Entity
@Table (name = "reviews_about_doctors")
public class ReviewsAboutDoctorsModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_PATIENT")
  private PatientModel patientModel;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_DOCTOR")
  private DoctorModel doctorModel;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @Column (name = "IS_APPROPRIATE")
  private char isAppropriate;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public PatientModel getPatientModel () {
    return patientModel;
  }

  public void setPatientModel (PatientModel patientModel) {
    this.patientModel = patientModel;
  }

  public DoctorModel getDoctorModel () {
    return doctorModel;
  }

  public void setDoctorModel (DoctorModel doctorModel) {
    this.doctorModel = doctorModel;
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

  public char getIsAppropriate () {
    return isAppropriate;
  }

  public void setIsAppropriate (char isAppropriate) {
    this.isAppropriate = isAppropriate;
  }
}
