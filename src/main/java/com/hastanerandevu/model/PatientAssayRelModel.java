package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "patient_assay_rel")
public class PatientAssayRelModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "ASSAY_RESULT")
  private String assayResult;

  @Column (name = "ASSAY_DETAIL")
  private String assayDetail;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;


  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_ASSAY")
  private AssayModel assay;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_PATIENT")
  private PatientModel patient;


  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getAssayResult () {
    return assayResult;
  }

  public void setAssayResult (String assayResult) {
    this.assayResult = assayResult;
  }

  public String getAssayDetail () {
    return assayDetail;
  }

  public void setAssayDetail (String assayDetail) {
    this.assayDetail = assayDetail;
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

  public AssayModel getAssay () {
    return assay;
  }

  public void setAssay (AssayModel assay) {
    this.assay = assay;
  }

  public PatientModel getPatient () {
    return patient;
  }

  public void setPatient (PatientModel patient) {
    this.patient = patient;
  }
}
