package com.hastanerandevu.service;

import com.hastanerandevu.dao.PoliclinicDaoImpl;
import com.hastanerandevu.model.PoliclinicModel;

import java.util.List;

public class PoliclinicServiceImpl implements BaseService<PoliclinicModel> {
  private PoliclinicDaoImpl policlinicDao = new PoliclinicDaoImpl();

  @Override
  public void create(PoliclinicModel model) {
    policlinicDao.create(model);
  }

  @Override
  public void update(PoliclinicModel model) {
    policlinicDao.update(model);
  }

  @Override
  public void delete(PoliclinicModel model) {
    policlinicDao.delete(model);
  }

  @Override
  public PoliclinicModel find(long id) {
    return policlinicDao.find(id);
  }

  @Override
  public List<PoliclinicModel> findAll() {
    return policlinicDao.findAll();
  }
}
