package com.hastanerandevu.service;

import com.hastanerandevu.model.HospitalModel;

import java.util.List;

/**
 * Created by Okan on 6.3.2017.
 */
public interface HospitalService {
  void createHospital (String hospitalName);

  void updateHospital (long id, String hospitalName);

  void deleteHospital (long id);

  HospitalModel findHospital (long id);

  public List<HospitalModel> getAllHospitals ();
}
