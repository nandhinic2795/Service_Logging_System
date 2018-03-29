package com.example.prasan.serviceloggingsystem;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class ComplaintsPage extends AppCompatActivity {
 EditText disp,cmpcustid,machID,cmpdesc,compdate;
    Calendar mcurrentDate;
    int day,month,year;
    Spinner typeofcomp;

    long i=800;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints_page);
         disp=(EditText)findViewById(R.id.etcomplaintnumber);
        cmpcustid=(EditText)findViewById(R.id.compcustid);
        machID=(EditText)findViewById(R.id.compcustname);
        cmpdesc=(EditText)findViewById(R.id.compdesc);
        compdate=(EditText)findViewById(R.id.compdate);
        mcurrentDate=Calendar.getInstance();
        day=mcurrentDate.get(Calendar.DAY_OF_MONTH);
        month=mcurrentDate.get(Calendar.MONTH);
        year=mcurrentDate.get(Calendar.YEAR);
        month=month+1;
        compdate.setText(year+"-"+checkdigit(month)+"-"+checkday(day));
        compdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(ComplaintsPage.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        compdate.setText(year+"-"+checkdigit(month)+"-"+checkday(dayOfMonth));
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        typeofcomp=(Spinner)findViewById(R.id.Typeofcomp);
        List<String> list=new ArrayList<>();
        list.add("General");
        list.add("Poor Status");
        list.add("Simple");
        list.add("Problem");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeofcomp.setAdapter(adapter);
        typeofcomp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue=parent.getItemAtPosition(position).toString();
                Toast.makeText(ComplaintsPage.this, "Selected:"+itemvalue,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public String checkdigit(int number) {
return number<=9?"0"+number:String.valueOf(number);
    }
    public String checkday(int number) {
        return number<=9?"0"+number:String.valueOf(number);
    }
    public void complaintnum(View view){

        i=i+1;
        display(i);
    }
    private void display(long n){

        disp.setText(String.valueOf(n));
    }
public void complaintreg(View view)
{
    String str_cmpcustID =cmpcustid.getText().toString();
    String str_machID =  machID.getText().toString();
    String str_typeofcomp = typeofcomp.getSelectedItem().toString();
    String str_cmpdesc = cmpdesc.getText().toString();
    String str_cmpdate = compdate.getText().toString();
    String str_cmpnum = disp.getText().toString();
    String type = "ComplaintReg";
    AdminBackground adminBackground = new AdminBackground(this);
    adminBackground.execute(type,str_cmpcustID,str_machID,str_typeofcomp,str_cmpdesc,str_cmpdate,str_cmpnum);

}

}
