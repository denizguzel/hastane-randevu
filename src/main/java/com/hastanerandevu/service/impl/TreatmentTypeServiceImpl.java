package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.TreatmentTypeDao;
import com.hastanerandevu.dao.impl.TreatmentTypeDaoImpl;
import com.hastanerandevu.model.TreatmentTypeModel;
import com.hastanerandevu.service.TreatmentTypeService;

import java.util.List;

public class TreatmentTypeServiceImpl implements TreatmentTypeService {
  private TreatmentTypeDao treatmentTypeDao = new TreatmentTypeDaoImpl();

  @Override
  public void createTreatmentType (String treatmentTypeName) {
    treatmentTypeDao.createTreatmentType(treatmentTypeName);
  }

  @Override
  public void updateTreatmentType (long id, String treatmentTypeName) {
    treatmentTypeDao.updateTreatmentType(id, treatmentTypeName);
  }

  @Override
  public void deleteTreatmentType (long id) {
    treatmentTypeDao.deleteTreatmentType(id);
  }

  @Override
  public TreatmentTypeModel findTreatmentType (long id) {
    return treatmentTypeDao.findTreatmentType(id);
  }

  @Override
  public List<TreatmentTypeModel> getAllTreatmentTypes () {
    return treatmentTypeDao.getAllTreatmentTypes();
  }
}
