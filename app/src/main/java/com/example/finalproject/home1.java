package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home1 extends AppCompatActivity {

    private Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home1);

        b1=findViewById(R.id.user);
        b2=findViewById(R.id.hos);
        b3=findViewById(R.id.skip);

        //b3.setVisibility(View.INVISIBLE);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u_log=new Intent(home1.this,U_Login.class);
                startActivity(u_log);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hos_log=new Intent(home1.this,Hospital_login.class);
                startActivity(hos_log);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skip=new Intent(home1.this,option.class);
                startActivity(skip);
            }
        });

    }
}
