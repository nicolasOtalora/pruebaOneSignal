package com.crunchify.jsp.servlet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

public class SendNotification {

    private String contents = "{ "
            + "\"app_id\"            : \"xxxxx\", "
            + "\"contents\"            : {\"en\" : \"Java test\"}, "
            + "\"isAndroid\"         : false, "
            + "\"url\"               : \"http://www.google.es\", "
            + "\"included_segments\" : [ \"All\" ] "
            + "}";
    private String url = "https://onesignal.com/";
    private String method = "POST";
    private String contentType = "application/json";

    public void send() throws Exception {

        URL u = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setRequestMethod(method);
        conn.setRequestProperty("Content-Type", contentType);
        conn.setRequestProperty("Content-Length", "" + contents.length());
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestProperty("Authorization", "Basic " + "xxxxx");

        OutputStream os = conn.getOutputStream();
        DataOutputStream wr = new DataOutputStream(os);
        wr.writeBytes(contents);
        wr.flush();
        wr.close();

        InputStream is = conn.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();

    }

}
