package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forget_pass_hos extends AppCompatActivity {

    EditText e1 , e2 ;
    Button b1;
    HosData hd;
    String huser , hpass , hemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_pass_hos);


        e1 = findViewById(R.id.hus);
        e2 = findViewById(R.id.hem);
        b1 = findViewById(R.id.getpass);

        hd=HosData.getInstance(forget_pass_hos.this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                huser=e1.getText().toString();
                hemail=e2.getText().toString();

                hpass=hd.for_hpass(huser,hemail);


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(forget_pass_hos.this);
                alertDialog.setTitle(" Your Password is  "+hpass+"");
                alertDialog.setNegativeButton(" Ok ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent=new Intent(forget_pass_hos.this,home1.class);
                        startActivity(intent);
                    }
                });
                alertDialog.show();




            }
        });


    }
}
