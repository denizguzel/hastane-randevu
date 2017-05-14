package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.AssayModel;
import com.hastanerandevu.model.PatientAssayRelModel;
import com.hastanerandevu.model.PatientModel;

import javax.persistence.Query;

public class PatientAssayRelDaoImpl extends BaseDaoImpl<PatientAssayRelModel> {

  public boolean patientHaveAssay(PatientModel patientModel, AssayModel assayModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientAssayRelModel e " +
      "WHERE e.patient = :patient and e.assay = :assay");

    query.setParameter("patient", patientModel);
    query.setParameter("assay", assayModel);

    return query.getResultList().size() > 0;
  }
}
