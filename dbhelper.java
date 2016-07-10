package com.example.shrinivas.login1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Shrinivas on 10-07-2016.
 */
public class dbhelper {
    static final String DATABASE_NAME="";
    static final int DATABASE_VERSION= 1;
    static final String DATABASE_CREATE="create table "+" LOGIN "+"( "+"NAME"+"USERNAME"+"varchar[10]"+"PASSWORD"+"varchar[10]"+");";
    public SQLiteDatabase db;
    private final Context context;
    private DataBaseHelper dbh;

    public dbhelper(Context context) {
        this.context = context;

    }
    public dbhelper open() throws SQLException
    {
        db = dbh.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insert(String  name,String userName,String password)
    {
        ContentValues values = new ContentValues();

        values.put("USERNAME", userName);
        values.put("PASSWORD",password);
        values.put("NAME",name);


        db.insert("LOGIN", null, values);

    }
  /*  public int delete(String UserName)
    {

        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;

        return numberOFEntriesDeleted;
    }*/
    public String getSinlgeEntry(String userName) {
        Cursor cursor = db.query("LOGIN",null,"USERNAME=?",new String[]{userName},null,null,null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public void updateEntry(String userName,String password)
    {

        ContentValues updatedValues = new ContentValues();

        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        db.update("LOGIN",updatedValues, where, new String[]{userName});
    }
}


