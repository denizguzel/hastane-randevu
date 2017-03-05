package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.DistrictDao;
import com.hastanerandevu.dao.impl.DistrictDaoImpl;
import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.service.DistrictService;

;

public class DistrictServiceImpl implements DistrictService {

  DistrictDao districtDao = new DistrictDaoImpl();

  @Override
  public void createDistrict (String districtName, CityModel cityModel) {
    districtDao.createDistrict(districtName, cityModel);
  }

  @Override
  public void updateDistrict (long id, String districtName) {
    districtDao.updateDistrict(id, districtName);
  }

  @Override
  public void deleteDistrict (long id) {
    districtDao.deleteDistrict(id);
  }

  @Override
  public DistrictModel findDistrict (long id) {
    return districtDao.findDistrict(id);
  }
}
