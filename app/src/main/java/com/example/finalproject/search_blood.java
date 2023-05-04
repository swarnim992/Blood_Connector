package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.ui.login.BloodData;

import java.util.List;

public class search_blood extends AppCompatActivity {

    List<blood> l1,lp;
    List<hosp> l2;
    BloodData data;
    HosData hdata;

    ListView lis,lis1;
    Button b1;
    Spinner s1 , s2 ;

    String blood , ci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_blood);

        lis  =(ListView)findViewById(R.id.dis);
        lis1  =(ListView)findViewById(R.id.dis1);
        data=new BloodData(search_blood.this);
        hdata=new HosData(search_blood.this);



        lis1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(search_blood.this);
                alertDialog.setTitle("  Select Your Option?");
                // alertDialog.setCancelable(false);

                alertDialog.setNegativeButton("View Hospital Profile", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent=new Intent(search_blood.this,hospital_profile.class);
                        intent.putExtra("id",l2.get(position).getId());
                        intent.putExtra("name",l2.get(position).getHname());
                        intent.putExtra("con",l2.get(position).getHmobile());
                        intent.putExtra("city",l2.get(position).getHcit());
                        intent.putExtra("add",l2.get(position).getHadd());
                        intent.putExtra("landmark",l2.get(position).getHland());
                        intent.putExtra("dist",l2.get(position).getHdis());
                        startActivity(intent);
                    }
                });

                alertDialog.show();

                return false;
            }
        });



        lis.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(search_blood.this);
                alertDialog.setTitle("  Select Your Option?");
                // alertDialog.setCancelable(false);

                alertDialog.setNegativeButton("View Profile", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent=new Intent(search_blood.this,user_profile.class);
                        //intent.putExtra("id",l1.get(position).getId());
                        intent.putExtra("name",l1.get(position).getName());
                        intent.putExtra("city",l1.get(position).getCity());
                        intent.putExtra("mobile",l1.get(position).getMobile());
                        intent.putExtra("email",l1.get(position).getEmail());
                        intent.putExtra("blood",l1.get(position).getBlood());
                        intent.putExtra("dist",l1.get(position).getDist());
                        intent.putExtra("landmark",l1.get(position).getLandmark());
                        intent.putExtra("birth",l1.get(position).getBirth());
                        intent.putExtra("gender",l1.get(position).getGender());
                        intent.putExtra("add",l1.get(position).getAddress());
                        startActivity(intent);
                    }
                });

                alertDialog.show();

                return false;
            }
        });





        b1 = (Button) findViewById(R.id.search);
        s1 = (Spinner) findViewById(R.id.blood);
        s2 = (Spinner) findViewById(R.id.city);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blood = s1.getSelectedItem().toString();
                ci = s2.getSelectedItem().toString();

                displayblood(blood,ci);

            }
        });




    }

/*
    @Override
    protected void onResume() {
        super.onResume();

        displayblood();

    }

*/

    public class MybloodAdapter extends BaseAdapter {
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

            convertView = getLayoutInflater().inflate(R.layout.blood, null);

            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView blood = (TextView) convertView.findViewById(R.id.blood);
            TextView number = (TextView) convertView.findViewById(R.id.num);
            TextView city = (TextView) convertView.findViewById(R.id.city);

            name.setText(l1.get(position).getName());
            blood.setText(l1.get(position).getBlood());
            number.setText(l1.get(position).getMobile());
            city.setText(l1.get(position).getCity());


            return convertView ;
        }
    }




    public class MybloodAdapter1 extends BaseAdapter {
        @Override
        public int getCount() {
            return l2.size();
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

            name.setText(l2.get(position).getHname());
            number.setText(l2.get(position).getHmobile());
            city.setText(l2.get(position).getHcit());

            return convertView;
        }
    }




    public void displayblood(String blood, String ci) {

        //String contactTypeString = getIntent().getStringExtra("contact_type");

       // contactTypeString = contactTypeString.toLowerCase().toString();

        l1 = data.getAllblood(blood,ci);
        l2 = hdata.getAllHosBlood(ci);


        if (l1.size() > 0 ) {
            lis.setAdapter(new MybloodAdapter());

        } else {
            lis.setAdapter(new MybloodAdapter());

            Toast.makeText(search_blood.this, "No blood found", Toast.LENGTH_LONG).show();
        }

        if (l2.size() > 0) {
            lis1.setAdapter(new MybloodAdapter1());

        } else {
            lis1.setAdapter(new MybloodAdapter1());

            Toast.makeText(search_blood.this, "No blood found", Toast.LENGTH_LONG).show();
        }


    }




}
