package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.AlergyModel;
import com.hastanerandevu.model.PatientAlergyRelModel;
import com.hastanerandevu.model.PatientModel;

import javax.persistence.Query;

public class PatientAlergyRelDaoImpl extends BaseDaoImpl<PatientAlergyRelModel> {

  public boolean patientHaveAlergy(PatientModel patientModel, AlergyModel alergyModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientAlergyRelModel e " +
      "WHERE e.patient = :PATIENT_MODEL and e.alergy = :ALERGY_MODEL");

    query.setParameter("PATIENT_MODEL", patientModel);
    query.setParameter("ALERGY_MODEL", alergyModel);

    return query.getResultList().size() > 0;
  }
}
