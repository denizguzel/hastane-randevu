package com.hastanerandevu.service;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

import java.util.List;

public interface CityService {
  void createCity (String cityName);

  void updateCity (long id, String cityName);

  void deleteCity (long id);

  CityModel findCity (long id);

  List<DistrictModel> getAllDistrictsByCity (CityModel cityModel);

  void createDistricts (List<DistrictModel> districtModels, CityModel cityModel);
}
