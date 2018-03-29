package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


public class CustomerDetails extends AppCompatActivity {

    EditText CID, CName, CMobno, CMail, CAddr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        CID = (EditText) findViewById(R.id.etadCID);
        CName = (EditText) findViewById(R.id.etadCname);
        CMobno = (EditText) findViewById(R.id.etadCpno);
        CMail = (EditText) findViewById(R.id.etadCmail);
        CAddr = (EditText) findViewById(R.id.etadCadr);
    }
    public void OnClickView(View view){
        Intent intent = new Intent(CustomerDetails.this, ViewCustDetails.class);
        startActivity(intent);
    }
    public void OnClickUpdate(View view) {
        String str_CID = CID.getText().toString();
        String str_Cname = CName.getText().toString();
        String str_Cmobno = CMobno.getText().toString();
        String str_Cmail = CMail.getText().toString();
        String str_Caddr = CAddr.getText().toString();
            String type = "CUpdate";
            AdminBackground adminBackground = new AdminBackground(this);
            adminBackground.execute(type, str_CID, str_Cname, str_Cmobno, str_Cmail, str_Caddr);

    }

    public void OnClickCIns(View view) {
        String str_CID = CID.getText().toString();
        String str_Cname = CName.getText().toString();
        String str_Cmobno = CMobno.getText().toString();
        String str_Cmail = CMail.getText().toString();
        String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String str_Caddr = CAddr.getText().toString();
        if (str_CID.length() == 0) {
            CID.setError("UserID is required!");
        } else if (str_Cname.length() == 0) {
            CName.setError("UserName is required!");
        } else if (str_Cmobno.length() == 0) {
            CMobno.setError("MobileNo is required!");
        } else if (!isValidPhone(str_Cmobno)) {
            Toast.makeText(getApplicationContext(), "Phone number is not valid", Toast.LENGTH_SHORT).show();

        } else if (str_Cmail.length() == 0) {
            CMail.setError("EmailID is required!");
        }
        else if (!str_Cmail.matches(emailpattern))
        {
                Toast.makeText(getApplicationContext(), "Invalid Email Address", Toast.LENGTH_LONG).show();
        }
        else if (str_Caddr.length() == 0) {
            CAddr.setError("Address is required!");
        } else {
            String type = "CInsert";
            AdminBackground adminBackground = new AdminBackground(this);
            adminBackground.execute(type, str_CID, str_Cname, str_Cmobno, str_Cmail, str_Caddr);
        }
    }
    public void OnClickDel(View view){
        String str_CID = CID.getText().toString();
        String type = "CDelete";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type, str_CID);
    }

    //Phone number validation
    private boolean isValidPhone(String str_mobno) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", str_mobno)) {
            if (str_mobno.length() < 6 || str_mobno.length() > 13) {
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
