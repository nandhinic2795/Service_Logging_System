package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {
    Button btncstdet,btnadeng,btnadmach,btnadserv;
    ImageView adimgvwfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        btncstdet = (Button) findViewById(R.id.btnadcust);
        btnadmach = (Button) findViewById(R.id.btnadmach);
        btnadserv = (Button) findViewById(R.id.btnadserdetails);
        adimgvwfor=(ImageView)findViewById(R.id.adimgvwfor);
        btncstdet.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(AdminActivity.this, CustomerDetails.class);
                                           startActivity(intent);
                                       }
                                   }
        );

        btnadmach.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(AdminActivity.this, AddMachineDetails.class);
                                            startActivity(intent);
                                        }
                                    }
        );
        btnadeng=(Button)findViewById(R.id.btnadengineers);
        btnadeng.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(AdminActivity.this, AddEngDetails.class);
                                            startActivity(intent);
                                        }
                                    }
        );

        adimgvwfor.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent intent = new Intent(AdminActivity.this, AdminSecActivity.class);
                                             startActivity(intent);
                                         }
                                     }
        );
        btnadserv.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent intent = new Intent(AdminActivity.this, ServiceDetails.class);
                                             startActivity(intent);
                                         }
                                     }
        );
        TextView Adminlogout = (TextView) findViewById(R.id.txtadminlogout);
        Adminlogout.setPaintFlags(Adminlogout.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        Adminlogout.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i=new Intent(AdminActivity.this,LoginPage.class);
                                              i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                              startActivity(i);
                                              finish();
                                          }
                                      }
        );


    }

}
