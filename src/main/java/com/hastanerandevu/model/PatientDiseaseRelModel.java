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
@Table(name = "T_PATIENT_DISEASE_REL")
public class PatientDiseaseRelModel implements Creatable,Updatable {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "patient_disease_pk")
  @SequenceGenerator(name = "patient_disease_pk", sequenceName = "SEQ_PATIENT_DISEASE_PK", allocationSize = 1)
  private long pk;

  @Column(name = "IS_STILL_PASS")
  private char isStillPass;

  @Column(name = "CREATION_TIME")
  private Date creationTime;

  @Column(name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_PATIENT")
  private PatientModel patient;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_DISEASE")
  private DiseaseModel disease;

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public char getIsStillPass() {
    return isStillPass;
  }

  public void setIsStillPass(char isStillPass) {
    this.isStillPass = isStillPass;
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

  public DiseaseModel getDisease() {
    return disease;
  }

  public void setDisease(DiseaseModel disease) {
    this.disease = disease;
  }
}
