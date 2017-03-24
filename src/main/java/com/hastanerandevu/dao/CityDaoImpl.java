package com.hastanerandevu.dao;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl extends BaseDaoImpl<CityModel> {

  public List<String> getAllDistrictsByCity(CityModel cityModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM DistrictModel e WHERE e.cityModel = :CITY_MODEL ORDER BY e.districtName");
    query.setParameter("CITY_MODEL", cityModel);
    List<DistrictModel> list = query.getResultList();
    List<String> result = new ArrayList<>(list.size());
    for(DistrictModel districtModel : list) {
      result.add(districtModel.getDistrictName());
    }

    return result;
  }

  public void createDistricts(List<DistrictModel> districtModels, CityModel cityModel) {
    getEntitymanager().getTransaction().begin();

    for(DistrictModel districtModel : districtModels) {
      getEntitymanager().persist(districtModel);
    }

    getEntitymanager().getTransaction().commit();
  }

  @SuppressWarnings("unchecked")
  public List<String> getCities() {

    Query query = getEntitymanager().createQuery("SELECT e FROM CityModel e ORDER BY e.cityName");

    List<CityModel> list = query.getResultList();
    List<String> result = new ArrayList<>(list.size());
    for(CityModel cityModel : list) {
      result.add(cityModel.getCityName());
    }

    return result;
  }
}
