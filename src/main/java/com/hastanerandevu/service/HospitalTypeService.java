package com.hastanerandevu.service;

import com.hastanerandevu.model.HospitalTypeModel;

import java.util.List;

/**
 * Created by Okan on 6.3.2017.
 */
public interface HospitalTypeService {
  void createHospitalType (String hospitalTypeName);

  void updateHospitalType (long id, String hospitalTypeName);

  void deleteHospitalType (long id);

  HospitalTypeModel findHospitalType (long id);

  public List<HospitalTypeModel> getAllHospitalTypes ();
}
