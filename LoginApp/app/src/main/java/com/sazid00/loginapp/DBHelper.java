package com.sazid00.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table user(username TEXT primary key,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists user");

    }

    public Boolean insert_userdata(String Username,String Password){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("username",Username);
        contentValues.put("password",Password);

        long result = sqLiteDatabase.insert("user",null,contentValues);

        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }

    }

    public Boolean check_username(String Username){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from user where username = ?",new String[]{Username});

        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }


    }

    public Boolean check_username_password(String Username,String Password)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from user where username = ? and password = ?",new String[]{Username,Password});

        if(cursor.getCount()>0)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
