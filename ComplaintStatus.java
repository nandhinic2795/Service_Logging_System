package com.example.prasan.serviceloggingsystem;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class ComplaintStatus extends AppCompatActivity {
    EditText cno, cdate, status, comments;
Calendar mcurrentDate;
    int day,month,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_status);
        cno = (EditText) findViewById(R.id.etcno);
        cdate = (EditText) findViewById(R.id.etcdate);
        status = (EditText) findViewById(R.id.etstatus);
        comments = (EditText) findViewById(R.id.etcomments);
        mcurrentDate= Calendar.getInstance();
        day=mcurrentDate.get(Calendar.DAY_OF_MONTH);
        month=mcurrentDate.get(Calendar.MONTH);
        year=mcurrentDate.get(Calendar.YEAR);
        month=month+1;

        cdate.setText(year+"-"+checkdigit(month)+"-"+checkday(day));
        cdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(ComplaintStatus.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        cdate.setText(year+"-"+checkdigit(month)+"-"+checkday(dayOfMonth));
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }

    public void OnClickStatusIns(View view) {
        String str_cno = cno.getText().toString();
        String str_cdate = cdate.getText().toString();
        String str_status = status.getText().toString();
        String str_comments = comments.getText().toString();
        String type = "StatusInsert";
        AdminBackground adminBackground = new AdminBackground(this);
        adminBackground.execute(type, str_cno, str_cdate, str_status, str_comments);

    }
    public String checkdigit(int number) {
        return number<=9?"0"+number:String.valueOf(number);
    }
    public String checkday(int number) {
        return number<=9?"0"+number:String.valueOf(number);
    }
}
