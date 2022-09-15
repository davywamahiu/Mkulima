package com.example.mkulima;

import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public final class DatabaseHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "Mkulima.db";
    public static final String CONTACTS_TABLE_NAME = "general";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table farmer (id Integer primary key autoincrement, email text,uname text, password text)");
        db.execSQL("create table DatabaseHelper1 (id Integer primary key autoincrement, name text,breed text, weight text, age text)");
        db.execSQL("create table " + CONTACTS_TABLE_NAME + "(id Integer primary key autoincrement, first text,last text, phoneme text)");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL("drop table if exists farmer");
        db.execSQL("drop table if exists DatabaseHelper1");
        db.execSQL("drop table if exists " +CONTACTS_TABLE_NAME);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public boolean insert (String email, String password, String uname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        contentValues.put("uname", uname);
        contentValues.put("email", email);
        long ins = db.insert("farmer", null, contentValues);
        if (ins==1){
            return false;
        }
        else
            return true;
    }
    public boolean addData (String first, String last, String phoneme) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("phoneme", phoneme);
        contentValues1.put("first", first);
        contentValues1.put("last", last);
        long ins1 = db.insert(CONTACTS_TABLE_NAME, null, contentValues1);
        if (ins1==1){
            return false;
        }
        else
            return true;
    }
    public boolean login(String uname) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from farmer where uname=? and password=?", new String[] {uname});
        if(cursor.getCount() > 0){
            return true;
        }
        else
        {
            return false;
        }
    }
    public ArrayList getAllCons() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> array_list = new ArrayList<String>();
        Cursor res = db.rawQuery("select (id ||' MOBILE '|| phoneme || ' NAME ' || first || '    '|| last) as fullname from " + CONTACTS_TABLE_NAME+" ORDER BY id DESC LIMIT 1", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            if ((res != null) && (res.getCount() > 0))
                array_list.add(res.getString(res.getColumnIndex("fullname")));
            res.moveToNext();
        }
        return array_list;
    }


    public void logout() {
        // TODO: revoke authentication
    }
}


