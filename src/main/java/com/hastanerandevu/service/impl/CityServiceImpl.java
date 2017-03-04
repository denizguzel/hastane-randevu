package com.hastanerandevu.service.impl;

/**
 * Created by Okan on 4.3.2017.
 */


import com.hastanerandevu.dao.CityDao;
import com.hastanerandevu.dao.impl.CityDaoImpl;
import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.service.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {

  CityDao cityDao = new CityDaoImpl();

  @Override
  public CityModel findCity(long id){
    return cityDao.findCity(id);
  }

  @Override
  public List<DistrictModel> getAllDistrictsByCity(CityModel cityModel) {
    return cityDao.getAllDistrictsByCity(cityModel);
  }

  public void createDistricts(List<DistrictModel> districtModelsList, CityModel cityModel){
    cityDao.createDistricts(districtModelsList,cityModel);
  }

  @Override
  public void createCity(String cityName) {
    cityDao.createCity(cityName);
  }

  @Override
  public void updateCity(long id, String cityName) {
    cityDao.updateCity(id,cityName);
  }

  @Override
  public void deleteCity(long id) {
    cityDao.deleteCity(id);
  }
}
