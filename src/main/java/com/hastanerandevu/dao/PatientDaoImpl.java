package com.hastanerandevu.dao;

import com.hastanerandevu.converter.PasswordEncryptor;
import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.utility.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public class PatientDaoImpl extends BaseDaoImpl<PatientModel> {

  public void createPatient (PatientModel patientModel) {
    if ( haveUserRegistration(patientModel) ) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bu kullanıcı sistemde zaten kayıtlı", null));
    } else {
      create(patientModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt Başarılı", null));
    }
  }

  public boolean loginPatient (PatientModel patientModel) {

    Query query = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.tcNumber = :TC_NUMBER AND e.password = :PASSWORD");
    query.setParameter("TC_NUMBER", patientModel.getTcNumber()).setParameter("PASSWORD", PasswordEncryptor.encryptPassword(patientModel.getPassword()));

    @SuppressWarnings ("unchecked")
    List<PatientModel> list = (List<PatientModel>) query.getResultList();

    if ( list.size() > 0 ) {
      HttpSession session = SessionUtils.getSession();
      session.setAttribute("firstName", list.get(0).getFirstName());
      return true;
    } else {
      return false;
    }
  }

  // HASTANIN HALI HAZIRDA OLAN RANDEVU SAYISI. ÜÇÜ GEÇİP GEÇMEDİĞİNİN KONTROLU BURDAN YAPILACAK.
  public long getNumberOfPatientAppointments (PatientModel patientModel) {
    Query query = getEntitymanager().createQuery("SELECT COUNT(id) FROM AppointmentModel e WHERE e.appointmentStatus = :APPOINTMENT_STATUS" + " AND e.patient = :PATIENT AND e.isActive = :IS_ACTIVE");

    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.RESERVED);
    query.setParameter("PATIENT", patientModel);
    query.setParameter("IS_ACTIVE", '1');

    return (long) query.getResultList().get(0);
  }

  // HASTANIN O GUNE GECERLI RANDEVUSU OLUP OLMADIGI BILGISI.. AYNI GUNE RANDEVU ALINAMAMASI KONTROLU BURDAN YAPILACAK.
  public boolean haveAnAppointmentForThatDay (PatientModel patientModel, Date date) {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE e.appointmentStatus = :APPOINTMENT_STATUS" + " AND e.patient = :PATIENT AND e.isActive = :IS_ACTIVE AND e.appointmentDate =: DATE");

    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.RESERVED);
    query.setParameter("PATIENT", patientModel);
    query.setParameter("DATE", date);
    query.setParameter("IS_ACTIVE", '1');

    return query.getResultList().size() > 0;
  }

  //HASTANIN RANDEVU GECMISI
  public List<AppointmentModel> getAppointmentHistory (PatientModel patientModel) {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE e.patient = :PATIENT  AND e.isActive = :IS_ACTIVE ORDER BY e.creationTime");
    query.setParameter("IS_ACTIVE", '1');

    return query.getResultList();
  }

  //GIRILEN BILGILERE DAIR SISTEMDE HASTA KAYDI VAR MI?
  private boolean haveUserRegistration (PatientModel patientModel) {
    Query emailQuery = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.tcNumber = :TC_NUMBER").setParameter("TC_NUMBER", patientModel.getTcNumber());
    Query tcQuery    = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.email = :E_MAIL").setParameter("E_MAIL", patientModel.getEmail());

    return emailQuery.getResultList().size() > 0 || tcQuery.getResultList().size() > 0;
  }
}
