package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.*;

import javax.persistence.Query;
import java.util.List;

public class CityDaoImpl extends BaseDaoImpl<CityModel> {

  public List<CityModel> getCities() {

    Query query = getEntitymanager().createQuery("SELECT e FROM CityModel e ORDER BY e.cityName");

    return query.getResultList();
  }

  public List<DistrictModel> getAllDistrictsByCity(CityModel cityModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM DistrictModel e WHERE e.cityModel = :cityModel ORDER BY e.districtName");
    query.setParameter("cityModel", cityModel);

    return query.getResultList();
  }

  public List<HospitalPoliclinicRelModel> getPoliclinicByCity(CityModel cityModel){
    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalPoliclinicRelModel e WHERE e.hospital.districtModel.cityModel = :cityModel ORDER BY e.policlinic.policlinicName");
    query.setParameter("cityModel",cityModel);

    return query.getResultList();
  }

  public List<HospitalModel> getHospitalByCity(CityModel cityModel){
    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalModel e WHERE e.districtModel.cityModel = :cityModel ORDER BY e.hospitalName");
    query.setParameter("cityModel",cityModel);

    return query.getResultList();
  }

  /*public void createDistricts(List<DistrictModel> districtModels, CityModel cityModel) {
    getEntitymanager().getTransaction().begin();

    for(DistrictModel districtModel : districtModels) {
      getEntitymanager().persist(districtModel);
    }

    getEntitymanager().getTransaction().commit();
  }*/
}
