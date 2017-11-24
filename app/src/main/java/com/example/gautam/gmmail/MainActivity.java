package com.example.gautam.gmmail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bCompose, bInbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    // Initialising buttons :
    private void init() {
        // Initialising variable.
        bCompose = (Button)findViewById(R.id.btnCompose);   // Compose button.
        bInbox = (Button)findViewById(R.id.btnInbox);   //Inbox button.


        // setting listener.
        bCompose.setOnClickListener(this);
        bInbox.setOnClickListener(this);
    }

    // Click on button
    @Override
    public void onClick (View view) {
        switch ( view.getId()) {
            case R.id.btnCompose:
                System.out.println("Compose button is clicked");
                startActivity(new Intent(this, composeActivity.class ));
                break;
            case R.id.btnInbox:
                System.out.println("Inbox button is clicked");
                startActivity ( new Intent(this, Inbox.class));
                break;
        }
    }
}
