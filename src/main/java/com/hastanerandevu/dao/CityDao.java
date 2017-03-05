package com.hastanerandevu.dao;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

import java.util.List;

public interface CityDao {
  void createCity (String cityName);

  void updateCity (long id, String cityName);

  void deleteCity (long id);

  CityModel findCity (long id);

  List<CityModel> getAllCities ();

  List<DistrictModel> getAllDistrictsByCity (CityModel cityModel);

  void createDistricts (List<DistrictModel> districtModels, CityModel cityModel);
}
