package com.hastanerandevu.dao;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

import javax.persistence.Query;
import java.util.List;

public class CityDaoImpl extends BaseDaoImpl<CityModel> {

  public List<DistrictModel> getAllDistrictsByCity(CityModel cityModel) {
    Query query1 = getEntitymanager().createQuery("SELECT e FROM CityModel e WHERE e.cityName = :CITY_NAME").setParameter("CITY_NAME", cityModel.getCityName());
    cityModel = (CityModel) query1.getSingleResult();

    Query query = getEntitymanager().createQuery("SELECT e.districtName FROM DistrictModel e WHERE e.cityModel = :cityModel").setParameter("cityModel", cityModel);

    return (List<DistrictModel>) query.getResultList();
  }

  public void createDistricts(List<DistrictModel> districtModels, CityModel cityModel) {
    getEntitymanager().getTransaction().begin();

    for(DistrictModel districtModel : districtModels) {
      getEntitymanager().persist(districtModel);
    }

    getEntitymanager().getTransaction().commit();
  }

  @SuppressWarnings("unchecked")
  public List<CityModel> getCities() {

    Query query = getEntitymanager().createQuery("SELECT e.cityName FROM CityModel e");

    return (List<CityModel>) query.getResultList();
  }
}
