package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ComplaintRegister extends AppCompatActivity {
       EditText ChkMachID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_register);
        ChkMachID=(EditText)findViewById(R.id.ChkMachID);

    }
    public void OnclickAMCWAR(View view)
    {
        String str_ChkMachID =ChkMachID.getText().toString();
        String type = "ChkAMCWar";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type, str_ChkMachID);

    }
}