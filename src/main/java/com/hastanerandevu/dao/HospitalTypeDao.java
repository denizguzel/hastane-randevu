package com.hastanerandevu.dao;

import com.hastanerandevu.model.HospitalTypeModel;

import java.util.List;

/**
 * Created by Okan on 6.3.2017.
 */
public interface HospitalTypeDao {
  void createHospitalType (String hospitalTypeName);

  void updateHospitalType (long id, String hospitalTypeName);

  void deleteHospitalType (long id);

  HospitalTypeModel findHospitalType (long id);

  public List<HospitalTypeModel> getAllHospitalTypes ();
}
