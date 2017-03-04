package com.hastanerandevu.service.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.service.DistrictService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Okan on 4.3.2017.
 */
public class DistrictServiceImpl implements DistrictService {

  EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createDistrict(String districtName,CityModel cityModel) {

    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    DistrictModel districtModel = new DistrictModel();
    districtModel.setDistrictName(districtName);
    districtModel.setOwner(cityModel);

    entitymanager.persist(districtModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateDistrict(long id, String districtName) {
    EntityManager entitymanager = emfactory.createEntityManager( );
    entitymanager.getTransaction( ).begin( );
    DistrictModel districtModel = entitymanager.find( DistrictModel.class,id);

    districtModel.setDistrictName(districtName);
    entitymanager.getTransaction( ).commit( );

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteDistrict(long id) {
    EntityManager entitymanager = emfactory.createEntityManager( );
    entitymanager.getTransaction( ).begin( );

    DistrictModel districtModel = entitymanager.find( DistrictModel.class, id );
    entitymanager.remove( districtModel );
    entitymanager.getTransaction( ).commit( );
    entitymanager.close( );
    emfactory.close( );
  }

  @Override
  public DistrictModel findDistrict(long id) {
    EntityManager entitymanager = emfactory.createEntityManager( );
    return entitymanager.find( DistrictModel.class, id );
  }
}
