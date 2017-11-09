/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

/**
 *
 * @author Nicolas
 */
public class test {
    public static void main(String[] args) throws Exception {
        MailUtil sender = new MailUtil();
        
        sender.send("appumartsw@gmail.com","nicolas.otalora@correo.usa.edu.co","prueba de correo","<h1>su madre</h1>");
    }
    
}
