package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.HospitalTypeDao;
import com.hastanerandevu.dao.impl.HospitalTypeDaoImpl;
import com.hastanerandevu.model.HospitalTypeModel;
import com.hastanerandevu.service.HospitalTypeService;

import java.util.List;

/**
 * Created by Okan on 6.3.2017.
 */
public class HospitalTypeServiceImpl implements HospitalTypeService {
  HospitalTypeDao hospitalTypeDao = new HospitalTypeDaoImpl();

  @Override
  public void createHospitalType(String hospitalTypeName) {
    hospitalTypeDao.createHospitalType(hospitalTypeName);
  }

  @Override
  public void updateHospitalType(long id, String hospitalTypeName) {
    hospitalTypeDao.updateHospitalType(id,hospitalTypeName);
  }

  @Override
  public void deleteHospitalType(long id) {
    hospitalTypeDao.deleteHospitalType(id);
  }

  @Override
  public HospitalTypeModel findHospitalType(long id) {
    return hospitalTypeDao.findHospitalType(id);
  }

  @Override
  public List<HospitalTypeModel> getAllHospitalTypes() {
    return hospitalTypeDao.getAllHospitalTypes();
  }
}
