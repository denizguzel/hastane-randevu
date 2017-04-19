package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.HospitalPoliclinicRelDaoImpl;
import com.hastanerandevu.model.HospitalPoliclinicRelModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

/**
 * Created by Okan on 19.4.2017.
 */
public class HospitalPoliclinicRelServiceImpl implements BaseService<HospitalPoliclinicRelModel> {

  HospitalPoliclinicRelDaoImpl hospitalPoliclinicRelDao = new HospitalPoliclinicRelDaoImpl();

  @Override
  public void create(HospitalPoliclinicRelModel model) {
    hospitalPoliclinicRelDao.create(model);
  }

  @Override
  public void update(HospitalPoliclinicRelModel model) {
    hospitalPoliclinicRelDao.update(model);
  }

  @Override
  public void delete(HospitalPoliclinicRelModel model) {
    hospitalPoliclinicRelDao.delete(model);
  }

  @Override
  public HospitalPoliclinicRelModel find(long id) {
    return hospitalPoliclinicRelDao.find(id);
  }

  @Override
  public List<HospitalPoliclinicRelModel> findAll() {
    return hospitalPoliclinicRelDao.findAll();
  }
}
