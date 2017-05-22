package com.hastanerandevu.dao.impl;

import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.HospitalPoliclinicRelModel;
import com.hastanerandevu.model.InspectionPlaceModel;
import com.hastanerandevu.model.PoliclinicModel;
import com.hastanerandevu.utility.DateUtil;

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

  public List<InspectionPlaceModel> getAppointmentHeadersByPoliclinic(HospitalPoliclinicRelModel hospitalPoliclinicRelModel, Date startDate, Date endDate) {

    Query query = getEntitymanager().createQuery("SELECT DISTINCT(ip) FROM InspectionPlaceModel ip INNER JOIN ip.appointmentModels ap WHERE ip.hospitalPoliclinicRel = :HOSPITAL_POLICLINIC_REL AND ap.appointmentStatus = :APPOINTMENT_STATUS AND ap.appointmentDate BETWEEN :START_DATE AND :END_DATE");

    query.setParameter("HOSPITAL_POLICLINIC_REL", hospitalPoliclinicRelModel);
    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.NOT_RESERVED);
    query.setParameter("START_DATE", startDate);
    query.setParameter("END_DATE", endDate);

    return query.getResultList();
  }

  public List<InspectionPlaceModel> getAppointmentHeadersByPoliclinic(HospitalPoliclinicRelModel hospitalPoliclinicRelModel) {

    Query query = getEntitymanager().createQuery("SELECT DISTINCT(ip) FROM InspectionPlaceModel ip INNER JOIN ip.appointmentModels ap WHERE ip.hospitalPoliclinicRel = :HOSPITAL_POLICLINIC_REL AND ap.appointmentStatus = :APPOINTMENT_STATUS AND ap.appointmentDate > :START_DATE");

    query.setParameter("HOSPITAL_POLICLINIC_REL", hospitalPoliclinicRelModel);
    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.NOT_RESERVED);
    query.setParameter("START_DATE", DateUtil.getEndOfDay());

    return query.getResultList();
  }

  public List<InspectionPlaceModel> getAppointmentHeadersByPoliclinic(HospitalPoliclinicRelModel hospitalPoliclinicRelModel, Date startDate) {

    Query query = getEntitymanager().createQuery("SELECT DISTINCT(ip) FROM InspectionPlaceModel ip INNER JOIN ip.appointmentModels ap WHERE ip.hospitalPoliclinicRel = :HOSPITAL_POLICLINIC_REL AND ap.appointmentStatus = :APPOINTMENT_STATUS AND ap.appointmentDate > :START_DATE");

    query.setParameter("HOSPITAL_POLICLINIC_REL", hospitalPoliclinicRelModel);
    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.NOT_RESERVED);
    query.setParameter("START_DATE", startDate);

    return query.getResultList();
  }
}
