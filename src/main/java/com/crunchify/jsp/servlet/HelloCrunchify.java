package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * @author Crunchify.com
 */
public class HelloCrunchify extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

            System.out.println("holaalalalallala");

            //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
            //Listando la informacion  
//            SendMail sender = new SendMail();
            SendNotification sender = new SendNotification();
        try {
            sender.send();
        } catch (Exception ex) {
            Logger.getLogger(HelloCrunchify.class.getName()).log(Level.SEVERE, null, ex);
        }

            //Redireccionando la informacion
            RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
            redireccion.forward(request, response);
        
    }

}
