package com.hastanerandevu.service;

import com.hastanerandevu.dao.HospitalDaoImpl;
import com.hastanerandevu.enums.HospitalTypeEnum;
import com.hastanerandevu.model.HospitalModel;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements BaseService<HospitalModel> {

  private HospitalDaoImpl hospitalDao = new HospitalDaoImpl();


  @Override
  public void create(HospitalModel model) {
    hospitalDao.create(model);
  }

  @Override
  public void update(HospitalModel model) {
    hospitalDao.update(model);
  }

  @Override
  public void delete(HospitalModel model) {
    hospitalDao.delete(model);
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

  public Map<String, String> getPoliclinicByHospital(HospitalModel hospitalModel) {
    return hospitalDao.getPoliclinicByHospital(hospitalModel);
  }
}
