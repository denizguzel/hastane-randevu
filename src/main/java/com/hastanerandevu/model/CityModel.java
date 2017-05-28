package com.hastanerandevu.model;

import com.hastanerandevu.listeners.Creatable;
import com.hastanerandevu.listeners.CreationTimeListener;
import com.hastanerandevu.listeners.ModifiedTimeListener;
import com.hastanerandevu.listeners.Updatable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners({
  CreationTimeListener.class,
  ModifiedTimeListener.class
})
@Table(name = "T_CITY")
public class CityModel implements Creatable, Updatable {

  @Id
  @GeneratedValue(generator = "city_pk")
  @SequenceGenerator(name = "city_pk", sequenceName = "SEQ_CITY_PK", allocationSize = 1)
  @Column(name = "PK")
  private long pk;

  @Column(name = "CITY_NAME")
  private String cityName;

  @Column(name = "CREATION_TIME")
  private Date modifiedTime;

  @Column(name = "MODIFIED_TIME")
  private Date creationTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @OneToMany(mappedBy = "cityModel")
  private List<DistrictModel> districtModels;

  public long getPk() {
    return pk;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public char getIsActive() {
    return isActive;
  }

  public void setIsActive(char isActive) {
    this.isActive = isActive;
  }

  public List<DistrictModel> getDistrictModels() {
    return districtModels;
  }

  public void setDistrictModels(List<DistrictModel> districtModels) {
    this.districtModels = districtModels;
  }
}
