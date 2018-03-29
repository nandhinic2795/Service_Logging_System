package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
           TextView Reglink;
    EditText lnUsername, lnPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Reglink = (TextView) findViewById(R.id.etlink);
        Reglink.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(LoginPage.this, RegistrationPage.class);
                                           startActivity(intent);
                                       }
                                   }
        );

        lnUsername = (EditText) findViewById(R.id.etlogUserName);
        lnUsername.setSelection(0);
        lnPassword = (EditText) findViewById(R.id.etlogPassword);

    }
        public void OnClickLogin(View view){
            String username=lnUsername.getText().toString();
            String password=lnPassword.getText().toString();
            if(username.length()==0)
            {
                lnUsername.setError("Username/MobileNo is required!");
            }
           else if(password.length()==0)
            {
                lnPassword.setError("Password is required!");
            }
            else {

                String type = "login";
                BackGroundWorkerClass backgroundWorker = new BackGroundWorkerClass(this);
                backgroundWorker.execute(type, username, password);
            }
        }




}
