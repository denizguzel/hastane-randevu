package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_HOSPITAL_POLICLINIC_REL")
public class HospitalPoliclinicRelModel {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "hospital_policlinic_pk")
  @SequenceGenerator(name = "hospital_policlinic_pk", sequenceName = "SEQ_HOSPITAL_POLICLINIC_PK", allocationSize = 1)
  private long pk;

  @Column(name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column(name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @OneToMany(mappedBy = "hospitalPoliclinicRel")
  private List<InspectionPlaceModel> inspectionPlaceModels;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_HOSPITAL", referencedColumnName = "PK")
  private HospitalModel hospital;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_POLICLINIC", referencedColumnName = "PK")
  private PoliclinicModel policlinic;

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

  public List<InspectionPlaceModel> getInspectionPlaceModels() {
    return inspectionPlaceModels;
  }

  public void setInspectionPlaceModels(List<InspectionPlaceModel> inspectionPlaceModels) {
    this.inspectionPlaceModels = inspectionPlaceModels;
  }

  public HospitalModel getHospital() {
    return hospital;
  }

  public void setHospital(HospitalModel hospital) {
    this.hospital = hospital;
  }

  public PoliclinicModel getPoliclinic() {
    return policlinic;
  }

  public void setPoliclinic(PoliclinicModel policlinic) {
    this.policlinic = policlinic;
  }
}
