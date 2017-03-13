package com.hastanerandevu.service;

import com.hastanerandevu.dao.CityDaoImpl;
import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

import java.util.List;

public class CityServiceImpl implements BaseService<CityModel> {

  private CityDaoImpl cityDao = new CityDaoImpl();

  @Override
  public void create (CityModel model) {
    cityDao.create(model);
  }

  @Override
  public void update (long id, CityModel model) {
    cityDao.update(id, model);
  }

  @Override
  public void delete (long id) {
    cityDao.delete(id);
  }

  @Override
  public CityModel find (long id) {
    return cityDao.find(id);
  }

  @Override
  public List<CityModel> findAll () {
    return cityDao.findAll();
  }

  public List<DistrictModel> getAllDistrictsByCity (CityModel model) {
    return cityDao.getAllDistrictsByCity(model);
  }

  public void createDistricts (List<DistrictModel> districtModel, CityModel model) {
    cityDao.createDistricts(districtModel, model);
  }
}
