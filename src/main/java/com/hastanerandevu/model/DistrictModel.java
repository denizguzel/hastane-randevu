package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table (name = "district")
public class DistrictModel {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  @Column (name = "PK")
  private long pk;

  @Column (name = "DISTRICT_NAME")
  private String districtName;

  @Column (name = "CREATION_TIME")
  private Date creationTime;

  @Column (name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_CITY")
  private CityModel city;

  @OneToMany(mappedBy = "district")
  private List<HospitalModel> hospitalModels;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getDistrictName () {
    return districtName;
  }

  public void setDistrictName (String districtName) {
    this.districtName = districtName;
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

  public CityModel getCity() {
    return city;
  }

  public void setCity(CityModel city) {
    this.city = city;
  }

  public List<HospitalModel> getHospitalModels() {
    return hospitalModels;
  }

  public void setHospitalModels(List<HospitalModel> hospitalModels) {
    this.hospitalModels = hospitalModels;
  }
}
