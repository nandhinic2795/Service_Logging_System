package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class AddEngDetails extends AppCompatActivity {
    EditText engID,engname,engmobno,engemail,engexp,engavai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_eng_details);
        engID = (EditText) findViewById(R.id.etengID);
        engname = (EditText) findViewById(R.id.etengname);
        engmobno = (EditText) findViewById(R.id.etengmobno);
        engemail = (EditText) findViewById(R.id.etengmailid);
        engexp = (EditText) findViewById(R.id.etengexperience);
        engavai = (EditText) findViewById(R.id.etengAvailability);

    }
    public void OnClickEngDel(View view){
        String str_engID =engID.getText().toString();
        String type = "EngDel";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type, str_engID);

    }
    public void OnClickEngUp(View view){
        String str_engID =engID.getText().toString();
        String str_engname =  engname.getText().toString();
        String str_engmobno = engmobno.getText().toString();
        String str_engmail = engemail .getText().toString();
        String str_engexp = engexp.getText().toString();
        String str_engavai = engavai.getText().toString();
        String type = "EngUp";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type, str_engID, str_engname, str_engmobno,str_engmail,str_engexp,str_engavai);

    }
    public void OnClickEngView(View view){
        Intent intent = new Intent(AddEngDetails.this, ViewEngDetails.class);
        startActivity(intent);
    }
    public void OnClickEngIns(View view) {
        String str_engID =engID.getText().toString();
        String str_engname =  engname.getText().toString();
        String str_engmobno = engmobno.getText().toString();
        String str_engmail = engemail .getText().toString();
        String str_engexp = engexp.getText().toString();
        String str_engavai = engavai.getText().toString();
        if (str_engID.length() == 0) {
            engID.setError("EngineerID is required!");
        } else if (str_engname.length() == 0) {
            engname.setError("EngineerName is required!");
        } else if (str_engmobno.length() == 0) {
            engmobno.setError("MobileNo is required!");
        } else if (!isValidPhone(str_engmobno)) {
            Toast.makeText(getApplicationContext(), "Phone number is not valid, Enter 10 digit numbers", Toast.LENGTH_SHORT).show();

        } else if (str_engmail.length() == 0) {
            engemail.setError("EmailID is required!");
        } else if (str_engexp.length() == 0) {
            engexp.setError("Experience is required!");
        } else if (str_engavai.length() == 0) {
            engavai.setError("Please Enter availability!");
        } else {
            String type = "EngInsert";
            AdminBackground adminBackground = new AdminBackground(this);
            adminBackground.execute(type, str_engID, str_engname, str_engmobno,str_engmail,str_engexp,str_engavai);
        }
    }

    //Phone number validation
    private boolean isValidPhone(String str_engmobno) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", str_engmobno)) {
            if (str_engmobno.length() !=10) {
                check = false;

            } else {
                check = true;
            }
        } else {
            check = false;
        }
        return check;
    }


}
