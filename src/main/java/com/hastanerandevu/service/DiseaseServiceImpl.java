package com.hastanerandevu.service;

import com.hastanerandevu.dao.DiseaseDaoImpl;
import com.hastanerandevu.model.DiseaseModel;

import java.util.List;

public class DiseaseServiceImpl implements BaseService<DiseaseModel> {
  private DiseaseDaoImpl diseaseDao = new DiseaseDaoImpl();

  @Override
  public void create (DiseaseModel model) {
    diseaseDao.create(model);
  }

  @Override
  public void update (long id, DiseaseModel model) {
    diseaseDao.update(id, model);
  }

  @Override
  public void delete (long id) {
    diseaseDao.delete(id);
  }

  @Override
  public DiseaseModel find (long id) {
    return diseaseDao.find(id);
  }

  @Override
  public List<DiseaseModel> findAll () {
    return diseaseDao.findAll();
  }
}
