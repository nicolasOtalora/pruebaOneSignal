package com.crunchify.jsp.servlet;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    private String cod;

    public SendMail() {
        this.cod = Integer.toString((int) Math.floor(Math.random() * (1000000 - 100000 + 1) + (100000)));

    }

    public void sendMail(String toAdd) {
        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.sendgrid.net");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "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");
            props.setProperty("mail.smtp.auth", "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");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("appumartsw@gmail.com"));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(toAdd));
            message.addHeader("Disposition-Notification-To", "appumartsw@gmail.com");
            message.setSubject("Verificación de cuenta");
            message.setText("Tu código: "+this.cod,"ISO-8859-1");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("appumartsw@gmail.com", "dondetusicompras");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCod() {

        return cod;

    }
}
