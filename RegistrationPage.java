package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegistrationPage extends AppCompatActivity {
    EditText name,mobno,password;
    TextView loglink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        name=(EditText)findViewById(R.id.etregname);
        mobno=(EditText)findViewById(R.id.etregmobno);
        password=(EditText)findViewById(R.id.etregpass);

        loglink = (TextView) findViewById(R.id.etloglink);
        loglink.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(RegistrationPage.this, LoginPage.class);
                                           startActivity(intent);
                                       }
                                   }
        );

    }
    public void OnClickReg(View view)
    {
        String str_name=name.getText().toString();
        String str_mobno=mobno.getText().toString();
        String str_password=password.getText().toString();
        if(str_name.length()==0)
        {
            name.setError("Username is required!");
        }
        else if(str_mobno.length()==0) {
            mobno.setError("MobileNo is required!");
        }
        else if (!isValidPhone(str_mobno)) {
            Toast.makeText(getApplicationContext(), "Phone number is not valid, Enter 10 digit numbers", Toast.LENGTH_SHORT).show();

        }
        else if(str_password.length()==0)
        {
            password.setError("Password is required!");
        }
        else {
            String type = "register";
            BackGroundWorkerClass backgroundWorker = new BackGroundWorkerClass(this);
            backgroundWorker.execute(type, str_name, str_mobno, str_password);
        }


    }
//Phone number validation
    private boolean isValidPhone(String str_mobno) {
        boolean check=false;
        if(!Pattern.matches("[a-zA-Z]+",str_mobno)) {
            if (str_mobno.length()!=10) {
                check = false;

            } else {
                check = true;
            }
        }
        else{
            check=false;
        }
        return check;
    }
}

