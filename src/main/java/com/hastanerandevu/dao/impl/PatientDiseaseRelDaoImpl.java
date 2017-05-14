package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.DiseaseModel;
import com.hastanerandevu.model.PatientDiseaseRelModel;
import com.hastanerandevu.model.PatientModel;

import javax.persistence.Query;

public class PatientDiseaseRelDaoImpl extends BaseDaoImpl<PatientDiseaseRelModel> {

  public boolean patientHaveDisease(PatientModel patientModel, DiseaseModel diseaseModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientDiseaseRelModel e " +
      "WHERE e.patient = :patient and e.disease = :disease");

    query.setParameter("patient", patientModel);
    query.setParameter("disease", diseaseModel);

    return query.getResultList().size() > 0;
  }
}
