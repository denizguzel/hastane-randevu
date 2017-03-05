package com.hastanerandevu.dao.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.CityDao;
import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CityDaoImpl implements CityDao {
  private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);

  @Override
  public void createCity (String cityName) {
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
  public void updateCity (long id, String cityName) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();
    CityModel cityModel = entitymanager.find(CityModel.class, id);

    cityModel.setCityName(cityName);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();
  }

  @Override
  public void deleteCity (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    CityModel cityModel = entitymanager.find(CityModel.class, id);
    entitymanager.remove(cityModel);
    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }

  @Override
  public CityModel findCity (long id) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.find(CityModel.class, id);
  }

  @Override
  public List<CityModel> getAllCities () {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM CityModel e", CityModel.class).getResultList();
  }

  @Override
  public List<DistrictModel> getAllDistrictsByCity (CityModel cityModel) {
    EntityManager entitymanager = emfactory.createEntityManager();
    return entitymanager.createQuery("SELECT e FROM DistrictModel e WHERE e.city = :cityModel", DistrictModel.class).setParameter("cityModel", cityModel).getResultList();
  }

  @Override
  public void createDistricts (List<DistrictModel> districtModels, CityModel cityModel) {
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    for ( DistrictModel districtModel : districtModels ) {
      entitymanager.persist(districtModel);
    }

    entitymanager.getTransaction().commit();
    entitymanager.close();
    emfactory.close();
  }
}
