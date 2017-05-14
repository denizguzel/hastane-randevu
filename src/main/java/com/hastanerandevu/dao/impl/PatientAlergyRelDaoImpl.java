package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.AlergyModel;
import com.hastanerandevu.model.PatientAlergyRelModel;
import com.hastanerandevu.model.PatientModel;

import javax.persistence.Query;

public class PatientAlergyRelDaoImpl extends BaseDaoImpl<PatientAlergyRelModel> {

  public boolean patientHaveAlergy(PatientModel patientModel, AlergyModel alergyModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientAlergyRelModel e " +
      "WHERE e.patient = :patient and e.alergy = :alergy");

    query.setParameter("patient", patientModel);
    query.setParameter("alergy", alergyModel);

    return query.getResultList().size() > 0;
  }
}
