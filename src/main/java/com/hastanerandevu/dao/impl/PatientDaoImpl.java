package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.converter.PasswordEncryptor;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.utility.SessionUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PatientDaoImpl extends BaseDaoImpl<PatientModel> {

  public boolean login (PatientModel patientModel) {
    EntityManagerFactory emfactory     = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);
    EntityManager        entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    Query query = entitymanager.createQuery("SELECT e FROM PatientModel e WHERE e.tcNumber = :TC_NUMBER AND e.password = :PASSWORD");
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
