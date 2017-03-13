package com.hastanerandevu.service;

import com.hastanerandevu.dao.AlergyDaoImpl;
import com.hastanerandevu.model.AlergyModel;

import java.util.List;

public class AlergyServiceImpl implements BaseService<AlergyModel> {
  private AlergyDaoImpl alergyDao = new AlergyDaoImpl();

  @Override
  public void create (AlergyModel model) {
    alergyDao.create(model);
  }

  @Override
  public void update (long id, AlergyModel model) {
    alergyDao.update(id, model);
  }

  @Override
  public void delete (long id) {
    alergyDao.delete(id);
  }

  @Override
  public AlergyModel find (long id) {
    return alergyDao.find(id);
  }

  @Override
  public List<AlergyModel> findAll () {
    return alergyDao.findAll();
  }
}
