package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "hospital_policlinic_rel")
public class HospitalPoliclinicRelModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "hospitalPoliclinicRel")
  private List<InspectionPlaceModel> inspectionPlaceModels;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_HOSPITAL")
  private HospitalModel hospital;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_POLICLINIC")
  private PoliclinicModel policlinic;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
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

  public List<InspectionPlaceModel> getInspectionPlaceModels () {
    return inspectionPlaceModels;
  }

  public void setInspectionPlaceModels (List<InspectionPlaceModel> inspectionPlaceModels) {
    this.inspectionPlaceModels = inspectionPlaceModels;
  }

  public HospitalModel getHospital () {
    return hospital;
  }

  public void setHospital (HospitalModel hospital) {
    this.hospital = hospital;
  }

  public PoliclinicModel getPoliclinic () {
    return policlinic;
  }

  public void setPoliclinic (PoliclinicModel policlinic) {
    this.policlinic = policlinic;
  }
}
