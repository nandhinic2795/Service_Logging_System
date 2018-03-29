package com.example.prasan.serviceloggingsystem;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewMachinedetails extends AppCompatActivity {
    TextView Checkmachresult;
    EditText MachCustid;
    Button searchmachinedetails;
    String number;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_machinedetails);
        searchmachinedetails = (Button)findViewById(R.id.btncheckmach);
        Checkmachresult = (TextView)findViewById(R.id.txtresmach);
        MachCustid= (EditText)findViewById(R.id.etmachcustid);
        pd = new ProgressDialog(ViewMachinedetails.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);



        searchmachinedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = MachCustid.getText().toString().trim();

                getSqlDetails();
            }
        });
    }


    private void getSqlDetails() {

        String url = "http://192.168.43.241/Service/CheckMachineDetails.php?Cust_ID=" + number;
        pd.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        pd.hide();


                        try {

                            JSONArray jsonarray = new JSONArray(response);

                            for (int i = 0; i < jsonarray.length(); i++) {

                                JSONObject jsonobject = jsonarray.getJSONObject(i);


                                String custid = jsonobject.getString("Cust_ID");
                                String machid = jsonobject.getString("Mach_ID").trim();
                                String machname = jsonobject.getString("Mach_Name").trim();
                                String machmodel = jsonobject.getString("Mach_Model").trim();
                                String date = jsonobject.getString("Date").trim();
                                String rate = jsonobject.getString("Rate").trim();
                                String warstart = jsonobject.getString("War_Start").trim();
                                String warend = jsonobject.getString("War_End").trim();
                                String amcstart = jsonobject.getString("AMC_Start").trim();
                                String amcend = jsonobject.getString("AMC_End").trim();

                                Checkmachresult.setText(" CustomerID -" + custid + "\n MachineID-" + machid + "\n MachineName -" + machname + "\n MachineModel -" + machmodel + " \n Date -" + date+ "\n Rate -" + rate + "\n WarrantyStartDate -" + warstart+ "\n WarrantyEndDate -" +warend+ "\n AMCStartDate -" +amcstart+"\n AMCEndDate -" +amcend);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();


                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error != null) {

                            Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                        }
                    }
                }

        );

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
    }
