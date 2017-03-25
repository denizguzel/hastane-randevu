package com.hastanerandevu.service;

import com.hastanerandevu.dao.DistrictDaoImpl;
import com.hastanerandevu.model.DistrictModel;

import java.util.List;
import java.util.Map;

public class DistrictServiceImpl implements BaseService<DistrictModel> {

  private DistrictDaoImpl districtDao = new DistrictDaoImpl();

  @Override
  public void create(DistrictModel model) {
    districtDao.create(model);
  }

  @Override
  public void update(DistrictModel model) {
    districtDao.update(model);
  }

  @Override
  public void delete(DistrictModel model) {
    districtDao.delete(model);
  }

  @Override
  public DistrictModel find(long id) {
    return districtDao.find(id);
  }

  @Override
  public List<DistrictModel> findAll() {
    return districtDao.findAll();
  }

  public Map<String, String> getHospitalByDistrict(DistrictModel districtModel) {
    return districtDao.getHospitalByDistrict(districtModel);
  }
}
