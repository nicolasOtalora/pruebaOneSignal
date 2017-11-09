/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;
import java.util.Properties;

 

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

public class MailUtil {

    private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";

    private static final String SMTP_AUTH_USER = System.getenv("SENDGRID_USERNAME");

    private static final String SMTP_AUTH_PWD  = System.getenv("SENDGRID_PASSWORD");

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

 

        transport.connect();

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

}

