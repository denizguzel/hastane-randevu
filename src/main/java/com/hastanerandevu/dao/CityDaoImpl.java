package com.hastanerandevu.dao;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

import javax.persistence.Query;
import java.util.List;

public class CityDaoImpl extends BaseDaoImpl<CityModel> {

  public List<DistrictModel> getAllDistrictsByCity(CityModel cityModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM DistrictModel e WHERE e.cityModel = :CITY_MODEL ORDER BY e.districtName");
    query.setParameter("CITY_MODEL", cityModel);

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

    Query query = getEntitymanager().createQuery("SELECT e FROM CityModel e ORDER BY e.cityName");

    return (List<CityModel>) query.getResultList();
  }
}
