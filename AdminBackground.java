package com.example.prasan.serviceloggingsystem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Prasan on 20-02-2018.
 */

public class AdminBackground extends AsyncTask<String,Void,String> {
        Context context;
        AlertDialog alertDialog;
        AdminBackground(Context ctx) {
            context = ctx;
        }
    @Override

    protected String doInBackground(String... params) {
        String type = params[0];
        String AddStatus_URL = "http://192.168.43.241/Service/AddStatus.php";
        String MDelete_URL = "http://192.168.43.241/Service/DeleteMachData.php";
        String MUpdate_URL = "http://192.168.43.241/Service/UpMachData.php";
        String Serviceinsert_URL="http://192.168.43.241/Service/AddServiceDetails.php";
        String ServiceDel_URL="http://192.168.43.241/Service/DelServiceDetails.php";
        String ServiceUp_URL="http://192.168.43.241/Service/UpServiceDetails.php";
        String insert_URL = "http://192.168.43.241/Service/CustomerTab.php";
        String CDelete_URL = "http://192.168.43.241/Service/DeleteCustData.php";
        String CUpdate_URL = "http://192.168.43.241/Service/UpdateCustomerData.php";
        String Enginsert_URL = "http://192.168.43.241/Service/AddEngDetails.php";
        String EDelete_URL = "http://192.168.43.241/Service/DeleteEngData.php";
        String EUpdate_URL = "http://192.168.43.241/Service/UpdateEngData.php";
        String Machinsert_URL = "http://192.168.43.241/Service/AddMachDetails.php";
        String Check_URL = "http://192.168.43.241/Service/AMCWarranty.php";
        String Compreg_URL = "http://192.168.43.241/Service/ComplaintReg.php";
        if(type.equals("CInsert")){
            try {
                String ID = params[1];
                String Name = params[2];
                String Mobnum = params[3];
                String MailID = params[4];
                String Addr = params[5];

                URL url = new URL(insert_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("ID", "UTF-8") + "=" + URLEncoder.encode(ID, "UTF-8") + "&"
                        +URLEncoder.encode("Name", "UTF-8") + "=" + URLEncoder.encode(Name, "UTF-8") + "&"
                        +URLEncoder.encode("Phno", "UTF-8") + "=" + URLEncoder.encode(Mobnum, "UTF-8") + "&"
                        +URLEncoder.encode("Email", "UTF-8") + "=" + URLEncoder.encode(MailID, "UTF-8") + "&"
                        + URLEncoder.encode("Addr", "UTF-8") + "=" + URLEncoder.encode(Addr, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         else if(type.equals("EngInsert")){
        try {
            String engID = params[1];
            String engname = params[2];
            String engmob = params[3];
            String engemail = params[4];
            String engexp = params[5];
            String engavai = params[6];
            URL url = new URL(Enginsert_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("engID", "UTF-8") + "=" + URLEncoder.encode(engID, "UTF-8") + "&"
                    +URLEncoder.encode("engname", "UTF-8") + "=" + URLEncoder.encode(engname, "UTF-8") + "&"
                    +URLEncoder.encode("engmobno", "UTF-8") + "=" + URLEncoder.encode(engmob, "UTF-8") + "&"
                    +URLEncoder.encode("engemail", "UTF-8") + "=" + URLEncoder.encode(engemail, "UTF-8") + "&"
                    + URLEncoder.encode("engexp", "UTF-8") + "=" + URLEncoder.encode(engexp , "UTF-8")+ "&"
                    +URLEncoder.encode("engavai", "UTF-8") + "=" + URLEncoder.encode(engavai, "UTF-8") ;
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        else if(type.equals("MachInsert")){
            try {
                String MCustID = params[1];
                String MID = params[2];
                String MName= params[3];
                String MModel = params[4];
                String Mdate = params[5];
                String MRate = params[6];
                String MWarS = params[7];
                String MWarE = params[8];
                String MAMCS = params[9];
                String MAMCE = params[10];
                URL url = new URL(Machinsert_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Cust_ID", "UTF-8") + "=" + URLEncoder.encode(MCustID, "UTF-8") + "&"
                        +URLEncoder.encode("Mach_ID", "UTF-8") + "=" + URLEncoder.encode(MID, "UTF-8") + "&"
                        +URLEncoder.encode("Mach_Name", "UTF-8") + "=" + URLEncoder.encode(MName, "UTF-8") + "&"
                        +URLEncoder.encode("Mach_Model", "UTF-8") + "=" + URLEncoder.encode(MModel, "UTF-8") + "&"
                        + URLEncoder.encode("Date", "UTF-8") + "=" + URLEncoder.encode(Mdate , "UTF-8")+ "&"
                        + URLEncoder.encode("Rate", "UTF-8") + "=" + URLEncoder.encode(MRate , "UTF-8")+ "&"
                        + URLEncoder.encode("War_Start", "UTF-8") + "=" + URLEncoder.encode(MWarS , "UTF-8")+ "&"
                        + URLEncoder.encode("War_End", "UTF-8") + "=" + URLEncoder.encode(MWarE , "UTF-8")+ "&"
                        + URLEncoder.encode("AMC_Start", "UTF-8") + "=" + URLEncoder.encode(MAMCS , "UTF-8")+ "&"
                        +URLEncoder.encode("AMC_End", "UTF-8") + "=" + URLEncoder.encode(MAMCE, "UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

      else  if(type.equals("CDelete")){
            try {
                String ID = params[1];
                URL url = new URL(CDelete_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("ID", "UTF-8") + "=" + URLEncoder.encode(ID, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else  if(type.equals("EngDel")){
            try {
                String engID = params[1];
                URL url = new URL(EDelete_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("engID", "UTF-8") + "=" + URLEncoder.encode(engID, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("EngUp")){
            try {
                String engID = params[1];
                String engname = params[2];
                String engmob = params[3];
                String engemail = params[4];
                String engexp = params[5];
                String engavai = params[6];
                URL url = new URL(EUpdate_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("engID", "UTF-8") + "=" + URLEncoder.encode(engID, "UTF-8") + "&"
                        +URLEncoder.encode("engname", "UTF-8") + "=" + URLEncoder.encode(engname, "UTF-8") + "&"
                        +URLEncoder.encode("engmobno", "UTF-8") + "=" + URLEncoder.encode(engmob, "UTF-8") + "&"
                        +URLEncoder.encode("engemail", "UTF-8") + "=" + URLEncoder.encode(engemail, "UTF-8") + "&"
                        + URLEncoder.encode("engexp", "UTF-8") + "=" + URLEncoder.encode(engexp , "UTF-8")+ "&"
                        +URLEncoder.encode("engavai", "UTF-8") + "=" + URLEncoder.encode(engavai, "UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(type.equals("CUpdate")){
            try {
                String ID = params[1];
                String Name = params[2];
                String Mobnum = params[3];
                String MailID = params[4];
                String Addr = params[5];
                URL url = new URL(CUpdate_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("ID", "UTF-8") + "=" + URLEncoder.encode(ID, "UTF-8") + "&"
                        +URLEncoder.encode("Name", "UTF-8") + "=" + URLEncoder.encode(Name, "UTF-8") + "&"
                        +URLEncoder.encode("Phno", "UTF-8") + "=" + URLEncoder.encode(Mobnum, "UTF-8") + "&"
                        +URLEncoder.encode("Email", "UTF-8") + "=" + URLEncoder.encode(MailID, "UTF-8") + "&"
                        + URLEncoder.encode("Addr", "UTF-8") + "=" + URLEncoder.encode(Addr, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("SerInsert")){
            try {
                String MachineName = params[1];
                String MachineModel= params[2];
                String ServiceName= params[3];
                String Charges = params[4];
                URL url = new URL(Serviceinsert_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("MachineName", "UTF-8") + "=" + URLEncoder.encode(MachineName, "UTF-8") + "&"
                        +URLEncoder.encode("MachineModel", "UTF-8") + "=" + URLEncoder.encode(MachineModel, "UTF-8") + "&"
                        +URLEncoder.encode("ServiceName", "UTF-8") + "=" + URLEncoder.encode(ServiceName, "UTF-8") + "&"
                        +URLEncoder.encode("Charges", "UTF-8") + "=" + URLEncoder.encode(Charges, "UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else  if(type.equals("ChkAMCWar")){
            try {
                String ChkMachID = params[1];
                URL url = new URL(Check_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("ChkMachID", "UTF-8") + "=" + URLEncoder.encode(ChkMachID, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else  if(type.equals("MachDel")){
            try {
                String Cust_ID = params[1];
                URL url = new URL(MDelete_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Cust_ID", "UTF-8") + "=" + URLEncoder.encode(Cust_ID, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(type.equals("MachUp")){
            try {
                String MCustID = params[1];
                String MID = params[2];
                String MName= params[3];
                String MModel = params[4];
                String Mdate = params[5];
                String MRate = params[6];
                String MWarS = params[7];
                String MWarE = params[8];
                String MAMCS = params[9];
                String MAMCE = params[10];
                URL url = new URL(MUpdate_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Cust_ID", "UTF-8") + "=" + URLEncoder.encode(MCustID, "UTF-8") + "&"
                        +URLEncoder.encode("Mach_ID", "UTF-8") + "=" + URLEncoder.encode(MID, "UTF-8") + "&"
                        +URLEncoder.encode("Mach_Name", "UTF-8") + "=" + URLEncoder.encode(MName, "UTF-8") + "&"
                        +URLEncoder.encode("Mach_Model", "UTF-8") + "=" + URLEncoder.encode(MModel, "UTF-8") + "&"
                        + URLEncoder.encode("Date", "UTF-8") + "=" + URLEncoder.encode(Mdate , "UTF-8")+ "&"
                        + URLEncoder.encode("Rate", "UTF-8") + "=" + URLEncoder.encode(MRate , "UTF-8")+ "&"
                        + URLEncoder.encode("War_Start", "UTF-8") + "=" + URLEncoder.encode(MWarS , "UTF-8")+ "&"
                        + URLEncoder.encode("War_End", "UTF-8") + "=" + URLEncoder.encode(MWarE , "UTF-8")+ "&"
                        + URLEncoder.encode("AMC_Start", "UTF-8") + "=" + URLEncoder.encode(MAMCS , "UTF-8")+ "&"
                        +URLEncoder.encode("AMC_End", "UTF-8") + "=" + URLEncoder.encode(MAMCE, "UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(type.equals("ServiceDel")){
            try {

                String MachineName= params[1];
                URL url = new URL(ServiceDel_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("MachineName", "UTF-8") + "=" + URLEncoder.encode(MachineName, "UTF-8")  ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("ServiceUp")){
            try {
                String MachineName = params[1];
                String MachineModel= params[2];
                String ServiceName= params[3];
                String Charges = params[4];
                URL url = new URL(ServiceUp_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("MachineName", "UTF-8") + "=" + URLEncoder.encode(MachineName, "UTF-8") + "&"
                        +URLEncoder.encode("MachineModel", "UTF-8") + "=" + URLEncoder.encode(MachineModel, "UTF-8") + "&"
                        +URLEncoder.encode("ServiceName", "UTF-8") + "=" + URLEncoder.encode(ServiceName, "UTF-8") + "&"
                        +URLEncoder.encode("Charges", "UTF-8") + "=" + URLEncoder.encode(Charges, "UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         else if(type.equals("ComplaintReg")){
            try {
                String Cmpcustid = params[1];
                String machID= params[2];
                String Cmptypeofcomp= params[3];
                String Cmpdesc = params[4];
                String Cmpdate = params[5];
                String Cmpnum = params[6];
                URL url = new URL(Compreg_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Cmpcustid", "UTF-8") + "=" + URLEncoder.encode(Cmpcustid, "UTF-8") + "&"
                        +URLEncoder.encode("machID", "UTF-8") + "=" + URLEncoder.encode(machID, "UTF-8") + "&"
                        +URLEncoder.encode("Cmptypeofcomp", "UTF-8") + "=" + URLEncoder.encode(Cmptypeofcomp, "UTF-8") + "&"
                        +URLEncoder.encode("Cmpdesc", "UTF-8") + "=" + URLEncoder.encode(Cmpdesc, "UTF-8") + "&"
                        +URLEncoder.encode("Cmpdate", "UTF-8") + "=" + URLEncoder.encode(Cmpdate, "UTF-8") + "&"
                        +URLEncoder.encode("Cmpnum", "UTF-8") + "=" + URLEncoder.encode(Cmpnum, "UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("StatusInsert")){
            try {
                String cno = params[1];
                String cdate= params[2];
                String status= params[3];
                String comments = params[4];
                URL url = new URL(AddStatus_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("cno", "UTF-8") + "=" + URLEncoder.encode(cno, "UTF-8") + "&"
                        +URLEncoder.encode("cdate", "UTF-8") + "=" + URLEncoder.encode(cdate, "UTF-8") + "&"
                        +URLEncoder.encode("status", "UTF-8") + "=" + URLEncoder.encode(status, "UTF-8") + "&"
                        +URLEncoder.encode("comments", "UTF-8") + "=" + URLEncoder.encode(comments, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
}

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");

    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
        if ((result != null) && (result.equals("Yes,Register Complaint"))) {
            Intent intent;
            intent = new Intent(context,ComplaintsPage.class);
            context.startActivity(intent);
        }
        else if ((result != null) && (result.equals("No,Answer the questions"))) {
            Intent intent;
            intent = new Intent(context,QuestionsPage.class);
            context.startActivity(intent);
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}



