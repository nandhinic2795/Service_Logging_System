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

public class SearchServiceDetails extends AppCompatActivity {
    TextView Result;
    EditText ServiceName;
    Button searchService;
    String number;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_service_details);
        searchService = (Button) findViewById(R.id.btnservsearch);
        Result = (TextView) findViewById(R.id.txtresultservicedetails);
        ServiceName = (EditText) findViewById(R.id.etsearchservicedetails);
        pd = new ProgressDialog(SearchServiceDetails.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);


        searchService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = ServiceName.getText().toString().trim();

                getSqlDetails();
            }
        });
    }
    private void getSqlDetails() {

        String url= "http://192.168.43.241/Service/SearchServiceData.php?ServiceName="+number;
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


                                String MachineName = jsonobject.getString("MachineName").trim();
                                String MachineModel = jsonobject.getString("MachineModel").trim();
                                String ServiceName = jsonobject.getString("ServiceName").trim();
                                String Charges = jsonobject.getString("Charges").trim();

                                Result.setText(" MachineName-"+MachineName+"\n MachineModel -"+MachineModel+"\n ServiceName -"+ServiceName+" \n Charges -"+Charges);

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
