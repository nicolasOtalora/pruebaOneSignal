package com.crunchify.jsp.servlet;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.BodyPart;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

    private String cod;
    private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";

    private static final String SMTP_AUTH_USER = System.getenv("");

    private static final String SMTP_AUTH_PWD  = System.getenv("");

    public SendMail() {
        this.cod = Integer.toString((int) Math.floor(Math.random() * (1000000 - 100000 + 1) + (100000)));

    }

    public static void send(String fromEmail, String toEmail, String subject, String htmlContent) throws Exception{

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", SMTP_HOST_NAME);

        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getDefaultInstance(props, auth);

        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);

        Multipart multipart = new MimeMultipart("alternative");

        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(htmlContent, "text/html");
        multipart.addBodyPart(bodyPart);

        message.setContent(multipart);

        message.setFrom(new InternetAddress(fromEmail));
        message.setSubject(subject);

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

 

        transport.connect(SMTP_AUTH_USER,SMTP_AUTH_PWD);

        transport.sendMessage(message,

        message.getRecipients(Message.RecipientType.TO));

        transport.close();

    }

 

    private static class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {

            String username = SMTP_AUTH_USER;

            String password = SMTP_AUTH_PWD;

            return new PasswordAuthentication(username, password);

        }

    }

    public String getCod() {

        return cod;

    }
}
