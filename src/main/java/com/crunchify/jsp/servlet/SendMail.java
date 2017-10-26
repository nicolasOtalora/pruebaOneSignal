package com.crunchify.jsp.servlet;

import java.util.*;

public class SendMail {

    public void sendMail(String toMail){
        Mailin http = new Mailin("https://api.sendinblue.com/v2.0", "dtaIps82j3VPSLAU", 5000);   //Optional parameter: Timeout in MS
        String str = http.get_account();
        System.out.println(str);
        
        Map < String, String > to = new HashMap < String, String > ();
			to.put(toMail, "to whom!");
		Map < String, String > cc = new HashMap < String, String > ();
			cc.put("appumartsw@gmail.com", "cc whom!");
		
		Map < String, String > headers = new HashMap < String, String > ();
			headers.put("Content-Type", "text/html; charset=iso-8859-1");
			headers.put("X-param1", "value1");
			headers.put("X-param2", "value2");
			headers.put("X-Mailin-custom", "my custom value");
			headers.put("X-Mailin-IP", "102.102.1.2");
			headers.put("X-Mailin-Tag", "My tag");

		Map < String, Object > data = new HashMap < String, Object > ();
			data.put("to", to);
			data.put("cc", cc);
			
			data.put("from", new String [] {"appumartsw@gmail.com","from email!"});
			data.put("subject", "Prueba de Heroku");
			data.put("html", "This is the <h1>HTML</h1>");
			data.put("text", "Esta prueba de enviar correo fue exitosa!!");
			data.put("attachment", new String [] {});
			data.put("headers", headers);
			data.put("inline_image", new String [] {});

    }
}
