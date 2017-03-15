package com.hastanerandevu.dao;

import com.hastanerandevu.converter.PasswordEncryptor;
import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.utility.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public class PatientDaoImpl extends BaseDaoImpl<PatientModel> {

  @Override
  public void create (PatientModel model) {
    Query emailQuery = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.email = :EMAIL");
    emailQuery.setParameter("EMAIL", model.getEmail());
    List emailList = emailQuery.getResultList();
    if ( !emailList.isEmpty() )
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Girilen e-mail adresi sistemde kayıtlı", null));
    else {
      Query tcNumberQuery = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.tcNumber = :TC_NUMBER");
      tcNumberQuery.setParameter("TC_NUMBER", model.getTcNumber());
      List tcNumberList = tcNumberQuery.getResultList();
      if ( !tcNumberList.isEmpty() ) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Girilen T.C. No sistemde kayıtlı", null));
      } else {
        try {
          getEntitymanager().getTransaction().begin();
          getEntitymanager().persist(model);
          getEntitymanager().getTransaction().commit();
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt Başarılı", null));
        } catch ( RuntimeException e ) {
          try {
            e.printStackTrace();
            getEntitymanager().getTransaction().rollback();
          } catch ( RuntimeException ex ) {
            ex.printStackTrace();
          } finally {
            getEntitymanager().close();
            getEmfactory().close();
          }
        }
      }
    }
  }

  public boolean loginPatient (PatientModel model) {

    Query query = getEntitymanager().createQuery("SELECT e FROM PatientModel e WHERE e.tcNumber = :TC_NUMBER AND e.password = :PASSWORD");
    query.setParameter("TC_NUMBER", model.getTcNumber()).setParameter("PASSWORD", PasswordEncryptor.encryptPassword(model.getPassword()));

    @SuppressWarnings ("unchecked") List<PatientModel> list = (List<PatientModel>) query.getResultList();

    if ( list.size() > 0 ) {
      HttpSession session = SessionUtils.getSession();
      session.setAttribute("firstName", list.get(0).getFirstName());
      return true;
    } else {
      return false;
    }
  }

  // HASTANIN HALI HAZIRDA OLAN RANDEVU SAYISI. ÜÇÜ GEÇİP GEÇMEDİĞİNİN KONTROLU BURDAN YAPILACAK.
  public long getNumberOfPatientAppointments (PatientModel model) {
    Query query = getEntitymanager().createQuery("SELECT COUNT(id) FROM AppointmentModel e WHERE e.appointmentStatus = :APPOINTMENT_STATUS" + " AND e.patient = :PATIENT AND e.isActive = :IS_ACTIVE");

    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.RESERVED);
    query.setParameter("PATIENT", model);
    query.setParameter("IS_ACTIVE", '1');

    return (long) query.getResultList().get(0);
  }

  // HASTANIN O GUNE GECERLI RANDEVUSU OLUP OLMADIGI BILGISI.. AYNI GUNE RANDEVU ALINAMAMASI KONTROLU BURDAN YAPILACAK.
  public boolean haveAnAppointmentForThatDay (PatientModel model, Date date) {
    Query query = getEntitymanager().createQuery("SELECT e FROM AppointmentModel e WHERE e.appointmentStatus =: APPOINTMENT_STATUS" + " AND e.patient =:PATIENT AND e.isActive =:IS_ACTIVE AND e.appointmentDate =: DATE");

    query.setParameter("APPOINTMENT_STATUS", AppointmentStatusEnum.RESERVED);
    query.setParameter("PATIENT", model);
    query.setParameter("DATE", date);
    query.setParameter("IS_ACTIVE", '1');

    return query.getResultList().size() > 0;
  }
}
