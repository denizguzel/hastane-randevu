package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.BloodGroupDao;
import com.hastanerandevu.dao.impl.BloodGroupDaoImpl;
import com.hastanerandevu.model.BloodGroupModel;
import com.hastanerandevu.service.BloodGroupService;

import java.util.List;

public class BloodGroupServiceImpl implements BloodGroupService {
  private BloodGroupDao bloodGroupDao = new BloodGroupDaoImpl();

  @Override
  public BloodGroupModel findBloodGroup (long id) {
    return bloodGroupDao.findBloodGroup(id);
  }

  @Override
  public List<BloodGroupModel> getAllBloodGroups () {
    return bloodGroupDao.getAllBloodGroups();
  }
}
