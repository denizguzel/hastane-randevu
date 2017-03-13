package com.hastanerandevu.dao;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;

import java.util.List;

public class CityDaoImpl extends BaseDaoImpl<CityModel> {

  public List<DistrictModel> getAllDistrictsByCity (CityModel model) {
    return getEntitymanager().createQuery("SELECT e FROM DistrictModel e WHERE e.city = :cityModel", DistrictModel.class).setParameter("cityModel", model).getResultList();
  }

  public void createDistricts (List<DistrictModel> districtModels, CityModel model) {
    getEntitymanager().getTransaction().begin();

    for ( DistrictModel districtModel : districtModels ) {
      getEntitymanager().persist(districtModel);
    }

    getEntitymanager().getTransaction().commit();
  }
}
