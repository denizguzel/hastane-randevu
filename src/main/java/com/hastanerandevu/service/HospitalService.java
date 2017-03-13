package com.hastanerandevu.service;

import com.hastanerandevu.enums.HospitalTypeEnum;
import com.hastanerandevu.model.HospitalModel;

import java.util.List;

public interface HospitalService {
  void create(HospitalModel hospitalModel);

  void updateHospital (long id, HospitalModel hospitalModel);

  void deleteHospital (long id);

  HospitalModel findHospital (long id);

  List<HospitalModel> getAllHospitals ();

  List<HospitalModel> getAllHospitalsByHospitalType(HospitalTypeEnum hospitalTypeEnum);
}
