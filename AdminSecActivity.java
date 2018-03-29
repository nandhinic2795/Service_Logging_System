package com.example.prasan.serviceloggingsystem;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdminSecActivity extends AppCompatActivity {
    TextView txtviewcmp;
    EditText etnum;
    Button etcmp,btnsend;
    String number;
       EditText engno;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sec);
        engno=(EditText)findViewById(R.id.engphno);
        btnsend=(Button)findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=engno.getText().toString();
                String message=txtviewcmp.getText().toString();

                   SmsManager sms=SmsManager.getDefault();
                   sms.sendTextMessage(number,null,message,null,null);
                Toast.makeText(getApplicationContext(),"Send Successfully!",Toast.LENGTH_LONG).show();
               }


       });
        etcmp = (Button) findViewById(R.id.etcmp);
        txtviewcmp = (TextView) findViewById(R.id.txtviewcmp);
        txtviewcmp.setMovementMethod(new ScrollingMovementMethod());
        etnum = (EditText) findViewById(R.id.etnum);
        ImageView adminfor=(ImageView)findViewById(R.id.imgfwd);
        adminfor.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent intent = new Intent(AdminSecActivity.this, UpdateComplaintStatus.class);
                                              startActivity(intent);
                                          }
                                      }
        );
        pd = new ProgressDialog(AdminSecActivity.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);


        etcmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = etnum.getText().toString().trim();

                getSqlDetails();
            }
        });
    }


    private void getSqlDetails() {

        String url= "http://192.168.43.241/Service/ViewComplaintdata.php?Cmpnum="+number;
        pd.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        pd.hide();


                        try {

                            JSONArray jsonarray = new JSONArray(response);

                            for(int i=0; i < jsonarray.length(); i++) {

                                JSONObject jsonobject = jsonarray.getJSONObject(i);


                                String Cmpcustid = jsonobject.getString("Cmpcustid");
                                String machID = jsonobject.getString("machID");
                                String Cmptypeofcomp = jsonobject.getString("Cmptypeofcomp").trim();
                                String Cmpdesc= jsonobject.getString("Cmpdesc").trim();
                                String Cmpdate= jsonobject.getString("Cmpdate").trim();
                                String Cmpnum= jsonobject.getString("Cmpnum").trim();

                                txtviewcmp.setText("CustomerID-"+Cmpcustid+"\nMachineID-"+machID+"\nTypeOfComplaint-"+Cmptypeofcomp+"\nDescription-"+Cmpdesc+"\nCmpdate-"+Cmpdate+"\nComplaintNumber-"+Cmpnum);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();


                        }




                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(error != null){

                            Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                        }
                    }
                }

        );

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);


    }
}
