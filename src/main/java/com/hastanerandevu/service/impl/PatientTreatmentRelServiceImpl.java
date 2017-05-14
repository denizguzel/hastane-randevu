package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.PatientTreatmentRelDaoImpl;
import com.hastanerandevu.model.PatientTreatmentRelModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class PatientTreatmentRelServiceImpl implements BaseService<PatientTreatmentRelModel> {
  private PatientTreatmentRelDaoImpl patientTreatmentRelDao = new PatientTreatmentRelDaoImpl();

  @Override
  public void create(PatientTreatmentRelModel model) {
    patientTreatmentRelDao.create(model);
  }

  @Override
  public void update(PatientTreatmentRelModel model) {
    patientTreatmentRelDao.update(model);
  }

  @Override
  public void delete(PatientTreatmentRelModel model) {
    patientTreatmentRelDao.delete(model);
  }

  @Override
  public PatientTreatmentRelModel find(long id) {
    return patientTreatmentRelDao.find(id);
  }

  @Override
  public List<PatientTreatmentRelModel> findAll() {
    return patientTreatmentRelDao.findAll();
  }

}
