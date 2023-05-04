package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class user_profile extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6, e7, e8,e9,e10 ,e12,e11;
    String uname,uemail,umobile,ubir,ugender,ublood,uadd,ucity,udist,uland;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        e1=findViewById(R.id.name);
        e2=findViewById(R.id.email);
        e3=findViewById(R.id.mobile);
        e4=findViewById(R.id.bir);
        e5=findViewById(R.id.gender);
        e6=findViewById(R.id.blood_group);
        e7=findViewById(R.id.address);
        e8=findViewById(R.id.city);
        e9=findViewById(R.id.dist);
        e10=findViewById(R.id.landmark);


        uname=getIntent().getStringExtra("name");
        uemail=getIntent().getStringExtra("email");
        umobile=getIntent().getStringExtra("mobile");
        ubir=getIntent().getStringExtra("birth");
        ugender=getIntent().getStringExtra("gender");
        ublood=getIntent().getStringExtra("blood");
        uadd=getIntent().getStringExtra("add");
        ucity=getIntent().getStringExtra("city");
        udist=getIntent().getStringExtra("dist");
        uland=getIntent().getStringExtra("landmark");


        e1.setText(uname);
        e2.setText(uemail);
        e3.setText(umobile);
        e4.setText(ubir);
        e5.setText(ugender);
        e6.setText(ublood);
        e7.setText(uadd);
        e8.setText(ucity);
        e9.setText(udist);
        e10.setText(uland);



    }
}
