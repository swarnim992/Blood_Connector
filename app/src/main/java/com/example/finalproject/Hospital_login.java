package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Hospital_login extends AppCompatActivity {

    private Button b1,b2,b3,b4;
    EditText e1 , e2;
    HosData hd;
    option o1;
    String user , pass ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_login);

        hd=HosData.getInstance(Hospital_login.this);


        b1=findViewById(R.id.log);
        b2=findViewById(R.id.cre);
        b3=findViewById(R.id.f_pa);

        e1=findViewById(R.id.huser);
        e2=findViewById(R.id.hpass);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user=e1.getText().toString();
                pass=e2.getText().toString();

                int i= hd.hlogin(user,pass);


                if(i==1){

                    Toast.makeText(Hospital_login.this,"Login Succes",Toast.LENGTH_LONG);
                    Intent intent =new Intent(Hospital_login.this,option.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(Hospital_login.this,"Wrong username or password",Toast.LENGTH_LONG).show();
                }

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij =new Intent(Hospital_login.this,hospital_sign_up.class);
                startActivity(ij);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent id =new Intent(Hospital_login.this,forget_pass_hos.class);
                startActivity(id);
            }
        });
    }
}
