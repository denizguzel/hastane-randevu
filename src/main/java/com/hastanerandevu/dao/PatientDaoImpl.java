package com.hastanerandevu.dao;

import com.hastanerandevu.converter.PasswordEncryptor;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.utility.SessionUtils;

import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PatientDaoImpl extends BaseDaoImpl<PatientModel> {

  public boolean loginPatient (PatientModel patientModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.tcNumber = :TC_NUMBER AND e.password = :PASSWORD");
    query.setParameter("TC_NUMBER", patientModel.getTcNumber()).setParameter("PASSWORD", PasswordEncryptor.encryptPassword(patientModel.getPassword()));

    @SuppressWarnings ("unchecked") List<PatientModel> list = (List<PatientModel>) query.getResultList();

    if ( list.size() > 0 ) {
      HttpSession session = SessionUtils.getSession();
      session.setAttribute("firstName", list.get(0).getFirstName());
      return true;
    } else {
      return false;
    }
  }
}
