package com.hastanerandevu.service;

import com.hastanerandevu.dao.DistrictDaoImpl;
import com.hastanerandevu.model.DistrictModel;

import java.util.List;

public class DistrictServiceImpl implements BaseService<DistrictModel> {

  private DistrictDaoImpl districtDao = new DistrictDaoImpl();

  @Override
  public void create (DistrictModel model) {
    districtDao.create(model);
  }

  @Override
  public void update (long id, DistrictModel model) {
    districtDao.update(id, model);
  }

  @Override
  public void delete (long id) {
    districtDao.delete(id);
  }

  @Override
  public DistrictModel find (long id) {
    return districtDao.find(id);
  }

  @Override
  public List<DistrictModel> findAll () {
    return districtDao.findAll();
  }
}
