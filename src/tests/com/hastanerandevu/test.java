package com.hastanerandevu;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.model.HospitalModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {
  public static void main (String[] args) {
    long                 id            = 3;
    EntityManagerFactory emfactory     = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);
    EntityManager        entitymanager = emfactory.createEntityManager();
    HospitalModel        hospitalModel = entitymanager.find(HospitalModel.class, id);

    System.out.println(hospitalModel.getHospitalType().getLocalizedString());

  }
}
