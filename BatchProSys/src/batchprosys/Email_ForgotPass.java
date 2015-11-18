/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchprosys;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author prathibha
 */
public class Email_ForgotPass {
    
    Email_ForgotPass(String email,String Username,String Password,String userid){
        final String user ="sathyajith4you@gmail.com";
        final String pass ="Prathibha5840";
   
   
       Properties prop=new Properties();
       
       prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
       prop.put("mail.smtp.auth",true);
       prop.put("mail.smtp.starttls.enable",true);
       prop.put("mail.smtp.host","smtp.gmail.com");
       prop.put("mail.smtp.port","587");
       
       Session session =Session.getInstance(prop, new javax.mail.Authenticator() 
       {
          
          protected javax.mail.PasswordAuthentication getPasswordAuthentication()
           {
               return new javax.mail.PasswordAuthentication(user, pass);
           }
       });
       
       try{
           Message message =new MimeMessage(session);
           message.setFrom(new InternetAddress("sathyajith4you@gmail.com"));
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
           message.setSubject("Variosysetms-Login");
           String htmlText = "<H3>VarioSystems(Pvt)Ltd.</H3><h4>Mr."+ Username+"</h4>Here is the login details of your account of Variosystems(Pvt)Ltd.<br> "+"<h4>User_ID: "+userid+"</h4>"+"<h4>Password: "+Password+"</h4>Admin.<br>Batch Production System.<br>VasioSystems(Pvt)Ltd.";
           message.setContent(htmlText, "text/html");
           Transport.send(message);
           
           System.out.println("message sent");
           
       }catch(Exception e){
           System.out.println(e); 
       }
    
    
    }
}
