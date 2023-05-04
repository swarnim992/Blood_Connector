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

public class forget_pass extends AppCompatActivity {

    Button b1;
    EditText e1 , e2 ;
    DatePicker d1;
    BloodData bd;
    String user , date , pass ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_pass);

        b1=(Button)  findViewById(R.id.getpass);
        e1=(EditText)  findViewById(R.id.use);

        //d1=(DatePicker)  findViewById(R.id.dat);
        //bd= new BloodData(forget_pass.this);
        e2 = (EditText)findViewById(R.id.dat);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user=e1.getText().toString();
                date=e2.getText().toString();

                //pass=bd.for_pass(user,date);

                pass="SWARNIM";

                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("user");
                Query ch=reference.orderByChild("username").equalTo(user);

                ch.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String da=snapshot.child(date).child("birth").getValue(String.class);

                            if(da.equals(date)){
                                //intent.putExtra("name",l1.get(0).getName());
                                //Toast.makeText(U_Login.this,"Login Successfully",Toast.LENGTH_LONG).show();
                                Toast.makeText(forget_pass.this,"Wrong Username or Birthdate",Toast.LENGTH_LONG).show();

                                String passw=snapshot.child(user).child("password").getValue(String.class);

                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(forget_pass.this);
                                alertDialog.setTitle(" Your Password is  "+passw+"");
                                alertDialog.setNegativeButton(" Ok ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Intent intent=new Intent(forget_pass.this,home1.class);
                                        startActivity(intent);
                                    }
                                });
                                alertDialog.show();
                            }
                            else{
                                Toast.makeText(forget_pass.this,"Wrong Username or Birthdate",Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });









            }
        });


    }
}
