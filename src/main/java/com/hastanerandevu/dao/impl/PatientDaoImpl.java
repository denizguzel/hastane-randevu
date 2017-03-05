package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.converter.PasswordEncryptor;
import com.hastanerandevu.dao.PatientDao;
import com.hastanerandevu.model.PatientModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PatientDaoImpl implements PatientDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);
  private EntityManager entitymanager = emfactory.createEntityManager();

  @Override
  public PatientModel createPatient (String firstName, String password) {
    entitymanager.getTransaction().begin();
    PasswordEncryptor encryptor = new PasswordEncryptor();
    password = encryptor.encryptPassword(password);

    PatientModel patientModel = new PatientModel();
    patientModel.setFirstName(firstName);
    patientModel.setPassword(password);

    entitymanager.persist(patientModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
    return patientModel;
  }

  /*@Override
  public PatientModel loginPatient (String firstName, String password) {
    entitymanager.getTransaction().begin();
    PasswordEncryptor encryptor = new PasswordEncryptor();
    password = encryptor.encryptPassword(password);

    return (PatientModel) entitymanager.createQuery("SELECT e FROM PatientModel e WHERE e.firstName = :firstName AND e.password = :password").setParameter("firstName", firstName).setParameter("password", password).getSingleResult();
  }*/
}
