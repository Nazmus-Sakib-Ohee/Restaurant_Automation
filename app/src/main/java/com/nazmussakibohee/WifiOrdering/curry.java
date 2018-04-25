package com.nazmussakibohee.WifiOrdering;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class curry extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(curry.this,MainActivity.class);
         startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curry);

        final Spinner spinner1 = (Spinner) findViewById(R.id.add1spinner);
        final Spinner spinner2 = (Spinner) findViewById(R.id.add2spinner);
        final Spinner spinner3 = (Spinner) findViewById(R.id.add3spinner);
        ArrayAdapter adapter ;
        adapter = ArrayAdapter.createFromResource(
                this, R.array.plater, R.layout.spinner);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        final TextView txt1=findViewById(R.id.add1);
        final TextView txt2=findViewById(R.id.add2);
        final TextView txt3=findViewById(R.id.add3);
        final ImageView back =findViewById(R.id.back1);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(curry.this,MainActivity.class);
                startActivity(intent);
            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q=spinner1.getSelectedItem().toString();
                if(q.equals("Select")){
                    Toast.makeText(curry.this, "Select Amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (txt1.getText() == "Added") {
                        Toast.makeText(curry.this, "Already Added", Toast.LENGTH_SHORT).show();
                    } else {
                        txt1.setText("Added");
                        txt1.setTextColor(getResources().getColor(R.color.addedcolor));
                        String a=spinner1.getSelectedItem().toString();
                        int b=Integer.parseInt(a);
                        int c=b*250;
                        InstanceSaver.price=InstanceSaver.price+c;
                        InstanceSaver.order=InstanceSaver.order+"\n"+a+" "+"Of "+"Chicken Korai";
                    }
                }
            }
        });


        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q=spinner2.getSelectedItem().toString();
                if(q.equals("Select")){
                    Toast.makeText(curry.this, "Select Amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (txt2.getText() == "Added") {
                        Toast.makeText(curry.this, "Already Added", Toast.LENGTH_SHORT).show();
                    } else {
                        txt2.setText("Added");
                        txt2.setTextColor(getResources().getColor(R.color.addedcolor));
                        String a=spinner2.getSelectedItem().toString();
                        int b=Integer.parseInt(a);
                        int c=b*235;
                        InstanceSaver.price=InstanceSaver.price+c;
                        InstanceSaver.order=InstanceSaver.order+"\n"+a+" "+"Of "+"Beef Achrai";
                    }
                }
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q=spinner3.getSelectedItem().toString();
                if(q.equals("Select")){
                    Toast.makeText(curry.this, "Select Amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (txt3.getText() == "Added") {
                        Toast.makeText(curry.this, "Already Added", Toast.LENGTH_SHORT).show();
                    } else {
                        txt3.setText("Added");
                        txt3.setTextColor(getResources().getColor(R.color.addedcolor));
                        String a=spinner3.getSelectedItem().toString();
                        int b=Integer.parseInt(a);
                        int c=b*330;
                        InstanceSaver.price=InstanceSaver.price+c;
                        InstanceSaver.order=InstanceSaver.order+"\n"+a+" "+"Of "+"Mutton Korai";
                    }
                }
            }
        });


    }
}


