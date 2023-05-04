package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class hospital_sign_up extends AppCompatActivity {

    Button b1;
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    Spinner s1;
    HosData hd;

    String hname,huser,hpass,hmob,hadd,hcit,hdis,hland,hemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_sign_up);

        hd=HosData.getInstance(hospital_sign_up.this);

        b1=findViewById(R.id.hoabutton);
        e1=findViewById(R.id.hosname);
        e2=findViewById(R.id.hosuser);
        e3=findViewById(R.id.hospass);
        e4=findViewById(R.id.hosemai);
        e5=findViewById(R.id.hosmobil);
        e6=findViewById(R.id.hosadd);
        e7=findViewById(R.id.hosdis);
        e8=findViewById(R.id.hosland);

        s1=findViewById(R.id.hoscit);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hname = e1.getText().toString();
                huser =e2.getText().toString();
                hpass =e3.getText().toString();
                hemail =e4.getText().toString();
                hmob =e5.getText().toString();
                hadd =e6.getText().toString();
                hdis =e7.getText().toString();
                hland =e8.getText().toString();

                hcit=s1.getSelectedItem().toString();



                hd.getWritableDatabase();

                hd.hinsertRecord(hname,huser,hpass,hemail,hmob,hadd,hcit,hdis,hland);
                hd.close();
                Toast.makeText(hospital_sign_up.this,"Hospital Added Successfully",Toast.LENGTH_LONG).show();

            }
        });




    }
}
