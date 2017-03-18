package com.hastanerandevu.service;

import com.hastanerandevu.dao.HospitalDaoImpl;
import com.hastanerandevu.enums.HospitalTypeEnum;
import com.hastanerandevu.model.HospitalModel;

import java.util.List;

public class HospitalServiceImpl implements BaseService<HospitalModel> {

  private HospitalDaoImpl hospitalDao = new HospitalDaoImpl();


  @Override
  public void create(HospitalModel model) {
    hospitalDao.create(model);
  }

  @Override
  public void update(long id, HospitalModel model) {
    hospitalDao.update(id, model);
  }

  @Override
  public void delete(long id) {
    hospitalDao.delete(id);
  }

  @Override
  public HospitalModel find(long id) {
    return hospitalDao.find(id);
  }

  @Override
  public List<HospitalModel> findAll() {
    return hospitalDao.findAll();
  }

  public List<HospitalModel> getAllHospitalsByHospitalType(HospitalTypeEnum typeEnum) {
    return hospitalDao.getAllHospitalsByHospitalType(typeEnum);
  }
}
