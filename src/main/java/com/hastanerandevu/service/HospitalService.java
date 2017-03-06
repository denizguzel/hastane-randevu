package com.hastanerandevu.service;

import com.hastanerandevu.model.HospitalModel;

import java.util.List;

public interface HospitalService {
  void createHospital (String hospitalName);

  void updateHospital (long id, String hospitalName);

  void deleteHospital (long id);

  HospitalModel findHospital (long id);

  List<HospitalModel> getAllHospitals ();
}
