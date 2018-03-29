package com.example.prasan.serviceloggingsystem;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

public class UpdateComplaintStatus extends AppCompatActivity {
    TextView resultviewstatus;
    EditText viewcomplaint;
    Button searchstatus;
    String number;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_complaint_status);
        searchstatus = (Button)findViewById(R.id.btnupcomplaintstatus);
        resultviewstatus = (TextView)findViewById(R.id.txtcustupdatestatus);
        viewcomplaint= (EditText)findViewById(R.id.etupdatecomplstatus);
        TextView marquee=(TextView)findViewById(R.id.txtmarquee);
        marquee.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        marquee.setSelected(true);
        marquee.setSingleLine();
        pd = new ProgressDialog(UpdateComplaintStatus.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);



        searchstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = viewcomplaint.getText().toString().trim();

                getSqlDetails();
            }
        });

    }

    private void getSqlDetails() {

        String url= "http://192.168.43.241/Service/ViewStatus.php?cno="+number;
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


                                String complaintnumber= jsonobject.getString("cno");
                                String complaintdate = jsonobject.getString("cdate").trim();
                                String complaintstatus = jsonobject.getString("status").trim();
                                String complaintcomments = jsonobject.getString("comments").trim();


                                resultviewstatus.setText(" ComplaintNumber -"+complaintnumber+"\n ComplaintDate-"+complaintdate+"\n ComplaintStatus -"+complaintstatus+"\n ComplaintComments -"+complaintcomments);

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
