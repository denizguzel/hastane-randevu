package com.hastanerandevu.service;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

public interface DistrictService {
  void createDistrict (String districtName, CityModel cityModel);

  void updateDistrict (long id, String districtName);

  void deleteDistrict (long id);

  DistrictModel findDistrict (long id);

}
