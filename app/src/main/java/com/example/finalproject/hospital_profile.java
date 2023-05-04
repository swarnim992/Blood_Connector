package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class hospital_profile extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6 ;
    String hname,hmobile,hadd,hcity,hdist,hland;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_profile);


        e1=findViewById(R.id.hnam);
        e2=findViewById(R.id.hcon);
        e3=findViewById(R.id.hadd);
        e4=findViewById(R.id.hcit);
        e5=findViewById(R.id.hdis);
        e6=findViewById(R.id.hland);


        hname=getIntent().getStringExtra("name");
        hmobile=getIntent().getStringExtra("con");
        hadd=getIntent().getStringExtra("add");
        hcity=getIntent().getStringExtra("city");
        hdist=getIntent().getStringExtra("dist");
        hland=getIntent().getStringExtra("landmark");



        e1.setText(hname);
        e2.setText(hmobile);
        e3.setText(hadd);
        e4.setText(hcity);
        e5.setText(hdist);
        e6.setText(hland);


    }
}
