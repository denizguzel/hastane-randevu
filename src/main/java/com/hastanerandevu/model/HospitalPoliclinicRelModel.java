package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

// TODO service ve dao gerekli

@Entity
@Table (name = "hospital_policlinic_rel")
public class HospitalPoliclinicRelModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_HOSPITAL")
  private HospitalModel hospitalModel;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_POLICLINIC")
  private PoliclinicModel policlinicModel;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "hospitalPoliclinicRelModel")
  private List<InspectionPlaceModel> ınspectionPlaceModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public HospitalModel getHospitalModel () {
    return hospitalModel;
  }

  public void setHospitalModel (HospitalModel hospitalModel) {
    this.hospitalModel = hospitalModel;
  }

  public PoliclinicModel getPoliclinicModel () {
    return policlinicModel;
  }

  public void setPoliclinicModel (PoliclinicModel policlinicModel) {
    this.policlinicModel = policlinicModel;
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
