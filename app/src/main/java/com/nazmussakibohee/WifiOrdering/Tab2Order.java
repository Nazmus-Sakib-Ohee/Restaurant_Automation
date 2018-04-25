package com.nazmussakibohee.WifiOrdering;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Nazmus_Sakib_Ohee on 1/6/2018.
 */

public class Tab2Order extends Fragment {
    public static  final String DB_URL="jdbc:mysql://192.168.0.107/desktop";
    public static  final String USER="www";
    public static  final String PASS="www";
    String s1,s2,s3;
    long token;
    String tableno;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab2order, container, false);
        s1=InstanceSaver.order+"\n\n";
        int a=InstanceSaver.price;
        s2=Integer.toString(a);
        s3=s2+" Taka";

        final TextView t1=rootView.findViewById(R.id.textView10);
       final  TextView t2=rootView.findViewById(R.id.textView12);
        if(InstanceSaver.price==0||InstanceSaver.order.equals("")) {

        }

          else {
            t1.setText(InstanceSaver.order);

            t2.setText(InstanceSaver.price + " Taka");

        }
        Button btn1,btn2;
        btn1=rootView.findViewById(R.id.reset);
        btn2=rootView.findViewById(R.id.confirm);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               t1.setText("Choose Your Items\nFrom The Menu First");
               t2.setText("0 Taka");
                InstanceSaver.order="";
                InstanceSaver.price=0;
                Toast.makeText(getContext(), "Cleared", Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner r = rootView.findViewById(R.id.spinnertable);
                tableno = r.getSelectedItem().toString();
                if (tableno.equals("Select")) {
                    Toast.makeText(getContext(), "Select Table No", Toast.LENGTH_SHORT).show();

                }
                else if(t1.getText().toString().equals("Choose Your Items\nFrom The Menu First")){
                    Toast.makeText(getContext(), "Choose Item First", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(), "Ordering", Toast.LENGTH_SHORT).show();

                     token = new java.util.Date().getTime();
                    new send().execute();
                }
            }
        });

     final Spinner sp=rootView.findViewById(R.id.spinnertable);
      ArrayAdapter adapter ;
      adapter = ArrayAdapter.createFromResource(getContext(), R.array.plater, R.layout.spinner);
      sp.setAdapter(adapter);

        return rootView;
    }
    private class send extends AsyncTask<String,String,String> {




        @Override
        protected void onPreExecute(){
            Toast.makeText(getContext(), "Pre Execute", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
                    if (conn!=null)

                    {
                        String status="Not Delivered";
                        String a="`ordertable`(`orderno`, `tableno`, `orders`, `price`, `status`)";
                        String b="VALUES ("+token+","+"'"+tableno+"'"+","+"'"+s1+"'"+","+"'"+s3+"'"+","+"'"+status+"'";

                        String query="INSERT INTO"+" "+a+" "+b+")";

                        Statement stmt=conn.createStatement();
                        stmt.executeUpdate(query);
                        return "Order Completed";

                    }
                } catch (SQLException e) {
                    Log.e("ohee",e.toString());
                    return "LocalHost Connection Error";

                }
            } catch (ClassNotFoundException e) {
                return "error";

            }
            return "";

        }
        @Override
        protected void onPostExecute(String s){

            Toast.makeText(getContext(), s+"", Toast.LENGTH_SHORT).show();
        }
    }
}