package com.hastanerandevu.utility;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.exceptions.NoUserException;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import org.apache.log4j.Logger;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
    Mailer mailer = new Mailer();
    String MAIL_TEMPLATE = "<div width=\"100%\" style=\"background: #f8f8f8; padding: 0px 0px; font-family:arial; line-height:28px; height:100%;  width: 100%; color: #514d6a;\">\n" +
      "  <div style=\"max-width: 700px; padding:50px 0;  margin: 0px auto; font-size: 14px\">\n" +
      "    <div style=\"padding: 40px; background: #fff;\">\n" +
      "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%;\">\n" +
      "        <tbody>\n" +
      "          <tr>\n" +
      "            <td style=\"border-bottom:1px solid #f6f6f6;\"><h1 style=\"font-size:14px; font-family:arial; margin:0px; font-weight:bold;\">Sayın " + patientModel.getFirstName() + " " + patientModel.getLastName() + ",</h1></td>\n" +
      "          </tr>\n" +
      "          <tr>\n" +
      "            <td style=\"padding:10px 0 30px 0;\"><p>e-Randevu Sistemi'ndeki kullanıcı hesabın oluşturulmuştur. Aşağıdaki linkten hesabına giriş yapabilirsin.</p>\n" +
      "              <center>\n" +
      "                <a href='http://localhost:8080/login/patient' style=\"display: inline-block; padding: 11px 30px; margin: 20px 0px 30px; font-size: 15px; color: #fff; background: #00c0c8; border-radius: 60px; text-decoration:none;\">Hesabına Git</a>\n" +
      "              </center>\n" +
      "              <b>- Teşekkürler (e-Randevu Sistemi)</b> </td>\n" +
      "          </tr>\n" +
      "          <tr>\n" +
      "            <td  style=\"border-top:1px solid #f6f6f6; padding-top:20px; color:#777\">Eğer bu e-mail'in yanlışlıkla gelmiş olabileceğini düşünüyorsan görmezden gelebilir ya da bize bildirebilirsin.</td>\n" +
      "          </tr>\n" +
      "        </tbody>\n" +
      "      </table>\n" +
      "    </div>\n" +
      "  </div>";
    mailer.setParameters(patientModel.getEmail(), "e-Randevu Sistemi", MAIL_TEMPLATE);

    Thread thread = new Thread(mailer);
    thread.start();
  }

  public void sendPasswordResetMail(String email) {
    try {
      patientModel = patientService.getUserByEmail(email);

      String encryptedSalt = Encryptor.encryptEmail(ProjectConstants.SALT + patientModel.getEmail());
      String MAIL_TEMPLATE = "<div width=\"100%\" style=\"background: #f8f8f8; padding: 0px 0px; font-family:arial; line-height:28px; height:100%;  width: 100%; color: #514d6a;\">\n" +
        "  <div style=\"max-width: 700px; padding:50px 0;  margin: 0px auto; font-size: 14px\">\n" +
        "    <div style=\"padding: 40px; background: #fff;\">\n" +
        "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%;\">\n" +
        "        <tbody>\n" +
        "          <tr>\n" +
        "            <td style=\"border-bottom:1px solid #f6f6f6;\"><h1 style=\"font-size:14px; font-family:arial; margin:0px; font-weight:bold;\">Sayın " + patientModel.getFirstName() + " " + patientModel.getLastName() + ",</h1>\n" +
        "              <p style=\"margin-top:0px; color:#bbbbbb;\">Şifre sıfırlamada kullanacağınız link aşağıdadır.</p></td>\n" +
        "          </tr>\n" +
        "          <tr>\n" +
        "            <td style=\"padding:10px 0 30px 0;\"><p>Talebin üzerine gönderilen şifre sıfırlama linkine tıklayarak yeni şifreni oluşturabilirsin.</p>\n" +
        "              <center>\n" +
        "                <a href='http://localhost:8080/recovery/reset?q=" + encryptedSalt + "' style=\"display: inline-block; padding: 11px 30px; margin: 20px 0px 30px; font-size: 15px; color: #fff; background: #00c0c8; border-radius: 60px; text-decoration:none;\">Şifre Sıfırlama Bağlantısı</a>\n" +
        "              </center>\n" +
        "              <b>- Teşekkürler (e-Randevu Sistemi)</b> </td>\n" +
        "          </tr>\n" +
        "          <tr>\n" +
        "            <td  style=\"border-top:1px solid #f6f6f6; padding-top:20px; color:#777\">Eğer bu e-mail'in yanlışlıkla gelmiş olabileceğini düşünüyorsan görmezden gelebilir ya da bize bildirebilirsin.</td>\n" +
        "          </tr>\n" +
        "        </tbody>\n" +
        "      </table>\n" +
        "    </div>\n" +
        "  </div>";

      Mailer mailer = new Mailer();
      mailer.setParameters(patientModel.getEmail(), "e-Randevu Şifre Sıfırlama", MAIL_TEMPLATE);

      Thread thread = new Thread(mailer);
      thread.start();
    } catch(NoUserException e) {
      LOG.warn(e.getMessage());
    }
  }
}
