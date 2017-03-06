package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.DiseaseTypeDao;
import com.hastanerandevu.dao.impl.DiseaseTypeDaoImpl;
import com.hastanerandevu.model.DiseaseTypeModel;
import com.hastanerandevu.service.DiseaseTypeService;

import java.util.List;

public class DiseaseTypeServiceImpl implements DiseaseTypeService {
  private DiseaseTypeDao diseaseTypeDao = new DiseaseTypeDaoImpl();

  @Override
  public void createDiseaseType (String diseaseTypeName) {
    diseaseTypeDao.createDiseaseType(diseaseTypeName);
  }

  @Override
  public void updateDiseaseType (long id, String diseaseTypeName) {
    diseaseTypeDao.updateDiseaseType(id, diseaseTypeName);
  }

  @Override
  public void deleteDiseaseType (long id) {
    diseaseTypeDao.deleteDiseaseType(id);
  }

  @Override
  public DiseaseTypeModel findDiseaseType (long id) {
    return diseaseTypeDao.findDiseaseType(id);
  }

  @Override
  public List<DiseaseTypeModel> getAllDiseaseTypes () {
    return diseaseTypeDao.getAllDiseaseTypes();
  }
}
