package com.hastanerandevu.utility;

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
  private String to;
  private String subject = "Hastane Randevu Sistemi";
  private String message;

  @Override
  public void run() {
    this.mailSettings();
  }

  private void setParameters(String to, String subject, String message) {
    this.to = to;
    this.subject = subject;
    this.message = message;
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
      Message mailMessage = new MimeMessage(session);

      mailMessage.setFrom(new InternetAddress("hastanerandevu.iu@gmail.com"));
      mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
      mailMessage.setSubject(subject);
      mailMessage.setSentDate(new Date());
      mailMessage.setText(message);
      Transport.send(mailMessage);

      System.out.println("Mail sent.");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void sendMail(PatientModel patientModel) {
    Mailer mailer = new Mailer();
    mailer.setParameters(patientModel.getEmail(), subject, "Merhaba " + patientModel.getFirstName() + ",\n\nHastane Randevu Sistemi'ndeki kullanıcı hesabın oluşturulmuştur.");
    Thread thread = new Thread(mailer);
    thread.start();
  }
}
