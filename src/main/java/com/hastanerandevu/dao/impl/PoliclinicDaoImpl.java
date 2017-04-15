package com.hastanerandevu.dao.impl;

import com.hastanerandevu.comparators.InspectionPlaceComparator;
import com.hastanerandevu.model.*;

import javax.persistence.Query;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class PoliclinicDaoImpl extends BaseDaoImpl<PoliclinicModel> {

  public List<InspectionPlaceModel> getInspectionPlacesByHospitalPoliclinic(PoliclinicModel policlinicModel, HospitalModel hospitalModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM HospitalPoliclinicRelModel e WHERE e.policlinic = :policlinicModel AND e.hospital = :hospitalModel ");
    query.setParameter("policlinicModel", policlinicModel);
    query.setParameter("hospitalModel", hospitalModel);

    HospitalPoliclinicRelModel hospitalPoliclinicRelModel = (HospitalPoliclinicRelModel) query.getResultList().get(0);

    List<InspectionPlaceModel> inspectionPlaceModels = hospitalPoliclinicRelModel.getInspectionPlaceModels();

    Collections.sort(inspectionPlaceModels, new InspectionPlaceComparator());

    return inspectionPlaceModels;
  }

  public List<AppointmentModel> getAppointmentsByPoliclinic(HospitalPoliclinicRelModel hospitalPoliclinicRelModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE " + "e.inspectionPlace.hospitalPoliclinicRel = :HOSPITAL_POLICLINIC_REL_MODEL " + "AND appointmentDate > :date " + "ORDER BY e.inspectionPlace.placeName,e.creationTime");

    query.setParameter("HOSPITAL_POLICLINIC_REL_MODEL", hospitalPoliclinicRelModel);
    query.setParameter("date", new Date());

    return query.getResultList();
  }

}
