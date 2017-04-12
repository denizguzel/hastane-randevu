package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.DiseaseDaoImpl;
import com.hastanerandevu.model.DiseaseModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class DiseaseServiceImpl implements BaseService<DiseaseModel> {
  private DiseaseDaoImpl diseaseDao = new DiseaseDaoImpl();

  @Override
  public void create(DiseaseModel model) {
    diseaseDao.create(model);
  }

  @Override
  public void update(DiseaseModel model) {
    diseaseDao.update(model);
  }

  @Override
  public void delete(DiseaseModel model) {
    diseaseDao.delete(model);
  }

  @Override
  public DiseaseModel find(long id) {
    return diseaseDao.find(id);
  }

  @Override
  public List<DiseaseModel> findAll() {
    return diseaseDao.findAll();
  }
}
