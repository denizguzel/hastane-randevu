package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.model.DistrictModel;
import com.hastanerandevu.model.HospitalModel;
import com.hastanerandevu.model.HospitalPoliclinicRelModel;

import javax.persistence.Query;
import java.util.List;

public class CityDaoImpl extends BaseDaoImpl<CityModel> {

  public List<CityModel> getCities() {

    Query query = getEntitymanager().createQuery("SELECT e FROM CityModel e ORDER BY e.pk ASC");

    return query.getResultList();
  }

  public List<DistrictModel> getAllDistrictsByCity(CityModel cityModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM DistrictModel e WHERE e.cityModel = :cityModel ORDER BY e.pk ASC");
    query.setParameter("cityModel", cityModel);

    return query.getResultList();
  }

  public List<HospitalPoliclinicRelModel> getPoliclinicByCity(CityModel cityModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalPoliclinicRelModel e WHERE e.hospital.districtModel.cityModel = :cityModel ORDER BY e.policlinic.policlinicName");
    query.setParameter("cityModel", cityModel);

    return query.getResultList();
  }

  public List<HospitalModel> getHospitalByCity(CityModel cityModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalModel e WHERE e.districtModel.cityModel = :cityModel ORDER BY e.hospitalName");
    query.setParameter("cityModel", cityModel);

    return query.getResultList();
  }
}
