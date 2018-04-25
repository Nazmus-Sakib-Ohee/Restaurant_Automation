package com.nazmussakibohee.WifiOrdering;


import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Tab1Menu extends Fragment{
private ImageView btn1,btn2,btn3,btn4,btn5,btn6;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab1menu, container, false);
         btn1=rootView.findViewById(R.id.platerbutton);
         btn2=rootView.findViewById(R.id.ricebutton);
         btn3=rootView.findViewById(R.id.currybutton);
         btn4=rootView.findViewById(R.id.kababbutton);
         btn5=rootView.findViewById(R.id.soupbutton);
         btn6=rootView.findViewById(R.id.drinksbutton);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           button1();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           button2();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          button3();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
     button4();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          button5();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         button6();
            }
        });

        return rootView;

    }
    public void button1(){

        Intent intent=new Intent(getActivity(),platermenu.class);
        startActivity(intent);
    }
    public void button2(){
        Intent intent=new Intent(getActivity(),rice.class);
        startActivity(intent);

    }
    public void button3(){
        Intent intent=new Intent(getActivity(),curry.class);
        startActivity(intent);

    }
    public void button4(){
        Intent intent=new Intent(getActivity(),kabab.class);
        startActivity(intent);

    }
    public void button5(){
        Intent intent=new Intent(getActivity(),soup.class);
        startActivity(intent);

    }
    public void button6(){
        Intent intent=new Intent(getActivity(),drinks.class);
        startActivity(intent);

    }

}
