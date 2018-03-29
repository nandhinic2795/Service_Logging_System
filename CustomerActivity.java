package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class CustomerActivity extends AppCompatActivity {
 Button btnvcust,btnMachineCheck;
    ImageButton mkcomp;
    ImageButton viewstatusinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        btnvcust = (Button) findViewById(R.id.btnviewcust);
        btnMachineCheck = (Button) findViewById(R.id.btnCheckMachdetails);
        mkcomp=(ImageButton)findViewById(R.id.btnmakecom);
        viewstatusinfo=(ImageButton)findViewById(R.id.imgstatus);
        btnvcust.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(CustomerActivity.this, ViewCustDetails.class);
                                           startActivity(intent);
                                       }
                                   }
        );

        btnMachineCheck.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(CustomerActivity.this, ViewMachinedetails.class);
                                            startActivity(intent);
                                        }
                                    }
        );
          mkcomp.setOnClickListener(new View.OnClickListener(){

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(CustomerActivity.this, ComplaintRegister.class);
        startActivity(intent);

    }
});
        viewstatusinfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerActivity.this, UpdateComplaintStatus.class);
                startActivity(intent);

            }
        });
       TextView Custlogout = (TextView) findViewById(R.id.txtcustlogout);
        Custlogout.setPaintFlags(Custlogout.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        Custlogout.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i=new Intent(CustomerActivity.this,LoginPage.class);
                                           i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                           startActivity(i);
                                           finish();
                                       }
                                   }
        );


    }

}
