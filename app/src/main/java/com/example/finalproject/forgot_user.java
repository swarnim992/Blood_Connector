package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.ui.login.BloodData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class forgot_user extends AppCompatActivity {

    Button b1 ;
    EditText e1 , e2 ;
    DatePicker d1 ;
    BloodData db;
    String mobile , date , u;
    List<blood> l1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_user);

        b1= (Button)findViewById(R.id.us);
        e1= (EditText) findViewById(R.id.mobi);
        e2= (EditText) findViewById(R.id.data);
       // d1 = (DatePicker) findViewById(R.id.data);

        //db=new BloodData(forgot_user.this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile =(String)  e1.getText().toString();
                date=(String)e2.getText().toString();

                //date=(String)  "2001";
                //u=db.for_user(mobile,date);

                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("user");
                Query ch=reference.child("user").orderByChild("mobile").equalTo(mobile);


                ch.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String pass=snapshot.child(mobile).child("birth").getValue(String.class);

                            if(pass.equals(date)){
                                //intent.putExtra("name",l1.get(0).getName());

                                u=snapshot.child(mobile).child("username").getValue(String.class);

                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(forgot_user.this);
                                alertDialog.setTitle(" Your user name is  "+u+"");
                                alertDialog.setNegativeButton(" Ok ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Intent intent=new Intent(forgot_user.this,home1.class);
                                        startActivity(intent);
                                    }
                                });
                                alertDialog.show();

                            }
                            else{
                                Toast.makeText(forgot_user.this,"Wrong Input",Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                    public void finduser(String mob,String date){
                    }

                });





            }
        });





    }
}
