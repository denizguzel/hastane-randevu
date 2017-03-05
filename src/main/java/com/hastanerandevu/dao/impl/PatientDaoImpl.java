package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.converter.PasswordEncryptor;
import com.hastanerandevu.dao.PatientDao;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.utility.SessionUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class PatientDaoImpl implements PatientDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public boolean createPatient (String firstName, String lastName, String password, String tcNumber, Date birthDate, String birthPlace, String email, String phoneNumber, String address, String fatherName, String motherName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    password = PasswordEncryptor.encryptPassword(password);

    PatientModel patientModel = new PatientModel();
    patientModel.setFirstName(firstName);
    patientModel.setLastName(lastName);
    patientModel.setPassword(password);
    patientModel.setTcNumber(tcNumber);
    patientModel.setDateOfBirth(birthDate);
    patientModel.setPlaceOfBirth(birthPlace);
    patientModel.setEmail(email);
    patientModel.setPhoneNumber(phoneNumber);
    patientModel.setAddress(address);
    patientModel.setFatherName(fatherName);
    patientModel.setMotherName(motherName);
    patientModel.setCreationTime(new Date());
    patientModel.setModifiedTime(new Date());
    patientModel.setIsActive((char) 1);


    entitymanager.persist(patientModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
    return true;
  }

  @Override
  public boolean loginPatient (String tcNumber, String password) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    Query query = entitymanager.createQuery("SELECT e FROM PatientModel e WHERE e.tcNumber = :tcNumber AND e.password = :password", PatientModel.class);
    query.setParameter("tcNumber", tcNumber).setParameter("password", PasswordEncryptor.encryptPassword(password));
    PatientModel patientModel = (PatientModel) query.getSingleResult();

    if ( patientModel != null ) {
      HttpSession session = SessionUtils.getSession();
      session.setAttribute("firstName", patientModel.getFirstName());
      entitymanager.close();
      emfactory.close();
      return true;
    }
    else{
      entitymanager.close();
      emfactory.close();
      return false;
    }
  }

  @Override
  public PatientModel findPatient (long id) {
    EntityManager entityManager = emfactory.createEntityManager();
    return entityManager.find(PatientModel.class, id);
  }
}
