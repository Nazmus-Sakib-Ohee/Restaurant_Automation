package com.nazmussakibohee.WifiOrdering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class platermenu extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(platermenu.this,MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platermenu);

        final Spinner spinner1 = (Spinner) findViewById(R.id.setonespinner);
        final Spinner spinner2 = (Spinner) findViewById(R.id.settwospinner);
        final Spinner spinner3 = (Spinner) findViewById(R.id.setthreespinner);
        ArrayAdapter adapter ;
        adapter = ArrayAdapter.createFromResource(
                this, R.array.plater, R.layout.spinner);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);

        final TextView txt1=findViewById(R.id.setone);
        final TextView txt2=findViewById(R.id.settwo);
        final TextView txt3=findViewById(R.id.setthree);

        final ImageView back =findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(platermenu.this,MainActivity.class);
                startActivity(intent);
            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q=spinner1.getSelectedItem().toString();
                if(q.equals("Select")){
                    Toast.makeText(platermenu.this, "Select Amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (txt1.getText() == "Added") {
                        Toast.makeText(platermenu.this, "Already Added", Toast.LENGTH_SHORT).show();
                    } else {
                        txt1.setText("Added");
                        txt1.setTextColor(getResources().getColor(R.color.addedcolor));
                        String a=spinner1.getSelectedItem().toString();
                        int b=Integer.parseInt(a);
                        int c=b*255;
                        InstanceSaver.price=InstanceSaver.price+c;
                        InstanceSaver.order=InstanceSaver.order+"\n"+a+" "+"Of "+"Plater Set One";
                    }
                }
            }
        });


        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q=spinner2.getSelectedItem().toString();
                if(q.equals("Select")){
                    Toast.makeText(platermenu.this, "Select Amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (txt2.getText() == "Added") {
                        Toast.makeText(platermenu.this, "Already Added", Toast.LENGTH_SHORT).show();
                    } else {
                        txt2.setText("Added");
                        txt2.setTextColor(getResources().getColor(R.color.addedcolor));
                        String a=spinner2.getSelectedItem().toString();
                        int b=Integer.parseInt(a);
                        int c=b*325;
                        InstanceSaver.price=InstanceSaver.price+c;
                        InstanceSaver.order=InstanceSaver.order+"\n"+a+" "+"Of "+"Plater Set Two";
                    }
                }
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q=spinner3.getSelectedItem().toString();
                if(q.equals("Select")){
                    Toast.makeText(platermenu.this, "Select Amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (txt3.getText() == "Added") {
                        Toast.makeText(platermenu.this, "Already Added", Toast.LENGTH_SHORT).show();
                    } else {
                        txt3.setText("Added");
                        txt3.setTextColor(getResources().getColor(R.color.addedcolor));
                        String a=spinner3.getSelectedItem().toString();
                        int b=Integer.parseInt(a);
                        int c=b*340;
                        InstanceSaver.price=InstanceSaver.price+c;
                        InstanceSaver.order=InstanceSaver.order+"\n"+a+" "+"Of "+"Plater Set Three";
                    }
                }
            }
        });


    }
}
