package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.HospitalDao;
import com.hastanerandevu.dao.impl.HospitalDaoImpl;
import com.hastanerandevu.enums.HospitalTypeEnum;
import com.hastanerandevu.model.HospitalModel;
import com.hastanerandevu.service.HospitalService;

import java.util.List;

public class HospitalServiceImpl implements HospitalService {

  private HospitalDaoImpl hospitalDao = new HospitalDaoImpl();


  @Override
  public void create(HospitalModel hospitalModel) {
    hospitalDao.create(hospitalModel);
  }

  @Override
  public void updateHospital(long id, HospitalModel hospitalModel) {
    hospitalDao.update(id,hospitalModel);
  }

  @Override
  public void deleteHospital(long id) {
    hospitalDao.delete(id);
  }

  @Override
  public HospitalModel findHospital(long id) {
    return hospitalDao.find(id);
  }

  @Override
  public List<HospitalModel> getAllHospitals() {
    return hospitalDao.findAll();
  }

  @Override
  public List<HospitalModel> getAllHospitalsByHospitalType(HospitalTypeEnum hospitalTypeEnum) {
    return hospitalDao.getAllHospitalsByHospitalType(hospitalTypeEnum);
  }
}
