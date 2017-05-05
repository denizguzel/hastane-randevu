package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.PatientAlergyRelDaoImpl;
import com.hastanerandevu.model.PatientAlergyRelModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class PatientAlergyRelServiceImpl implements BaseService<PatientAlergyRelModel> {
  private PatientAlergyRelDaoImpl patientAlergyRelDao = new PatientAlergyRelDaoImpl();

  @Override
  public void create(PatientAlergyRelModel model) {
    patientAlergyRelDao.create(model);
  }

  @Override
  public void update(PatientAlergyRelModel model) {
    patientAlergyRelDao.update(model);
  }

  @Override
  public void delete(PatientAlergyRelModel model) {
    patientAlergyRelDao.delete(model);
  }

  @Override
  public PatientAlergyRelModel find(long id) {
    return patientAlergyRelDao.find(id);
  }

  @Override
  public List<PatientAlergyRelModel> findAll() {
    return patientAlergyRelDao.findAll();
  }
}
