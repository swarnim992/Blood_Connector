package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class option extends AppCompatActivity {


    private Button b1,b2,b3;
    String n,u,o;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);

        b1=findViewById(R.id.sr);
        b2=findViewById(R.id.don);
        b3=findViewById(R.id.update);



        n=getIntent().getStringExtra("name");
        u=getIntent().getStringExtra("uname");
        i=getIntent().getIntExtra("option",0);


        if(i==0){
            b3.setVisibility(View.GONE);
        }else {
            b3.setVisibility(View.VISIBLE);
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(option.this,search_blood.class);
                startActivity(i);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij = new Intent(option.this,donate_blood.class);
                startActivity(ij);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij = new Intent(option.this,profile_update.class);
                ij.putExtra("name",n);
                ij.putExtra("uname",u);
                startActivity(ij);
            }
        });
    }
}
