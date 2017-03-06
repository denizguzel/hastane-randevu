package com.hastanerandevu.dao;

import com.hastanerandevu.model.HospitalModel;

import java.util.List;

/**
 * Created by Okan on 6.3.2017.
 */
public interface HospitalDao {
  void createHospital (String hospitalName);

  void updateHospital (long id, String hospitalName);

  void deleteHospital (long id);

  HospitalModel findHospital (long id);

  public List<HospitalModel> getAllHospitals ();
}
