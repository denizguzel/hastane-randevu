package com.hastanerandevu.dao;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

/**
 * Created by Okan on 4.3.2017.
 */
public interface DistrictDao {
  void createDistrict(String districtName,CityModel cityModel);
  void updateDistrict(long id,String districtName);
  void deleteDistrict(long id);
  DistrictModel findDistrict(long id);
}
