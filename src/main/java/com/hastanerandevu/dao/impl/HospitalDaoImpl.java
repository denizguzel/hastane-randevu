package com.hastanerandevu.dao.impl;

import com.hastanerandevu.enums.HospitalTypeEnum;
import com.hastanerandevu.model.HospitalModel;
import com.hastanerandevu.model.HospitalPoliclinicRelModel;

import javax.persistence.Query;
import java.util.List;

public class HospitalDaoImpl extends BaseDaoImpl<HospitalModel> {

  public List<HospitalModel> getAllHospitalsByHospitalType(HospitalTypeEnum hospitalTypeEnum) {
    return getEntitymanager().createQuery("SELECT e FROM HospitalModel e WHERE e.hospitalType =:param", HospitalModel.class).setParameter("param", hospitalTypeEnum).getResultList();
  }

  public List<HospitalPoliclinicRelModel> getPoliclinicByHospital(HospitalModel hospitalModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalPoliclinicRelModel e WHERE e.hospital = :hospitalModel ORDER BY e.policlinic.policlinicName");
    query.setParameter("hospitalModel", hospitalModel);

    return query.getResultList();
  }
}
