package com.example.prasan.serviceloggingsystem;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class ViewCustDetails extends AppCompatActivity {
    TextView result;
    EditText Custid;
    Button search;
    String number;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cust_details);
        search = (Button)findViewById(R.id.btnCsearch);
        result = (TextView)findViewById(R.id.txtviewres);
        Custid= (EditText)findViewById(R.id.etcustID);
        pd = new ProgressDialog(ViewCustDetails.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = Custid.getText().toString().trim();

                getSqlDetails();
            }
        });


    }


    private void getSqlDetails() {

        String url= "http://192.168.43.241/Service/Custdata.php?id="+number;
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


                                String id = jsonobject.getString("id");
                                String name = jsonobject.getString("Name").trim();
                                String mobno = jsonobject.getString("MobNo").trim();
                                String cmailid = jsonobject.getString("EmailID").trim();
                                String caddr= jsonobject.getString("Address").trim();

                                result.setText(" ID -"+id+"\n Name-"+name+"\n MobileNo -"+mobno+"\n EmailID -"+cmailid+" \n Address -"+caddr);

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



