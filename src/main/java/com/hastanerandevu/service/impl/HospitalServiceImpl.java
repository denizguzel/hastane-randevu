package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.HospitalDao;
import com.hastanerandevu.dao.impl.HospitalDaoImpl;
import com.hastanerandevu.model.HospitalModel;
import com.hastanerandevu.service.HospitalService;

import java.util.List;

public class HospitalServiceImpl implements HospitalService {

  private HospitalDao hospitalDao = new HospitalDaoImpl();

  @Override
  public void createHospital (String hospitalName) {
    hospitalDao.createHospital(hospitalName);
  }

  @Override
  public void updateHospital (long id, String hospitalName) {
    hospitalDao.updateHospital(id, hospitalName);
  }

  @Override
  public void deleteHospital (long id) {
    hospitalDao.deleteHospital(id);
  }

  @Override
  public HospitalModel findHospital (long id) {
    return hospitalDao.findHospital(id);
  }

  @Override
  public List<HospitalModel> getAllHospitals () {
    return hospitalDao.getAllHospitals();
  }
}
