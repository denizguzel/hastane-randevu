package com.hastanerandevu.model;

import javax.persistence.*;
import java.util.List;

// TODO service ve dao gerekli
@Entity
@Table (name = "inspection_place")
public class InspectionPlaceModel {

  @Id
  @Column (name = "PK")
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long pk;

  @Column (name = "PLACE_NAME")
  private String placeName;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn (name = "FK_HOSPITAL_POLICLINIC_REL")
  private HospitalPoliclinicRelModel hospitalPoliclinicRelModel;

  @Column (name = "IS_ACTIVE")
  private char isActive;

  @OneToMany (mappedBy = "inspectionPlaceModel")
  private List<InspectionPlaceDoctorRelModel> ınspectionPlaceDoctorRelModels;

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
