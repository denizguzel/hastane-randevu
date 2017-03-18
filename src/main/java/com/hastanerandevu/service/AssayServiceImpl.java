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
  public void update(long id, AssayModel model) {
    assayDao.update(id, model);
  }

  @Override
  public void delete(long id) {
    assayDao.delete(id);
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
