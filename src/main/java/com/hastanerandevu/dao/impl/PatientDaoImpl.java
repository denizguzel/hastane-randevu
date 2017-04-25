package com.hastanerandevu.dao.impl;

import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.*;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class PatientDaoImpl extends BaseDaoImpl<PatientModel> {

  public PatientModel loginPatient(PatientModel patientModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.tcNumber = :TC_NUMBER AND e.password = :PASSWORD");
    query.setParameter("TC_NUMBER", patientModel.getTcNumber()).setParameter("PASSWORD", Encryptor.encryptPassword(patientModel.getPassword()));

    if(query.getResultList().size() > 0) {
      return (PatientModel) query.getResultList().get(0);
    } else {
      return null;
    }
  }

  public boolean changingPasswordIsAvailable(PatientModel patientModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.pk = :PK" + " AND e.forgottenExpirationDate > :date");

    query.setParameter("date", new Date());
    query.setParameter("PK", patientModel.getPk());

    return query.getResultList().size() > 0;
  }

  // HASTANIN HALI HAZIRDA OLAN RANDEVU SAYISI. ÜÇÜ GEÇİP GEÇMEDİĞİNİN KONTROLU BURDAN YAPILACAK.
  public long getNumberOfPatientAppointments(PatientModel patientModel) {
    Query query = getEntitymanager().createQuery("SELECT COUNT(id) FROM AppointmentModel e WHERE e.appointmentStatus = :APPOINTMENT_STATUS" + " AND e.patient = :PATIENT AND e.isActive = :IS_ACTIVE");

    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.RESERVED);
    query.setParameter("PATIENT", patientModel);
    query.setParameter("IS_ACTIVE", '1');

    return (long) query.getResultList().get(0);
  }

  // HASTANIN O GUNE GECERLI RANDEVUSU OLUP OLMADIGI BILGISI.. AYNI GUNE RANDEVU ALINAMAMASI KONTROLU BURDAN YAPILACAK.
  public boolean haveAnAppointmentForThatDay(PatientModel patientModel, Date date) {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE e.appointmentStatus = :APPOINTMENT_STATUS" + " AND e.patient = :PATIENT AND e.isActive = :IS_ACTIVE AND e.appointmentDate =: DATE");

    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.RESERVED);
    query.setParameter("PATIENT", patientModel);
    query.setParameter("DATE", date);
    query.setParameter("IS_ACTIVE", '1');

    return query.getResultList().size() > 0;
  }

  //HASTANIN RANDEVU GECMISI
  public List<AppointmentModel> getAppointmentHistory(PatientModel patientModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE e.patient = :PATIENT  AND e.isActive = :IS_ACTIVE ORDER BY e.creationTime");
    query.setParameter("IS_ACTIVE", '1');

    return query.getResultList();
  }

  //GIRILEN BILGILERE DAIR SISTEMDE HASTA KAYDI VAR MI?
  public boolean haveUserRegistration(PatientModel patientModel) {
    Query tcQuery = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.tcNumber = :TC_NUMBER").setParameter("TC_NUMBER", patientModel.getTcNumber());
    Query emailQuery = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.email = :E_MAIL").setParameter("E_MAIL", patientModel.getEmail());

    return emailQuery.getResultList().size() > 0 || tcQuery.getResultList().size() > 0;
  }

  public PatientModel getUserByEmail(String email){
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.email = :E_MAIL").setParameter("E_MAIL", email);

    if (query.getResultList().isEmpty()){
      return null;
    }
    else{
      return (PatientModel) query.getResultList().get(0);
    }
  }

  public List<PatientTreatmentRelModel> getPatientTreatments(PatientModel patientModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientTreatmentRelModel e WHERE e.patient = :PATIENT ORDER BY e.treatment.treatmentName");
    query.setParameter("PATIENT", patientModel);

    return query.getResultList();
  }

  public List<PatientAlergyRelModel> getPatientAlergies(PatientModel patientModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientAlergyRelModel e WHERE e.patient = :PATIENT ORDER BY e.alergy.alergyName");
    query.setParameter("PATIENT", patientModel);

    return query.getResultList();
  }

  public List<PatientAssayRelModel> getPatientAssays(PatientModel patientModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientAssayRelModel e WHERE e.patient = :PATIENT ORDER BY e.assay.assayName");
    query.setParameter("PATIENT", patientModel);

    return query.getResultList();
  }

  public List<PatientDiseaseRelModel> getPatientDiseases(PatientModel patientModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM PatientDiseaseRelModel e WHERE e.patient = :PATIENT ORDER BY e.disease.diseaseName");
    query.setParameter("PATIENT", patientModel);

    return query.getResultList();
  }
}
