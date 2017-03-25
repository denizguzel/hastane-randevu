package com.hastanerandevu.dao;

import com.hastanerandevu.enums.HospitalTypeEnum;
import com.hastanerandevu.model.HospitalModel;

import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl extends BaseDaoImpl<HospitalModel> {

  public List<HospitalModel> getAllHospitalsByHospitalType(HospitalTypeEnum hospitalTypeEnum) {
    return getEntitymanager().createQuery("SELECT e FROM HospitalModel e WHERE e.hospitalType =:param", HospitalModel.class).setParameter("param", hospitalTypeEnum).getResultList();
  }

  public Map<String, String> getPoliclinicByHospital(HospitalModel hospitalModel) {

    Query query = getEntitymanager().createQuery("SELECT e.policlinic.policlinicName FROM HospitalPoliclinicRelModel e WHERE e.hospital = :hospitalModel ORDER BY e.policlinic.policlinicName");
    query.setParameter("hospitalModel", hospitalModel);

    Query query1 = getEntitymanager().createQuery("SELECT e.pk FROM HospitalPoliclinicRelModel e WHERE e.hospital = :hospitalModel ORDER BY e.policlinic.policlinicName");
    query1.setParameter("hospitalModel", hospitalModel);

    List<String> values = query.getResultList();
    List<String> keys = query1.getResultList();


    Map<String, String> results = new LinkedHashMap<>();
    for(int i = 0; i < keys.size(); i++) {
      results.put(values.get(i), keys.get(i));
    }

    return results;
  }
}
