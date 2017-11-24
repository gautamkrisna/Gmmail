package com.example.gautam.gmmail;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class composeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bSendMail;
    public static String retVal;
    public static String strReceipient, strSubject,strBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String strEmailReceipient,strEmailSubject, strEmailBody;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        // set on click listener
        bSendMail = (Button)findViewById(R.id.btnSend);
        bSendMail.setOnClickListener(this);
    }

    //Click on send
    @Override
    public void onClick(View view) {
        System.out.println("Clicked on the Send button : " + view.getId());
        //Getting email field Details :
        EditText edtReceipient = (EditText) findViewById(R.id.edtEmailReceipient);
        strReceipient = edtReceipient.getText().toString();
        System.out.println( "\n email Receipient : " +strReceipient);
        strSubject = ((EditText) findViewById(R.id.edtEmailSubj)).getText().toString();
        System.out.println( "\n email Subject : " +strSubject);
        strBody = ((EditText) findViewById(R.id.edtEmailBody)).getText().toString();
        System.out.println( "\n email Body : " +strBody);

        // Calling email method via async class.
        System.out.print("\n calling Sync class");
        retSendMailAsync objAsyncTsk = new retSendMailAsync ();
        objAsyncTsk.execute();
    }

    // Async task to send the email.
    public class retSendMailAsync extends AsyncTask < String, Integer, String > {
        @Override
        protected String doInBackground (String... strings) {
            System.out.println("\n Inside Async task ");
            System.out.println("\n parameters passed into Async task : " +strReceipient+strSubject+strBody);
            SendMail sendMail = new SendMail();  // Send mail object

            composeActivity.retVal = sendMail.sendMailMethod ("10.106.129.33",   //10.106.129.33/owa
                    "gautam@csblr.com",   //exchange mail box user.
                    "freebsd",   // Password
                    composeActivity.strReceipient,
                    composeActivity.strSubject,
                    composeActivity.strBody);
            return composeActivity.retVal;
        }
    }
}
