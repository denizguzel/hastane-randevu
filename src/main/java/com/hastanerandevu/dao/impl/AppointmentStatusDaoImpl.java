package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.AppointmentStatusDao;
import com.hastanerandevu.model.AppointmentStatusModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AppointmentStatusDaoImpl implements AppointmentStatusDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createAppointmentStatus (String statusCode) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    AppointmentStatusModel appointmentStatusModel = new AppointmentStatusModel();
    appointmentStatusModel.setStatusCode(statusCode);

    entitymanager.persist(appointmentStatusModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateAppointmentStatus (long id, String statusCode) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    AppointmentStatusModel appointmentStatusModel = entitymanager.find(AppointmentStatusModel.class, id);

    appointmentStatusModel.setStatusCode(statusCode);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteAppointmentStatus (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    AppointmentStatusModel appointmentStatusModel = entitymanager.find(AppointmentStatusModel.class, id);
    entitymanager.remove(appointmentStatusModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public AppointmentStatusModel findAppointmentStatus (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(AppointmentStatusModel.class, id);
  }

  @Override
  public List<AppointmentStatusModel> getAllAppointmentStatuses () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM AppointmentStatusModel e", AppointmentStatusModel.class).getResultList();
  }
}
