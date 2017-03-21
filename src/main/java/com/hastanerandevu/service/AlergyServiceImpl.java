package com.hastanerandevu.service;

import com.hastanerandevu.dao.AlergyDaoImpl;
import com.hastanerandevu.model.AlergyModel;

import java.util.List;

public class AlergyServiceImpl implements BaseService<AlergyModel> {
  private AlergyDaoImpl alergyDao = new AlergyDaoImpl();

  @Override
  public void create(AlergyModel model) {
    alergyDao.create(model);
  }

  @Override
  public void update(AlergyModel model) {
    alergyDao.update(model);
  }

  @Override
  public void delete(AlergyModel model) {
    alergyDao.delete(model);
  }

  @Override
  public AlergyModel find(long id) {
    return alergyDao.find(id);
  }

  @Override
  public List<AlergyModel> findAll() {
    return alergyDao.findAll();
  }
}
