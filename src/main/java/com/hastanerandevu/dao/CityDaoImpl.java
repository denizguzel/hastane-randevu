package com.hastanerandevu.dao;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CityDaoImpl extends BaseDaoImpl<CityModel> {

  public Map<String, String> getCities() {

    Query query = getEntitymanager().createQuery("SELECT e FROM CityModel e ORDER BY e.cityName");

    List<CityModel> list = query.getResultList();
    Map<String, String> results = new LinkedHashMap<>();
    for(CityModel cityModel : list) {
      results.put(cityModel.getCityName(), String.valueOf(cityModel.getPk())); //label, value
    }
    return results;
  }

  public Map<String, String> getAllDistrictsByCity(CityModel cityModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM DistrictModel e WHERE e.cityModel = :cityModel ORDER BY e.districtName");
    query.setParameter("cityModel", cityModel);

    List<DistrictModel> list = query.getResultList();
    Map<String, String> results = new LinkedHashMap<>();
    for(DistrictModel districtModel : list) {
      results.put(districtModel.getDistrictName(), String.valueOf(districtModel.getPk()));
    }

    return results;
  }

  public void createDistricts(List<DistrictModel> districtModels, CityModel cityModel) {
    getEntitymanager().getTransaction().begin();

    for(DistrictModel districtModel : districtModels) {
      getEntitymanager().persist(districtModel);
    }

    getEntitymanager().getTransaction().commit();
  }
}
