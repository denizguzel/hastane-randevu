package com.hastanerandevu.service;

import com.hastanerandevu.dao.AssayDaoImpl;
import com.hastanerandevu.model.AssayModel;

import java.util.List;

public class AssayServiceImpl implements BaseService<AssayModel> {
  private AssayDaoImpl assayDao = new AssayDaoImpl();

  @Override
  public void create(AssayModel model) {
    assayDao.create(model);
  }

  @Override
  public void update(AssayModel model) {
    assayDao.update(model);
  }

  @Override
  public void delete(AssayModel model) {
    assayDao.delete(model);
  }

  @Override
  public AssayModel find(long id) {
    return assayDao.find(id);
  }

  @Override
  public List<AssayModel> findAll() {
    return assayDao.findAll();
  }
}
