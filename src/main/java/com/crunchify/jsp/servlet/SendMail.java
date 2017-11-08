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
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "appumartsw@gmail.com");
            props.setProperty("mail.smtp.auth", "true");
            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            // la persona k tiene k verificar
            message.setFrom(new InternetAddress("appumartsw@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAdd));
            message.addHeader("Disposition-Notification-To", "appumartsw@gmail.com");
            message.setSubject("Correo de verificacion, porfavor no responder");
            message.setText(
                    " <img src='https://kingmathew.000webhostapp.com/images/titulo1.png' alt='Not-Found'> \n"
                    + "<br> \n"
                    + " Este es un correo de verificacion \n"
                    + "Gracias por registrarse en LibrarySoft \n"
                    + "Porfavor haga click en el siguiente enlace\n"
                    + "para verificar su cuenta \n"
                    + "<br> \n"
                    + "'>Enlace de verificación</a>  ", "ISO-8859-1", "html");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("appumartsw@gmail.com", "dondetusicompras");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCod() {

        return cod;

    }
}
