package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "treatment")
public class TreatmentModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "TREATMENT_NAME")
  private String treatmentName;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_TREATMENT_TYPE")
  private TreatmentTypeModel treatmentTypeModel;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "treatmentModel")
  private List<PatientTreatmentRelModel> patientTreatmentRelModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getTreatmentName () {
    return treatmentName;
  }

  public void setTreatmentName (String treatmentName) {
    this.treatmentName = treatmentName;
  }

  public TreatmentTypeModel getTreatmentTypeModel () {
    return treatmentTypeModel;
  }

  public void setTreatmentTypeModel (TreatmentTypeModel treatmentTypeModel) {
    this.treatmentTypeModel = treatmentTypeModel;
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
