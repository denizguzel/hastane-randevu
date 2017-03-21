package com.hastanerandevu.dao;

import com.hastanerandevu.constants.ProjectConstants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
  private Class<T> persistentClass;
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);
  private EntityManager entitymanager = emfactory.createEntityManager();

  @SuppressWarnings("unchecked")
  public BaseDaoImpl() {
    this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  private BaseDaoImpl(Class<T> persistentClass) {
    this.persistentClass = persistentClass;
  }

  public EntityManager getEntitymanager() {
    return entitymanager;
  }

  public EntityManagerFactory getEmfactory() {
    return emfactory;
  }

  @Override
  public void create(T model) {
    try {
      if (!entitymanager.getTransaction().isActive()){
        entitymanager.getTransaction().begin();
      }
      entitymanager.persist(model);
      entitymanager.getTransaction().commit();
    } catch(RuntimeException e) {
      try {
        e.printStackTrace();
        entitymanager.getTransaction().rollback();
      } catch(RuntimeException ex) {
        ex.printStackTrace();
      } finally {
        entitymanager.close();
        emfactory.close();
      }
    }
  }

  @Override
  public void update(T model) {
    try {
      if (!entitymanager.getTransaction().isActive()){
        entitymanager.getTransaction().begin();
      }
      entitymanager.merge(model);
      entitymanager.getTransaction().commit();
    } catch(RuntimeException e) {
      try {
        e.printStackTrace();
        entitymanager.getTransaction().rollback();
      } catch(RuntimeException ex) {
        ex.printStackTrace();
      } finally {
        entitymanager.close();
        emfactory.close();
      }
    }
  }

  @Override
  public void delete(T model) {
    try {
      if (!entitymanager.getTransaction().isActive()){
        entitymanager.getTransaction().begin();
      }
      entitymanager.remove(model);
      entitymanager.getTransaction().commit();
    } catch(RuntimeException e) {
      try {
        e.printStackTrace();
        entitymanager.getTransaction().rollback();
      } catch(RuntimeException ex) {
        ex.printStackTrace();
      } finally {
        entitymanager.close();
        emfactory.close();
      }
    }
  }

  @Override
  public T find(long id) {
    if (!entitymanager.getTransaction().isActive()){
      entitymanager.getTransaction().begin();
    }
    return entitymanager.find(persistentClass, id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<T> findAll() {
    if (!entitymanager.getTransaction().isActive()){
      entitymanager.getTransaction().begin();
    }
    return entitymanager.createQuery("SELECT e FROM " + persistentClass.getName() + " e").getResultList();
  }
}
