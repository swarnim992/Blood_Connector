package com.example.finalproject.ui.login;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

import com.example.finalproject.U_Login;
import com.example.finalproject.blood;
import com.example.finalproject.profile_update;

public class BloodData extends SQLiteOpenHelper {

    public static final String blood_data = "Blood";
    public static final String TABLE_NAME = "User_T";
    public static final String user_table = "User_data";
    public static final String user_name="name";
    public static final String user_username= "username";
    public static final String user_email= "email";
    public static final String user_pass="password";
    public static final String user_mobile="mobile";
    public static final String user_gender="gender";
    public static final String user_blood="blood";
    public static final String user_birth="birth";
    public static final String user_address="address";
    public static final String user_city="city";
    public static final String user_dist="dist";
    public static final String user_landmark="landmark";
    public static int VERSION = 1;
    static SQLiteDatabase sdb;

    String cit;


    private static BloodData dbHandler;

    public BloodData(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, blood_data, null, VERSION);

    }

    public BloodData(Context context) {
        super(context, blood_data, null, VERSION);
    }

    public static BloodData getInstance(Context context){
        if(dbHandler == null){
            dbHandler = new BloodData(context, blood_data, null, VERSION);
        }
        return dbHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            db.execSQL("create table myblood(ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,username TEXT,password TEXT,email TEXT,mobile TEXT,blood TEXT,gender TEXT,date TEXT,addr TEXT,city TEXT,dist TEXT,landmark TEXT);");

        }catch(Exception e)
    {
        Log.d("DB", "onCreate: "+e.getMessage());
    }
    }



    public boolean insertRecord(String name, String username,String pass,String email,String mob,String blo,String gen,String dat,String addr,String cit,String dis,String land)
    {
        SQLiteDatabase db =   dbHandler.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("username", username);
        values.put("password", pass);
        values.put("email", email);
        values.put("mobile", mob);
        values.put("blood", blo);
        values.put("gender", gen);
        values.put("date", dat);
        values.put("addr", addr);
        values.put("city", cit);
        values.put("dist", dis);
        values.put("landmark", land);
        long id = db.insert("myblood", null, values);

        if(id == -1)
        {
            return false;
        }else
        {
            return true;
        }
    }




    public void printRecords()
    {
        SQLiteDatabase db =   dbHandler.getReadableDatabase();
        try
        {
            Cursor cursor = db.query("myblood", null, null, null, null, null, null);


            while (cursor.moveToNext()) {

                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String name=  cursor.getString(cursor.getColumnIndex("name"));
                String username = cursor.getString(cursor.getColumnIndex("username"));

                Log.d("DBHANDLER", "printRecords: "+id+" "+name+" "+username);
            }

            db.close();
        }
        catch(Exception e)
        {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS myblood");
        onCreate(db);

    }





    public List<blood> getAllblood(String blo , String ci)
    {
        List<blood> bloodl=new  ArrayList<blood>();

        cit=ci.toLowerCase();

        String selectQuery = "SELECT * FROM myblood WHERE (blood,city) =('"+blo+"','"+ci+"')";


        //  String selectQuery = "SELECT * FROM " +TABLE_NAME;

        sdb=BloodData.this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery(selectQuery,null);

        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();

            do {
                blood bl = new blood();

                bl.setId(Integer.parseInt(cursor.getString(0)));
                bl.setName(cursor.getString(1));
                bl.setBlood(cursor.getString(6));
                bl.setEmail(cursor.getString(4));
                bl.setGender(cursor.getString(7));
                bl.setBirth(cursor.getString(8));
                bl.setAddress(cursor.getString(9));
                bl.setDist(cursor.getString(11));
                bl.setLandmark(cursor.getString(12));
               // bl.setMobile(cursor.getString(5));
                bl.setCity(cursor.getString(10));

                bloodl.add(bl);

            }while (cursor.moveToNext());
        }

        return bloodl;
    }


    public List<blood> getAllDta(String user , String pass)
    {
        List<blood> bloodl=new  ArrayList<blood>();


        String selectQuery = "SELECT * FROM myblood WHERE (username,password) =('"+user+"','"+pass+"')";


        //  String selectQuery = "SELECT * FROM " +TABLE_NAME;

        sdb=BloodData.this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery(selectQuery,null);

        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();

            do {
                blood bl = new blood();

                bl.setId(Integer.parseInt(cursor.getString(0)));
                bl.setName(cursor.getString(1));
                bl.setBlood(cursor.getString(6));
                bl.setEmail(cursor.getString(4));
                bl.setGender(cursor.getString(7));
                bl.setBirth(cursor.getString(8));
                bl.setAddress(cursor.getString(9));
                bl.setDist(cursor.getString(11));
                bl.setLandmark(cursor.getString(12));
               // bl.setMobile(cursor.getString(5));
                bl.setCity(cursor.getString(10));

                bloodl.add(bl);

            }while (cursor.moveToNext());
        }

        return bloodl;
    }






    public int login(String us,String pas){

        String selectQuery = "SELECT * FROM myblood WHERE (username,password) =('"+us+"','"+pas+"')";

        sdb=BloodData.this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery(selectQuery,null);

        if (cursor.getCount()>0)
        {
            return 1;
        }
        else {
            return 0;
        }

    }


    public String for_user(String mobi, String dat){


        String selectQuery = "SELECT * FROM myblood WHERE (mobile,date) =('"+mobi+"','"+dat+"')";

        sdb=BloodData.this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery(selectQuery,null);
        String user = null;

        cursor.moveToFirst();
        user = cursor.getString(2);


        printRecords();
        return user;

    }


    public String for_pass(String user, String dat){


        String selectQuery = "SELECT * FROM myblood WHERE (username,date) =('"+user+"','"+dat+"')";

        sdb=BloodData.this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery(selectQuery,null);
        String pass = null;

        cursor.moveToFirst();
        pass = cursor.getString(3);


        printRecords();
        return pass;

    }



    public void updateProfile(String username, String uemail , String umobile  , String uadd, String ucity , String udist , String uland)
    {
        sdb=this.getWritableDatabase();

        sdb.execSQL("UPDATE myblood SET email='"+uemail+"', mobile='"+umobile+"', addr='"+uadd+"' , city='"+ucity+"', dist='"+udist+"', landmark='"+uland+"' WHERE username='"+username+"'");


    }


}
