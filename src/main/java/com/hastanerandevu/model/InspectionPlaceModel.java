package com.hastanerandevu.model;

public class InspectionPlaceModel {
  private long pk;
  private String placeName;
  private HospitalPoliclinicRelModel hospitalPoliclinicRelModel;
  private char isActive;

  public long getPk () {
    return pk;
  }

  public void setPk (long pk) {
    this.pk = pk;
  }

  public String getPlaceName () {
    return placeName;
  }

  public void setPlaceName (String placeName) {
    this.placeName = placeName;
  }

  public HospitalPoliclinicRelModel getHospitalPoliclinicRelModel () {
    return hospitalPoliclinicRelModel;
  }

  public void setHospitalPoliclinicRelModel (HospitalPoliclinicRelModel hospitalPoliclinicRelModel) {
    this.hospitalPoliclinicRelModel = hospitalPoliclinicRelModel;
  }

  public char getIsActive () {
    return isActive;
  }

  public void setIsActive (char isActive) {
    this.isActive = isActive;
  }
}
