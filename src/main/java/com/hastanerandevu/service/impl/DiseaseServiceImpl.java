package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.DiseaseDao;
import com.hastanerandevu.dao.impl.DiseaseDaoImpl;
import com.hastanerandevu.model.DiseaseModel;
import com.hastanerandevu.service.DiseaseService;

import java.util.List;

public class DiseaseServiceImpl implements DiseaseService {
  private DiseaseDao diseaseDao = new DiseaseDaoImpl();

  @Override
  public void createDisease (String diseaseName) {
    diseaseDao.createDisease(diseaseName);
  }

  @Override
  public void updateDisease (long id, String diseaseName) {
    diseaseDao.updateDisease(id, diseaseName);
  }

  @Override
  public void deleteDisease (long id) {
    diseaseDao.deleteDisease(id);
  }

  @Override
  public DiseaseModel findDisease (long id) {
    return diseaseDao.findDisease(id);
  }

  @Override
  public List<DiseaseModel> getAllDiseases () {
    return diseaseDao.getAllDiseases();
  }
}
