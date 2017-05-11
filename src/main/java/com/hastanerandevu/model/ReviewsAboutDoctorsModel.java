package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_REVIEWS_ABOUT_DOCTOR")
public class ReviewsAboutDoctorsModel {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "review_about_doctor_pk")
  @SequenceGenerator(name = "review_about_doctor_pk", sequenceName = "SEQ_REVIEW_ABOUT_DOCTOR_PK", allocationSize = 1)
  private long pk;

  @Column(name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column(name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @Column(name = "IS_APPROPRIATE")
  private char isAppropriate;

  @Column(name = "REVIEW")
  private String review;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_PATIENT")
  private PatientModel patient;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_DOCTOR")
  private DoctorModel doctor;

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

  public char getIsAppropriate() {
    return isAppropriate;
  }

  public void setIsAppropriate(char isAppropriate) {
    this.isAppropriate = isAppropriate;
  }

  public PatientModel getPatient() {
    return patient;
  }

  public void setPatient(PatientModel patient) {
    this.patient = patient;
  }

  public DoctorModel getDoctor() {
    return doctor;
  }

  public void setDoctor(DoctorModel doctor) {
    this.doctor = doctor;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }
}
