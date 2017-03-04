package com.hastanerandevu.service.impl;

/**
 * Created by Okan on 4.3.2017.
 */


import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.service.CityService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CityServiceImpl implements CityService {
  EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
  @Override
  public CityModel findCity(long id){
    EntityManager entitymanager = emfactory.createEntityManager( );
    return entitymanager.find( CityModel.class, id );
  }

  @Override
  public List<DistrictModel> getAllDistrictsByCity(CityModel cityModel) {

    EntityManager entitymanager = emfactory.createEntityManager( );
    List<DistrictModel> districtModels = entitymanager.createQuery("SELECT e FROM DistrictModel e WHERE e.owner = :cityModel",DistrictModel.class).setParameter("cityModel",cityModel).getResultList();
    return districtModels;
  }

  public void createDistricts(List<DistrictModel> districtModelsList, CityModel cityModel){
    EntityManager entitymanager = emfactory.createEntityManager( );
    entitymanager.getTransaction( ).begin( );

    for (DistrictModel districtModel : districtModelsList){
      entitymanager.persist(districtModel);
    }

    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();

  }

  @Override
  public void createCity(String cityName) {

    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    CityModel cityModel = new CityModel();
    cityModel.setCityName(cityName);

    entitymanager.persist(cityModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void updateCity(long id, String cityName) {

    EntityManager entitymanager = emfactory.createEntityManager( );
    entitymanager.getTransaction( ).begin( );
    CityModel cityModel = entitymanager.find( CityModel.class,id);

    cityModel.setCityName(cityName);
    entitymanager.getTransaction( ).commit( );

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteCity(long id) {
    EntityManager entitymanager = emfactory.createEntityManager( );
    entitymanager.getTransaction( ).begin( );

    CityModel cityModel = entitymanager.find( CityModel.class, id );
    entitymanager.remove( cityModel );
    entitymanager.getTransaction( ).commit( );
    entitymanager.close( );
    emfactory.close( );
  }
}
