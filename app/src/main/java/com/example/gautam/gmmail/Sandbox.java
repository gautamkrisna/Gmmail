package com.example.gautam.gmmail;


/**
 * Created by Gautam on 21-11-2017.
 *
 * sendMailMethod (String stringExchangeSrvr,   // "10.106.129.33";   //10.106.129.33/owa
 String stringEmailUser,  //"gautam@csblr.com";   //exchange mail box user.
 String stringEmailUserPass, //"freebsd";   // Password
 String stringEmailReceipient, // "gautam@csblr.com";  // Can be changed to other receipients.
 )
 *
 *
 *
 */

public class Sandbox {
    public static void main (String[] args){
        SendMail objSendMail = new SendMail();
        objSendMail.sendMailMethod("10.106.129.33",   //10.106.129.33/owa
        "gautam@csblr.com",   //exchange mail box user.
        "freebsd",   // Password
        "gautam@csblr.com",
                "Test Subject",
        "Body of the email ");  // Can be changed to other receipients.
    }
}
