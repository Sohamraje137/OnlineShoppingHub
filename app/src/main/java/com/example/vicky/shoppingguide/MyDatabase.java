package com.example.vicky.shoppingguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Currency;

/**
 * Created by vicky on 2/3/18.
 */

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DB_NAME="Wishlist.db";
    private static final int Version=1;
    public MyDatabase(Context context) {
        super(context, DB_NAME, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String table="CREATE TABLE WISHLIST(ID INTEGER PRIMARY KEY AUTOINCREMENT, URL TEXT)";
        sqLiteDatabase.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertDatabase(URL url){
        SQLiteDatabase database=getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("URL",url.getUrl());
      //  Log.i("Main","Going into db:"+url.getUrl());
        database.insert("WISHLIST",null,cv);
    }

    public ArrayList<URL> getAllurls(){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        ArrayList<URL> urls=new ArrayList<>();

        Cursor cursor=sqLiteDatabase.query("WISHLIST",null,null,null,null,null,null);
        boolean first=cursor.moveToFirst();

        if(!first){
            return null;
        }
        int urlIndex=cursor.getColumnIndex("URL");
        while (!cursor.isAfterLast()){
            String url=cursor.getString(urlIndex);

            URL urlObj=new URL();
            urlObj.setUrl(url);
            Log.i("Main","From db:"+url);
            urls.add(urlObj);
            cursor.moveToNext();
        }
        return urls;
    }
}
