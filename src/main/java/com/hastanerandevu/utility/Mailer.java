package com.hastanerandevu.utility;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.converter.NameConverter;
import com.hastanerandevu.exceptions.NoUserException;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

public class Mailer implements Runnable {

  private final int port = SessionUtils.getRequest().getLocalPort();
  private final String serverName = SessionUtils.getRequest().getServerName();
  private static final Logger LOG = Logger.getLogger(Mailer.class);
  private PatientServiceImpl patientService = new PatientServiceImpl();
  private VelocityEngine velocityEngine = new VelocityEngine();
  private VelocityContext velocityContext = new VelocityContext();
  private StringWriter stringWriter = new StringWriter();
  private Thread thread;
  private Template template;

  private String recipient;
  private String subject;
  private String content;

  @Override
  public void run() {
    this.mailSettings();
  }

  private void setParameters(String recipient, String subject, String content) {
    this.recipient = recipient;
    this.subject = subject;
    this.content = content;
  }

  private void mailSettings() {
    final String username = "hastanerandevu.iu";
    final String password = "hastanerandevu";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    });

    try {
      Message message = new MimeMessage(session);

      message.setFrom(new InternetAddress("hastanerandevu.iu@gmail.com"));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
      message.setSubject(subject);
      message.setSentDate(new Date());
      message.setContent(content, "text/html;charset=utf-8");
      Transport.send(message);

      LOG.info("Mail sent to \"" + recipient + "\", subject is: \"" + subject + "\"");
    } catch(Exception e) {
      LOG.error(e.getMessage());
    }
  }

  public void sendRegisterMail(PatientModel patientModel) {
    velocityEngine.setProperty("resource.loader", "file");
    velocityEngine.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init();

    velocityContext.put("userName", NameConverter.getName(patientModel.getFirstName(), patientModel.getLastName()));
    velocityContext.put("port", port);
    velocityContext.put("serverName", serverName);

    template = velocityEngine.getTemplate("com/hastanerandevu/template/registrationMail.vm", "UTF-8");
    template.merge(velocityContext, stringWriter);

    Mailer mailer = new Mailer();
    mailer.setParameters(patientModel.getEmail(), "e-Randevu Sistemi", stringWriter.toString());

    thread = new Thread(mailer);
    thread.start();
  }

  public void sendPasswordResetMail(String email) {
    try {
      PatientModel patientModel = patientService.getUserByEmail(email);
      String encryptedSalt = Encryptor.encrypt(ProjectConstants.SALT + patientModel.getEmail());

      velocityEngine.setProperty("resource.loader", "file");
      velocityEngine.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
      velocityEngine.init();

      velocityContext.put("userName", NameConverter.getName(patientModel.getFirstName(), patientModel.getLastName()));
      velocityContext.put("encryptedSalt", encryptedSalt);
      velocityContext.put("port", port);
      velocityContext.put("serverName", serverName);

      template = velocityEngine.getTemplate("com/hastanerandevu/template/passwordResetMail.vm", "UTF-8");
      template.merge(velocityContext, stringWriter);

      Mailer mailer = new Mailer();
      mailer.setParameters(patientModel.getEmail(), "e-Randevu Şifre Sıfırlama", stringWriter.toString());

      thread = new Thread(mailer);
      thread.start();
    } catch(NoUserException e) {
      LOG.warn(e.getMessage());
    }
  }

  public void sendAppointmentMail(AppointmentModel appointmentModel) {
    ResourceBundle bundle = ResourceBundle.getBundle("com.hastanerandevu.messages");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    velocityEngine.setProperty("resource.loader", "file");
    velocityEngine.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init();

    velocityContext.put("userName", NameConverter.getName(appointmentModel.getPatient().getFirstName(), appointmentModel.getPatient().getLastName()));
    velocityContext.put("hospital", appointmentModel.getInspectionPlace().getHospitalPoliclinicRel().getHospital().getHospitalName());
    velocityContext.put("policlinic", appointmentModel.getInspectionPlace().getHospitalPoliclinicRel().getPoliclinic().getPoliclinicName());
    velocityContext.put("inspectionPlace", appointmentModel.getInspectionPlace().getPlaceName());
    velocityContext.put("doctor", NameConverter.getName(appointmentModel.getInspectionPlace().getDoctor().getFirstName(), appointmentModel.getInspectionPlace().getDoctor().getLastName()));
    velocityContext.put("doctorLevel", bundle.getString("string." + appointmentModel.getInspectionPlace().getDoctor().getLevel()));
    velocityContext.put("appointmentDate", sdf.format(appointmentModel.getAppointmentDate()));
    if(appointmentModel.getMessageToDoctor() != null)
      velocityContext.put("message", appointmentModel.getMessageToDoctor());

    template = velocityEngine.getTemplate("com/hastanerandevu/template/appointmentMail.vm", "UTF-8");
    template.merge(velocityContext, stringWriter);

    Mailer mailer = new Mailer();
    mailer.setParameters(appointmentModel.getPatient().getEmail(), "e-Randevu Sistemi - Randevu", stringWriter.toString());

    thread = new Thread(mailer);
    thread.start();
  }
}
