package com.hastanerandevu.model;

import com.hastanerandevu.enums.HospitalTypeEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "T_HOSPITAL")
public class HospitalModel {

  @Id
  @GeneratedValue (generator = "hospital_pk")
  @SequenceGenerator (name = "hospital_pk", sequenceName = "SEQ_HOSPITAL_PK", allocationSize = 1)
  @Column (name = "PK")
  private long pk;

  @Column (name = "HOSPITAL_NAME")
  private String hospitalName;

  @Column (name = "HOSPITAL_ADDRESS")
  private String hospitalAddress;

  @Column (name = "CREATION_TIME", insertable = false, updatable = false)
  private Date creationTime;

  @Column (name = "MODIFIED_TIME", insertable = false, updatable = false)
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @Enumerated (EnumType.STRING)
  @Column (name = "HOSPITAL_TYPE")
  private HospitalTypeEnum hospitalType;

  @OneToMany (mappedBy = "hospital")
  private List<HospitalPoliclinicRelModel> hospitalPoliclinicRelModels;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_DISTRICT")
  private DistrictModel district;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getHospitalName () {
    return hospitalName;
  }

  public void setHospitalName (String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public String getHospitalAddress () {
    return hospitalAddress;
  }

  public void setHospitalAddress (String hospitalAddress) {
    this.hospitalAddress = hospitalAddress;
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

  public DistrictModel getDistrict () {
    return district;
  }

  public void setDistrict (DistrictModel district) {
    this.district = district;
  }

  public List<HospitalPoliclinicRelModel> getHospitalPoliclinicRelModels () {
    return hospitalPoliclinicRelModels;
  }

  public void setHospitalPoliclinicRelModels (List<HospitalPoliclinicRelModel> hospitalPoliclinicRelModels) {
    this.hospitalPoliclinicRelModels = hospitalPoliclinicRelModels;
  }

  public HospitalTypeEnum getHospitalType () {
    return hospitalType;
  }

  public void setHospitalType (HospitalTypeEnum hospitalType) {
    this.hospitalType = hospitalType;
  }
}
