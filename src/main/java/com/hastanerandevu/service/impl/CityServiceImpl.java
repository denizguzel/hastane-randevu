package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.CityDao;
import com.hastanerandevu.dao.impl.CityDaoImpl;
import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.service.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {

  CityDao cityDao = new CityDaoImpl();

  @Override
  public void createCity (String cityName) {
    cityDao.createCity(cityName);
  }

  @Override
  public void updateCity (long id, String cityName) {
    cityDao.updateCity(id,cityName);
  }

  @Override
  public void deleteCity (long id) {
    cityDao.deleteCity(id);
  }

  @Override
  public CityModel findCity (long id) {
    return cityDao.findCity(id);
  }

  @Override
  public List<CityModel> getAllCities() {
    return cityDao.getAllCities();
  }

  @Override
  public List<DistrictModel> getAllDistrictsByCity (CityModel cityModel) {
    return cityDao.getAllDistrictsByCity(cityModel);
  }

  @Override
  public void createDistricts (List<DistrictModel> districtModels, CityModel cityModel) {
    cityDao.createDistricts(districtModels,cityModel);

  }
}
