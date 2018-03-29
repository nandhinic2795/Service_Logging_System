package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ServiceDetails extends AppCompatActivity {
   EditText MachineName,MachineModel,ServiceName,Charges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);
        MachineName=(EditText)findViewById(R.id.etsermachname);
        MachineModel=(EditText)findViewById(R.id.etsermachmodel);
        ServiceName=(EditText)findViewById(R.id.etservicename);
        Charges=(EditText)findViewById(R.id.etsercharges);
    }
    public void OnClickserAdd(View view){
        String str_MachineName =MachineName.getText().toString();
        String str_MachineModel =  MachineModel.getText().toString();
        String str_ServiceName = ServiceName.getText().toString();
        String str_Charges = Charges.getText().toString();

        String type = "SerInsert";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type, str_MachineName, str_MachineModel, str_ServiceName,str_Charges);
    }
    public void OnClickserView(View view){
        Intent intent = new Intent(ServiceDetails.this, SearchServiceDetails.class);
        startActivity(intent);

    }

    public void OnclickDelser(View view)
    {
        String str_MachineName =MachineName.getText().toString();
        String type = "ServiceDel";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type, str_MachineName );

    }
    public void OnClickserviceUp(View view){
        String str_MachineName =MachineName.getText().toString();
        String str_MachineModel =  MachineModel.getText().toString();
        String str_ServiceName = ServiceName.getText().toString();
        String str_Charges = Charges.getText().toString();

        String type = "ServiceUp";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type, str_MachineName, str_MachineModel, str_ServiceName,str_Charges);
    }

}
