package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddMachineDetails extends AppCompatActivity {
    EditText Cust_ID,Mach_ID,Mach_Name,Mach_Model,Date,Rate,War_Start,War_End,AMC_Start,AMC_End;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_machine_details);

        Cust_ID=(EditText)findViewById(R.id.etmachcustid);
        Mach_ID=(EditText)findViewById(R.id.etmachid);
        Mach_Name=(EditText)findViewById(R.id.etmachname);
        Mach_Model=(EditText)findViewById(R.id.etmachmodel);
        Date=(EditText)findViewById(R.id.etmachdate);
        Rate=(EditText)findViewById(R.id.etmachrate);
        War_Start=(EditText)findViewById(R.id.etmachwars);
        War_End=(EditText)findViewById(R.id.etmachware);
        AMC_Start=(EditText)findViewById(R.id.etmachamcs);
        AMC_End=(EditText)findViewById(R.id.etmachamce);

    }
    public void OnClickMachIns(View view) {
        String str_Cust_ID =Cust_ID.getText().toString();
        String str_MachID =  Mach_ID.getText().toString();
        String str_MachName = Mach_Name.getText().toString();
        String str_MachModel = Mach_Model .getText().toString();
        String str_MachDate = Date.getText().toString();
        String str_MachRate = Rate.getText().toString();
        String str_WarS = War_Start.getText().toString();
        String str_WarE = War_End.getText().toString();
        String str_AMCS = AMC_Start.getText().toString();
        String str_AMCE= AMC_End.getText().toString();

        String type = "MachInsert";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type,str_Cust_ID,str_MachID,str_MachName,str_MachModel,str_MachDate,str_MachRate,str_WarS,str_WarE,str_AMCS,str_AMCE);

    }
    public void OnClicKMachView(View view)
    {
        Intent intent = new Intent(AddMachineDetails.this, ViewMachinedetails.class);
        startActivity(intent);
    }
    public void OnclickDelMach(View view)
    {
        String str_Cust_ID =Cust_ID.getText().toString();
        String type = "MachDel";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type, str_Cust_ID );

    }
    public void OnclickUpMach(View view)
    {
        String str_Cust_ID =Cust_ID.getText().toString();
        String str_MachID =  Mach_ID.getText().toString();
        String str_MachName = Mach_Name.getText().toString();
        String str_MachModel = Mach_Model .getText().toString();
        String str_MachDate = Date.getText().toString();
        String str_MachRate = Rate.getText().toString();
        String str_WarS = War_Start.getText().toString();
        String str_WarE = War_End.getText().toString();
        String str_AMCS = AMC_Start.getText().toString();
        String str_AMCE= AMC_End.getText().toString();

        String type = "MachUp";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type,str_Cust_ID,str_MachID,str_MachName,str_MachModel,str_MachDate,str_MachRate,str_WarS,str_WarE,str_AMCS,str_AMCE);

    }
}
