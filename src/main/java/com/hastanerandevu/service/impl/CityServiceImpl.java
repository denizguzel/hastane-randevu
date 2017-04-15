package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.CityDaoImpl;
import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.model.HospitalModel;
import com.hastanerandevu.model.HospitalPoliclinicRelModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class CityServiceImpl implements BaseService<CityModel> {

  private CityDaoImpl cityDao = new CityDaoImpl();

  @Override
  public void create(CityModel model) {
    cityDao.create(model);
  }

  @Override
  public void update(CityModel model) {
    cityDao.update(model);
  }

  @Override
  public void delete(CityModel model) {
    cityDao.delete(model);
  }

  @Override
  public CityModel find(long id) {
    return cityDao.find(id);
  }

  @Override
  public List<CityModel> findAll() {
    return cityDao.findAll();
  }

  /*public void createDistricts(List<DistrictModel> districtModel, CityModel model) {
    cityDao.createDistricts(districtModel, model);
  }*/

  public List<CityModel> getCities() {
    return cityDao.getCities();
  }

  public List<DistrictModel> getAllDistrictsByCity(CityModel cityModel) {
    return cityDao.getAllDistrictsByCity(cityModel);
  }

  public List<HospitalPoliclinicRelModel> getPoliclinicsByCity(CityModel cityModel) {
    return cityDao.getPoliclinicByCity(cityModel);
  }

  public List<HospitalModel> getHospitalsByCity(CityModel cityModel) {
    return cityDao.getHospitalByCity(cityModel);
  }
}
