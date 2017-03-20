package com.hastanerandevu.utility;

import com.hastanerandevu.converter.PasswordEncryptor;
import com.hastanerandevu.dao.PatientDaoImpl;
import com.hastanerandevu.model.PatientModel;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Mailer implements Runnable {
  private PatientDaoImpl patientDao = new PatientDaoImpl();
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

      System.out.println("Mail sent.");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void sendRegisterMail(PatientModel patientModel) {
    Mailer mailer = new Mailer();
    mailer.setParameters(patientModel.getEmail(), "Hastane Randevu Sistemi", "<div>Merhaba <h1>" + patientModel.getFirstName() + ",</h1>\n\nHastane Randevu Sistemi'ndeki kullanıcı hesabın oluşturulmuştur.</div>");

    Thread thread = new Thread(mailer);
    thread.start();
  }

  public void sendPasswordResetMail(PatientModel patientModel) {
    this.patientModel = patientDao.getUserByEmail(patientModel);
    String salt          = "498#2D83B631%3800EBD!801600D*7E3CC13";
    String encryptedSalt = PasswordEncryptor.encryptPassword(salt + this.patientModel.getEmail());

    Mailer mailer = new Mailer();
    mailer.setParameters(this.patientModel.getEmail(), "Hastane Randevu Sistemi Şifre Sıfırlama", "<div>Merhaba <h1>" + this.patientModel.getFirstName() + ",</h1>\n\n<a href='http://localhost:8080/forgot?q=" + encryptedSalt + "'>Şifre sıfırlama bağlantınız</a></div>");

    Thread thread = new Thread(mailer);
    thread.start();
  }
}
