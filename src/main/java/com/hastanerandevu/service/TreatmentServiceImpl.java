package com.hastanerandevu.service;

import com.hastanerandevu.dao.TreatmentDaoImpl;
import com.hastanerandevu.model.TreatmentModel;

import java.util.List;

public class TreatmentServiceImpl implements BaseService<TreatmentModel> {
  private TreatmentDaoImpl treatmentDao = new TreatmentDaoImpl();

  @Override
  public void create(TreatmentModel model) {
    treatmentDao.create(model);
  }

  @Override
  public void update(long id, TreatmentModel model) {
    treatmentDao.update(id, model);
  }

  @Override
  public void delete(long id) {
    treatmentDao.delete(id);
  }

  @Override
  public TreatmentModel find(long id) {
    return treatmentDao.find(id);
  }

  @Override
  public List<TreatmentModel> findAll() {
    return treatmentDao.findAll();
  }
}
