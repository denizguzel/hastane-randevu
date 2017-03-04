package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Okan on 3.3.2017.
 */
@Entity
@Table (name="district")
public class DistrictModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "PK")
  long pk;

  @Column(name = "DISTRICT_NAME")
  String districtName;

  @Column(name = "CREATION_TIME")
  Date creationTime;

  @Column(name = "MODIFIED_TIME")
  Date modifiedTime;

  @Column(name = "IS_ACTIVE")
  char isActive;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_CITY")
  CityModel owner;

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public String getDistrictName() {
    return districtName;
  }

  public void setDistrictName(String districtName) {
    this.districtName = districtName;
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

  public CityModel getOwner() {
    return owner;
  }

  public void setOwner(CityModel owner) {
    this.owner = owner;
  }
}
