package com.hastanerandevu.service.impl;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.service.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {

  @Override
  public void createCity (String cityName) {

  }

  @Override
  public void updateCity (long id, String cityName) {

  }

  @Override
  public void deleteCity (long id) {

  }

  @Override
  public CityModel findCity (long id) {
    return null;
  }

  @Override
  public List<DistrictModel> getAllDistrictsByCity (CityModel cityModel) {
    return null;
  }

  @Override
  public void createDistricts (List<DistrictModel> districtModels, CityModel cityModel) {

  }
}
