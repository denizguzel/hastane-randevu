package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.PatientDiseaseRelDaoImpl;
import com.hastanerandevu.model.DiseaseModel;
import com.hastanerandevu.model.PatientDiseaseRelModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class PatientDiseaseRelServiceImpl implements BaseService<PatientDiseaseRelModel> {
  private PatientDiseaseRelDaoImpl patientDiseaseRelDao = new PatientDiseaseRelDaoImpl();

  @Override
  public void create(PatientDiseaseRelModel model) {
    patientDiseaseRelDao.create(model);
  }

  @Override
  public void update(PatientDiseaseRelModel model) {
    patientDiseaseRelDao.update(model);
  }

  @Override
  public void delete(PatientDiseaseRelModel model) {
    patientDiseaseRelDao.delete(model);
  }

  @Override
  public PatientDiseaseRelModel find(long id) {
    return patientDiseaseRelDao.find(id);
  }

  @Override
  public List<PatientDiseaseRelModel> findAll() {
    return patientDiseaseRelDao.findAll();
  }

  public boolean patientHaveDisease(PatientModel patientModel, DiseaseModel diseaseModel) {
    return patientDiseaseRelDao.patientHaveDisease(patientModel, diseaseModel);
  }
}
