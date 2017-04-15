package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.DistrictDaoImpl;
import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.model.HospitalModel;
import com.hastanerandevu.model.HospitalPoliclinicRelModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class DistrictServiceImpl implements BaseService<DistrictModel> {

  private DistrictDaoImpl districtDao = new DistrictDaoImpl();

  @Override
  public void create(DistrictModel model) {
    districtDao.create(model);
  }

  @Override
  public void update(DistrictModel model) {
    districtDao.update(model);
  }

  @Override
  public void delete(DistrictModel model) {
    districtDao.delete(model);
  }

  @Override
  public DistrictModel find(long id) {
    return districtDao.find(id);
  }

  @Override
  public List<DistrictModel> findAll() {
    return districtDao.findAll();
  }

  public List<HospitalModel> getHospitalsByDistrict(DistrictModel districtModel) {
    return districtDao.getHospitalByDistrict(districtModel);
  }

  public List<HospitalPoliclinicRelModel> getPoliclinicsByDistrict(DistrictModel districtModel) {
    return districtDao.getPoliclinicByDistrict(districtModel);
  }
}
