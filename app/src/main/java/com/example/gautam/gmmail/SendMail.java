package com.example.gautam.gmmail;

import android.os.*;

import java.util.Properties;
import java.time.*;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.Session.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Created by Gautam on 21-11-2017.
 */

public class SendMail {
    public String sendMailMethod (String sExchangeSrvr,   // "10.106.129.33";   //10.106.129.33/owa
                                  String sEmailUser,  //"gautam@csblr.com";   //exchange mail box user.
                                  String sEmailUserPass, //"freebsd";   // Password
                                  String sEmailReceipient) // "gautam@csblr.com";  // Can be changed to other receipients.

    {
        String strExchSrvr = sExchangeSrvr;   //10.106.129.33/owa
        final String strEmailUser = sEmailUser;   //"gautam@csblr.com";   //exchange mail box user.
        final String strEmailUserPass = sEmailUserPass;  //"freebsd";   // Password
        String strEmailReceipient = sEmailReceipient; // "gautam@csblr.com";  // Can be changed to other receipients.

        ////   Getting session object

        // Setting properties.
        Properties prop = new Properties();
        prop.put("mail.smtp.host",strExchSrvr);
        prop.put("mail.smtp.auth", "true");

        //Creating session object


        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator(){
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(strEmailUser,strEmailUserPass);
                        }
                    });
        System.out.println("\n Session ID : " + session);

        // Composting an email
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(strEmailUser));  // Setting sender email address.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress( strEmailReceipient)); // Setting receipient
            message.setSubject("Subject : " + java.time.LocalDateTime.now());
            message.setText("Body of the email " );

         //Sending email.
            Transport.send(message);
            return "True";
        } catch (MessagingException e) {e.printStackTrace(); return "False";}   //End of Compose

    } // End of main
} // End of class
