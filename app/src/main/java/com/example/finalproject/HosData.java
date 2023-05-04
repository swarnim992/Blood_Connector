package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.finalproject.ui.login.BloodData;

import java.util.ArrayList;
import java.util.List;


public class HosData extends SQLiteOpenHelper {

    static SQLiteDatabase sdb;
    private static HosData dbHandler;


    public HosData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "hos_data", null, 1);
    }

    public HosData(Context context) {
        super(context, "hos_data", null, 1);
    }

    public static HosData getInstance(Context context){
        if(dbHandler == null){
            dbHandler = new HosData(context, "hos_data", null, 1);
        }
        return dbHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            db.execSQL("create table myhos(ID INTEGER PRIMARY KEY AUTOINCREMENT,hname TEXT,husername TEXT,hpassword TEXT,hemail TEXT,hmobile TEXT,haddr TEXT,hcity TEXT,hdist TEXT,hlandmark TEXT);");


        }catch(Exception e)
        {
            Log.d("DB", "onCreate: "+e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS myhos");
        onCreate(db);

    }


    public boolean hinsertRecord(String hname, String husername,String hpass,String hemail,String hmob,String haddr,String hcit,String hdis,String hland)
    {
        SQLiteDatabase db =   dbHandler.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("hname", hname);
        values.put("husername", husername);
        values.put("hpassword", hpass);
        values.put("hemail", hemail);
        values.put("hmobile", hmob);
        values.put("haddr", haddr);
        values.put("hcity", hcit);
        values.put("hdist", hdis);
        values.put("hlandmark", hland);

        long id = db.insert("myhos", null, values);

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
            Cursor cursor = db.query("myhos", null, null, null, null, null, null);


            while (cursor.moveToNext()) {

                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String name=  cursor.getString(cursor.getColumnIndex("hname"));
                String username = cursor.getString(cursor.getColumnIndex("husername"));

                Log.d("DBHANDLER", "printRecords: "+id+" "+name+" "+username);
            }

            db.close();
        }
        catch(Exception e)
        {

        }
    }



    public int hlogin(String us,String pas){

        String selectQuery = "SELECT * FROM myhos WHERE (husername,hpassword) =('"+us+"','"+pas+"')";

        sdb= HosData.this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery(selectQuery,null);

        if (cursor.getCount()>0)
        {
            return 1;
        }
        else {
            return 0;
        }

    }



    public List<hosp> getAllHosBlood( String ci)
    {
        List<hosp> hosp1=new ArrayList<hosp>();

        String selectQuery = "SELECT * FROM myhos WHERE hcity ='"+ci+"'";


        //  String selectQuery = "SELECT * FROM " +TABLE_NAME;

        sdb=HosData.this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery(selectQuery,null);

        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();

            do {
                hosp bl =new hosp();

                bl.setId(Integer.parseInt(cursor.getString(0)));
                bl.setHname(cursor.getString(1));
                bl.setHmobile(cursor.getString(5));
                bl.setHadd(cursor.getString(6));
                bl.setHdis(cursor.getString(8));
                bl.setHland(cursor.getString(9));
                bl.setHcit(cursor.getString(7));

                hosp1.add(bl);

            }while (cursor.moveToNext());
        }

        return hosp1;
    }



    public String for_hpass(String user, String email){


        String selectQuery = "SELECT * FROM myhos WHERE (husername,hemail) =('"+user+"','"+email+"')";

        sdb=HosData.this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery(selectQuery,null);
        String pass = null;

        cursor.moveToFirst();
        pass = cursor.getString(3);


        printRecords();
        return pass;

    }




}
