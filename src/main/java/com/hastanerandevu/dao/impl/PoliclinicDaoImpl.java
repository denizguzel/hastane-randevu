package com.hastanerandevu.dao.impl;

import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.HospitalPoliclinicRelModel;
import com.hastanerandevu.model.InspectionPlaceModel;
import com.hastanerandevu.model.PoliclinicModel;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class PoliclinicDaoImpl extends BaseDaoImpl<PoliclinicModel> {

  public List<InspectionPlaceModel> getInspectionPlacesByHospitalPoliclinicRel(HospitalPoliclinicRelModel hospitalPoliclinicRelModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM InspectionPlaceModel e WHERE e.hospitalPoliclinicRel = :HOSPITAL_POLICLINIC_REL ORDER BY e.placeName");

    query.setParameter("HOSPITAL_POLICLINIC_REL", hospitalPoliclinicRelModel);

    return query.getResultList();

  }

  public List<AppointmentModel> getAppointmentsByPoliclinic(HospitalPoliclinicRelModel hospitalPoliclinicRelModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE " + "e.inspectionPlace.hospitalPoliclinicRel = :HOSPITAL_POLICLINIC_REL_MODEL " + "AND appointmentDate > :date " + "ORDER BY e.inspectionPlace.placeName,e.creationTime");

    query.setParameter("HOSPITAL_POLICLINIC_REL_MODEL", hospitalPoliclinicRelModel);
    query.setParameter("date", new Date());

    return query.getResultList();
  }

}
