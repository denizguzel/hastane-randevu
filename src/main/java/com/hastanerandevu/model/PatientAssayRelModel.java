package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

// TODO service ve dao gerekli

@Entity
@Table (name = "patient_assay_rel")
public class PatientAssayRelModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_ASSAY")
  private AssayModel assayModel;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_PATIENT")
  private PatientModel patientModel;

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


  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public AssayModel getAssayModel () {
    return assayModel;
  }

  public void setAssayModel (AssayModel assayModel) {
    this.assayModel = assayModel;
  }

  public PatientModel getPatientModel () {
    return patientModel;
  }

  public void setPatientModel (PatientModel patientModel) {
    this.patientModel = patientModel;
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
}
