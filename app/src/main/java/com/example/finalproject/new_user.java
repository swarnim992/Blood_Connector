package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.ui.login.BloodData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class new_user extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12;
    RadioButton r1,r2;
    DatePicker d1;
    Spinner s1 , s2 ;
    Button b1;
    BloodData i;

    String name,email,mobile,username,password,blood,cit,dis,landmark,gender,add,bir;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);

        i=BloodData.getInstance(new_user.this);

        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);

        s1=(Spinner)findViewById(R.id.blood_select);
        //s2=(Spinner)findViewById(R.id.cityi);


        e1=(EditText)findViewById(R.id.textname);
        e2=(EditText)findViewById(R.id.username);
        e3=(EditText)findViewById(R.id.pass);
        e4=(EditText)findViewById(R.id.conpassword);
        e5=(EditText)findViewById(R.id.textemail);
        e6=(EditText)findViewById(R.id.mo);
        e7=(EditText)findViewById(R.id.addre);
        e9=(EditText)findViewById(R.id.dis);
        e10=(EditText)findViewById(R.id.landmark);
        e11= (EditText)findViewById(R.id.cityi);
        e12=(EditText)findViewById(R.id.bir);

        //d1=(DatePicker)findViewById(R.id.birth);

        b1=(Button)findViewById(R.id.sign);




        //gender="Male";
        //blood="A+";

       // bir="2001";



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=e1.getText().toString();
                username=e2.getText().toString();
                password=e3.getText().toString();
                email=e5.getText().toString();
                mobile=e6.getText().toString();
                add=e7.getText().toString();
                dis=e9.getText().toString();
                landmark=e10.getText().toString();
                cit=e11.getText().toString();
                bir=e12.getText().toString();

                //bir=d1.toString();
                //int id=Integer.valueOf(e6.getText().toString());
                if (r1.isChecked()){
                    gender="male";
                }
                else if (r2.isChecked()){
                    gender="Femail";
                }

                blood=s1.getSelectedItem().toString();
                //cit=s2.getSelectedItem().toString();


                //i.getWritableDatabase();
                // i.insertRecord("Swarnim","swarnim992","swarnim123","swarnimjain992@gmail.com","9922012164","A+","Male","13/06/2001","Shirpur","shirpur","dhule","shirpur");
                //i.insertRecord(name,username,password,email,mobile,blood,gender,bir,add,cit,dis,landmark);
                //i.close();
                //Toast.makeText(new_user.this,"User Added Successfully",Toast.LENGTH_LONG).show();

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("user");

                blood blo = new blood(name,username,password,email,mobile,blood,gender,bir,cit,add,dis,landmark);
                reference.child(username).setValue(blo);

                //Toast.makeText(new_user.this,"User Added Successfully",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(new_user.this,U_Login.class);
                startActivity(intent);

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(new_user.this);
                alertDialog.setTitle("Account Created Successfully");
                alertDialog.show();
            }
        });


    }
}
