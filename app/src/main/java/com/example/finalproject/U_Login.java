package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import java.util.Queue;

public class U_Login extends AppCompatActivity {

    private Button b1,b2,b3,b4;
    private EditText e1,e2;
    BloodData bd;
    String u , p , o ;
    List<blood> l1;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u__login);

        b1=findViewById(R.id.log_in);
        b2=findViewById(R.id.new_acc);
        b3=findViewById(R.id.f_user);
        b4=findViewById(R.id.f_pass);

        e1=(EditText) findViewById(R.id.user);
        e2=(EditText) findViewById(R.id.pass);

        bd=new BloodData(U_Login.this);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u = e1.getText().toString();
                p = e2.getText().toString();

                int i = bd.login(u,p);

                if(i==1){

                    l1=bd.getAllDta(u,p);

                    Intent intent =new Intent(U_Login.this,option.class);


                    //startActivity(intent);

                    DatabaseReference reference=FirebaseDatabase.getInstance().getReference("user");
                    Query ch=reference.orderByChild("username").equalTo(u);

                    ch.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                String pass=snapshot.child(u).child("password").getValue(String.class);

                                if(pass.equals(p)){
                                    intent.putExtra("uname",u);
                                    intent.putExtra("option",1);
                                    startActivity(intent);
                                    //intent.putExtra("name",l1.get(0).getName());
                                    Toast.makeText(U_Login.this,"Login Successfully",Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(U_Login.this,"Wrong username or password",Toast.LENGTH_LONG).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else
                {
                    Toast.makeText(U_Login.this,"Wrong username or password",Toast.LENGTH_LONG).show();
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j =new Intent(U_Login.this,new_user.class);
                startActivity(j);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij =new Intent(U_Login.this,forgot_user.class);
                startActivity(ij);
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ik =new Intent(U_Login.this,forget_pass.class);
                startActivity(ik);
            }
        });
    }
}
