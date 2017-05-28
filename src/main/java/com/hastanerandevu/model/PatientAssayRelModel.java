package com.hastanerandevu.model;

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
@Table(name = "T_PATIENT_ASSAY_REL")
public class PatientAssayRelModel implements Creatable, Updatable {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "patient_assay_pk")
  @SequenceGenerator(name = "patient_assay_pk", sequenceName = "SEQ_PATIENT_ASSAY_PK", allocationSize = 1)
  private long pk;

  @Column(name = "ASSAY_RESULT")
  private String assayResult;

  @Column(name = "ASSAY_DETAIL")
  private String assayDetail;

  @Column(name = "CREATION_TIME")
  private Date creationTime;

  @Column(name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_ASSAY")
  private AssayModel assay;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_PATIENT")
  private PatientModel patient;


  public long getPk() {
    return pk;
  }

  public String getAssayResult() {
    return assayResult;
  }

  public void setAssayResult(String assayResult) {
    this.assayResult = assayResult;
  }

  public String getAssayDetail() {
    return assayDetail;
  }

  public void setAssayDetail(String assayDetail) {
    this.assayDetail = assayDetail;
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

  public AssayModel getAssay() {
    return assay;
  }

  public void setAssay(AssayModel assay) {
    this.assay = assay;
  }

  public PatientModel getPatient() {
    return patient;
  }

  public void setPatient(PatientModel patient) {
    this.patient = patient;
  }
}
