package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "alergy")
public class AlergyModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "ALERGY_NAME")
  private String alergyName;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_ALERGY_TYPE")
  private AlergyTypeModel alergyType;

  @OneToMany (mappedBy = "alergyModel")
  private List<PatientAlergyRelModel> patientAlergyRelModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getAlergyName () {
    return alergyName;
  }

  public void setAlergyName (String alergyName) {
    this.alergyName = alergyName;
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

  public AlergyTypeModel getAlergyType() {
    return alergyType;
  }

  public void setAlergyType(AlergyTypeModel alergyType) {
    this.alergyType = alergyType;
  }
}
