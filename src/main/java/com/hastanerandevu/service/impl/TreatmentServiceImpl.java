package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.TreatmentDao;
import com.hastanerandevu.dao.impl.TreatmentDaoImpl;
import com.hastanerandevu.model.TreatmentModel;
import com.hastanerandevu.service.TreatmentService;

import java.util.List;

public class TreatmentServiceImpl implements TreatmentService {
  private TreatmentDao treatmentDao = new TreatmentDaoImpl();

  @Override
  public void createTreatment (String treatmentName) {
    treatmentDao.createTreatment(treatmentName);
  }

  @Override
  public void updateTreatment (long id, String treatmentName) {
    treatmentDao.updateTreatment(id, treatmentName);
  }

  @Override
  public void deleteTreatment (long id) {
    treatmentDao.deleteTreatment(id);
  }

  @Override
  public TreatmentModel findTreatment (long id) {
    return treatmentDao.findTreatment(id);
  }

  @Override
  public List<TreatmentModel> getAllTreatments () {
    return treatmentDao.getAllTreatments();
  }
}
