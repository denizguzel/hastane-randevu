package com.hastanerandevu.service;

import com.hastanerandevu.model.HospitalTypeModel;

import java.util.List;

public interface HospitalTypeService {
  void createHospitalType (String hospitalTypeName);

  void updateHospitalType (long id, String hospitalTypeName);

  void deleteHospitalType (long id);

  HospitalTypeModel findHospitalType (long id);

  List<HospitalTypeModel> getAllHospitalTypes ();
}
