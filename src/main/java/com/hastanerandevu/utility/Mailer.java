package com.hastanerandevu.utility;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.converter.NameConverter;
import com.hastanerandevu.exceptions.NoUserException;
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
import java.util.Date;
import java.util.Properties;

public class Mailer implements Runnable {

  private static final Logger LOG = Logger.getLogger(Mailer.class);

  private PatientServiceImpl patientService = new PatientServiceImpl();
  private PatientModel patientModel = new PatientModel();
  private String to;
  private String subject;
  private String content;

  @Override
  public void run() {
    this.mailSettings();
  }

  private void setParameters(String to, String subject, String content) {
    this.to = to;
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
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
      message.setSubject(subject);
      message.setSentDate(new Date());
      message.setContent(content, "text/html;charset=utf-8");
      Transport.send(message);

      LOG.info("Mail sent");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void sendRegisterMail(PatientModel patientModel) {
    VelocityEngine ve = new VelocityEngine();
    VelocityContext context = new VelocityContext();

    ve.setProperty("resource.loader", "file");
    ve.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

    ve.init();

    context.put("userName", NameConverter.getName(patientModel.getFirstName(),patientModel.getLastName()));

    Template t = ve.getTemplate("com/hastanerandevu/template/registrationMail.vm","UTF-8");

    StringWriter stringWriter = new StringWriter();

    t.merge(context,stringWriter);

    Mailer mailer = new Mailer();
    mailer.setParameters(patientModel.getEmail(), "e-Randevu Sistemi", stringWriter.toString());

    Thread thread = new Thread(mailer);
    thread.start();
  }

  public void sendPasswordResetMail(String email) {
    try {
      patientModel = patientService.getUserByEmail(email);

      String encryptedSalt = Encryptor.encryptEmail(ProjectConstants.SALT + patientModel.getEmail());

      VelocityEngine ve = new VelocityEngine();
      VelocityContext context = new VelocityContext();

      ve.setProperty("resource.loader", "file");
      ve.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

      ve.init();

      context.put("userName", NameConverter.getName(patientModel.getFirstName(),patientModel.getLastName()));
      context.put("encryptedSalt",encryptedSalt);

      Template t = ve.getTemplate("com/hastanerandevu/template/passwordResetMail.vm","UTF-8");

      StringWriter stringWriter = new StringWriter();

      t.merge(context,stringWriter);


      Mailer mailer = new Mailer();
      mailer.setParameters(patientModel.getEmail(), "e-Randevu Şifre Sıfırlama", stringWriter.toString());

      Thread thread = new Thread(mailer);
      thread.start();
    } catch(NoUserException e) {
      LOG.warn(e.getMessage());
    }
  }
}
