package com.example.gautam.gmmail;

import android.os.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
                                  String sEmailReceipient, // "gautam@csblr.com";  // Can be changed to other receipients.
                                  String sEmailSubject,   //Subject of the email
                                  String sEmailBody)      // Body of the email

    {
        String strExchSrvr = sExchangeSrvr;   //10.106.129.33/owa
        final String strEmailUser = sEmailUser;   //"gautam@csblr.com";   //exchange mail box user.
        final String strEmailUserPass = sEmailUserPass;  //"freebsd";   // Password
        String strEmailReceipient = sEmailReceipient; // "gautam@csblr.com";  // Can be changed to other receipients.
        String strSubject = sEmailSubject;
        String strBody = sEmailBody;

        ////   Getting session object

        // Setting properties.
        Properties prop = new Properties();
        prop.put("mail.smtp.host",strExchSrvr);
        prop.put("mail.smtp.auth", "true");

        // Parameters received by the function
        System.out.println("\n Send mail - Method started, parameters received : " +strExchSrvr + strEmailReceipient + strSubject + strBody);

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
            message.setSubject( strSubject );

            //Getting time stamp
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
            String timeStamp = simpleDateFormat.format(new Date());
            message.setText("Message sent time : " + timeStamp + "\n" +strBody );

            //message.setText("Message sent time : \n" +strBody );


         //Sending email.
            Transport.send(message);
            return "True";
        } catch (MessagingException e) {e.printStackTrace(); return "False";}   //End of Compose

    } // End of main
} // End of class
