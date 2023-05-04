package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.ui.login.BloodData;

import java.util.List;

public class donate_blood extends AppCompatActivity {

    List<hosp> l1;
    HosData hdata;
    TextView t1;
    ListView lis;
    Button b1;
    Spinner s1 ;

    String ci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate_blood);

        lis=findViewById(R.id.s);
        hdata=new HosData(donate_blood.this);
        b1=findViewById(R.id.sh);
        s1=findViewById(R.id.ci);
        t1=findViewById(R.id.donate);

        t1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t1.setVisibility(View.VISIBLE);
                ci=s1.getSelectedItem().toString();

                displayblood(ci);
            }
        });






    }



    public class MybloodAdapter1 extends BaseAdapter {
        @Override
        public int getCount() {
            return l1.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.hospital, null);

            TextView name = (TextView) convertView.findViewById(R.id.hname);
            TextView number = (TextView) convertView.findViewById(R.id.hnum);
            TextView city = (TextView) convertView.findViewById(R.id.hcity);

            name.setText(l1.get(position).getHname());
            number.setText(l1.get(position).getHmobile());
            city.setText(l1.get(position).getHcit());

            return convertView;
        }
    }



    public void displayblood(String ci) {

        //String contactTypeString = getIntent().getStringExtra("contact_type");

        // contactTypeString = contactTypeString.toLowerCase().toString();

        l1 = hdata.getAllHosBlood(ci);


        if (l1.size() > 0 ) {
            lis.setAdapter(new MybloodAdapter1());

        } else {
            lis.setAdapter(new MybloodAdapter1());

            Toast.makeText(donate_blood.this, "No blood found", Toast.LENGTH_LONG).show();
        }



    }




}
