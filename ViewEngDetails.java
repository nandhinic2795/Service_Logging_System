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

public class ViewEngDetails extends AppCompatActivity {
    TextView engviewresult;
    EditText Engid;
    Button engsearch;
    String number;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_eng_details);
        engsearch = (Button) findViewById(R.id.btnEngView);
        engviewresult = (TextView) findViewById(R.id.txtvieweng);
        Engid = (EditText) findViewById(R.id.etViewEngID);
        pd = new ProgressDialog(ViewEngDetails.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);


        engsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = Engid.getText().toString().trim();

                getSqlDetails();
            }
        });
    }
    private void getSqlDetails() {

        String url= "http://192.168.43.241/Service/EngViewdata.php?engid="+number;
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


                                String engid = jsonobject.getString("engid");
                                String engname = jsonobject.getString("engname").trim();
                                String engmobno = jsonobject.getString("engmobno").trim();
                                String engemail = jsonobject.getString("engemail").trim();
                                String engexp= jsonobject.getString("engexp").trim();
                                String engavai= jsonobject.getString("engavai").trim();

                                engviewresult.setText(" Engineer_ID -"+engid+"\n Engineer_Name-"+engname+"\n MobileNo -"+engmobno+"\n EmailID -"+engemail+" \n Experience -"+engexp+"\n Availability -"+engavai);

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
