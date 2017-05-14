package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.PatientAssayRelDaoImpl;
import com.hastanerandevu.model.AssayModel;
import com.hastanerandevu.model.PatientAssayRelModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class PatientAssayRelServiceImpl implements BaseService<PatientAssayRelModel> {
  private PatientAssayRelDaoImpl patientAssayRelDao = new PatientAssayRelDaoImpl();

  @Override
  public void create(PatientAssayRelModel model) {
    patientAssayRelDao.create(model);
  }

  @Override
  public void update(PatientAssayRelModel model) {
    patientAssayRelDao.update(model);
  }

  @Override
  public void delete(PatientAssayRelModel model) {
    patientAssayRelDao.delete(model);
  }

  @Override
  public PatientAssayRelModel find(long id) {
    return patientAssayRelDao.find(id);
  }

  @Override
  public List<PatientAssayRelModel> findAll() {
    return patientAssayRelDao.findAll();
  }

  public boolean patientHaveAssay(PatientModel patientModel, AssayModel assayModel) {
    return patientAssayRelDao.patientHaveAssay(patientModel, assayModel);
  }
}
