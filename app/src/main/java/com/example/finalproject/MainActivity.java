package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.finalproject.ui.login.BloodData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    BloodData bd;
    HosData hd;
    private Button btn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd=BloodData.getInstance(MainActivity.this);
        hd=HosData.getInstance(MainActivity.this);
        //bd.insertRecord("Swarnim","swarnim992","swarnim123","swarnimjain992@gmail.com","9922012164","A+","Male","13/06/2001","Shirpur","shirpur","dhule","shirpur");
        //bd.printRecords();
        //hd.getWritableDatabase();
        //hd.hinsertRecord("Indira Hospital","indira","indira123","indira@gmail.com","425405","Indira hospital ","Shirpur","dhule","near cranti nagar");
        //hd.printRecords();
        //hd.close();


        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,home1.class);
                Toast.makeText(getApplicationContext(),"Wellcome",Toast.LENGTH_SHORT).show();
                startActivity(i);

                //rootNode = FirebaseDatabase.getInstance();
                //reference = rootNode.getReference("user");

                //reference.setValue("Demo");
            }
        });
    }

}
