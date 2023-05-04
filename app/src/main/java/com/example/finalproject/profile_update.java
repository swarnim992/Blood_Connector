package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.ui.login.BloodData;

public class profile_update extends AppCompatActivity {

    Button b1,b2;
    EditText e1,e2,e3,e4,e5,e6,e7;
    TextView t1;
    String name,username , email, mobile,city,dist,land,add;
    BloodData bd;
    //Button b1,b2;
    Spinner s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_update);

        e1=findViewById(R.id.uemail);
        e2=findViewById(R.id.umobi);
        e3=findViewById(R.id.uadd);
        e4=findViewById(R.id.udis);
        e5=findViewById(R.id.uland);

        s1=findViewById(R.id.ucity);

        t1=findViewById(R.id.welcome);



        b1=(Button)  findViewById(R.id.back);




        bd=BloodData.getInstance(profile_update.this);

        name=getIntent().getStringExtra("name");
        username=getIntent().getStringExtra("uname");

        t1.setText("Welcome "+name);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email=e1.getText().toString();
                mobile=e2.getText().toString();
                add=e3.getText().toString();
                dist=e4.getText().toString();
                land=e5.getText().toString();

                city = s1.getSelectedItem().toString();


                if(email==null || mobile==null  || city==null  || dist==null  || land==null  ){
                    bd.getWritableDatabase();

                    bd.updateProfile(username,email,mobile,add,city,dist,land);
                    bd.printRecords();

                    bd.close();
                    Toast.makeText(profile_update.this,"Profile Updated Succesfully",Toast.LENGTH_LONG).show();

                    Intent i = new Intent(profile_update.this,option.class);
                    startActivity(i);


                }else{
                    Toast.makeText(profile_update.this,"Fill full form ",Toast.LENGTH_LONG).show();

                }






            }
        });





    }
}
