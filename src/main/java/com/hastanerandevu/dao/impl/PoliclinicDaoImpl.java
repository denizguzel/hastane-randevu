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
    Query query = getEntitymanager().createQuery("SELECT e FROM InspectionPlaceModel e WHERE e.hospitalPoliclinicRel = :hospitalPoliclinicRel ORDER BY e.placeName");

    query.setParameter("hospitalPoliclinicRel", hospitalPoliclinicRelModel);

    return query.getResultList();
  }

  public List<AppointmentModel> getAppointmentsByPoliclinic(HospitalPoliclinicRelModel hospitalPoliclinicRelModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE " + "e.inspectionPlace.hospitalPoliclinicRel = :hospitalPoliclinicRel " + "AND appointmentDate > :date " + "ORDER BY e.inspectionPlace.placeName,e.creationTime");

    query.setParameter("hospitalPoliclinicRel", hospitalPoliclinicRelModel);
    query.setParameter("date", new Date());

    return query.getResultList();
  }

  public List<AppointmentModel> getAppointmentsByDate(HospitalPoliclinicRelModel hospitalPoliclinicRelModel, Date startDate, Date endDate) {
    Query query = getEntitymanager().createQuery("SELECT e, e.inspectionPlace FROM AppointmentModel e WHERE " + "e.inspectionPlace.hospitalPoliclinicRel = :hospitalPoliclinicRel " + "AND e.appointmentDate >= :startDate AND e.appointmentDate <= :endDate GROUP BY e.inspectionPlace ORDER BY e.appointmentDate");

    query.setParameter("hospitalPoliclinicRel", hospitalPoliclinicRelModel);
    query.setParameter("startDate", startDate);
    query.setParameter("endDate", endDate);

    return query.getResultList();
  }
}
