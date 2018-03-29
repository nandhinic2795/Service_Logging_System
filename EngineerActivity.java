package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EngineerActivity extends AppCompatActivity {
Button btnadeng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineer);

        TextView Englogout = (TextView) findViewById(R.id.txtenglogout);
        Englogout.setPaintFlags(Englogout.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        Englogout.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i=new Intent(EngineerActivity.this,LoginPage.class);
                                              i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                              startActivity(i);
                                                                                 finish();
                                          }
                                      }
        );

    }
    public void updatestat(View view)
    {
        Intent intent=new Intent(EngineerActivity.this,ComplaintStatus.class);
        startActivity(intent);
    }
}
