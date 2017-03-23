package com.hastanerandevu.dao;

import com.hastanerandevu.enums.HospitalTypeEnum;
import com.hastanerandevu.model.HospitalModel;
import com.hastanerandevu.model.PoliclinicModel;

import javax.persistence.Query;
import java.util.List;

public class HospitalDaoImpl extends BaseDaoImpl<HospitalModel> {

  public List<HospitalModel> getAllHospitalsByHospitalType(HospitalTypeEnum hospitalTypeEnum) {
    return getEntitymanager().createQuery("SELECT e FROM HospitalModel e WHERE e.hospitalType =:param", HospitalModel.class).setParameter("param", hospitalTypeEnum).getResultList();
  }

  public List<PoliclinicModel> getPoliclinicByHospital(HospitalModel hospitalModel) {
    /*Query query1 = getEntitymanager().createQuery("SELECT e FROM HospitalModel e WHERE e.hospitalName = :HOSPITAL_NAME").setParameter("HOSPITAL_NAME", hospitalModel.getHospitalName());

    hospitalModel = (HospitalModel) query1.getSingleResult();*/

    Query query = getEntitymanager().createQuery("SELECT e.policlinic FROM HospitalPoliclinicRelModel e WHERE e.hospital = :HOSPITAL ORDER BY e.policlinic.policlinicName");
    query.setParameter("HOSPITAL", hospitalModel);

    return (List<PoliclinicModel>) query.getResultList();
  }
}
