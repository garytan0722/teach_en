package com.genglun.teach_en.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by garytan on 2015/10/18.
 */
public class db_helper extends SQLiteOpenHelper {
    final static String CLASS1_TABLE_NAME="class1";
    final static String CLASS2_TABLE_NAME="class2";
    final static String CLASS3_TABLE_NAME="class3";
    final static String RECORD_TABLE_NAME="record";
    final static String  ID="id";
    final static String  ANS="ans";
    final static String IMAGE="image";
    final static String TIME="time";
    final static String SCORE="score";
    public static SQLiteDatabase db;
    public db_helper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {

        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("db_helper", "onCreate");
        String class1 = "create table " +  CLASS1_TABLE_NAME+ "(" + ID + " text,"
                + ANS + " text, " + IMAGE + " text)";
        String class2 = "create table " +  CLASS2_TABLE_NAME+ "(" + ID + " text,"
                + ANS + " text, " + IMAGE + " text)";
        String class3 = "create table " +  CLASS3_TABLE_NAME+ "(" + ID + " text,"
                + ANS + " text, " + IMAGE + " text)";
        String record = "create table " +  RECORD_TABLE_NAME+ "(" + ID + " text,"
                + TIME + " text, " + SCORE + " text)";


        db.execSQL(class1);
        db.execSQL(class2);
        db.execSQL(class3);
        db.execSQL(record);
        db.execSQL("INSERT INTO " + CLASS1_TABLE_NAME + " VALUES(1, 'eating breakfast', 'breakfast');");
        db.execSQL("INSERT INTO " + CLASS1_TABLE_NAME + " VALUES(2, 'eating lunch', 'lunch');");
        db.execSQL("INSERT INTO " + CLASS1_TABLE_NAME + " VALUES(3, 'eating dinner', 'dinner');");
        db.execSQL("INSERT INTO " + CLASS1_TABLE_NAME + " VALUES(4, 'studying', 'study');");
        db.execSQL("INSERT INTO " + CLASS1_TABLE_NAME + " VALUES(5, 'watching TV', 'tv');");
        db.execSQL("INSERT INTO " + CLASS1_TABLE_NAME + " VALUES(6, 'sleep', 'sleep');");
        //class2
        db.execSQL("INSERT INTO " + CLASS2_TABLE_NAME + " VALUES(1, 'flying a kite', 'kite');");
        db.execSQL("INSERT INTO " + CLASS2_TABLE_NAME + " VALUES(2, 'doing my homework', 'homework');");
        db.execSQL("INSERT INTO " + CLASS2_TABLE_NAME + " VALUES(3, 'surfing the Internet', 'surf');");
        db.execSQL("INSERT INTO " + CLASS2_TABLE_NAME + " VALUES(4, 'swimming', 'swim');");
        db.execSQL("INSERT INTO " + CLASS2_TABLE_NAME + " VALUES(5, 'riding a bike', 'bike');");
        //class3
        db.execSQL("INSERT INTO " + CLASS3_TABLE_NAME + " VALUES(1, 'sunny', 'sunny');");
        db.execSQL("INSERT INTO " + CLASS3_TABLE_NAME + " VALUES(2, 'rainy', 'rainy');");
        db.execSQL("INSERT INTO " + CLASS3_TABLE_NAME + " VALUES(3, 'windy', 'windy');");
        db.execSQL("INSERT INTO " + CLASS3_TABLE_NAME + " VALUES(4, 'cloudy', 'cloudy');");
        db.execSQL("INSERT INTO " + CLASS3_TABLE_NAME + " VALUES(5, 'hot', 'hot');");
        db.execSQL("INSERT INTO " + CLASS3_TABLE_NAME + " VALUES(6, 'warm', 'warm');");
        db.execSQL("INSERT INTO " + CLASS3_TABLE_NAME + " VALUES(7, 'cool', 'cool');");
        db.execSQL("INSERT INTO " + CLASS3_TABLE_NAME + " VALUES(8, 'cold', 'cold');");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);
    }

    public   long record_add(String id, String time, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(ID, id);
        value.put(TIME, time);
        value.put(SCORE, score);
        long result = db.insert(RECORD_TABLE_NAME, null, value);
        db.close();
        return result;
    }
    public  long record_del(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(RECORD_TABLE_NAME, ID + "=" + id, null);
        db.close();
        return result;
    }
    public  Cursor class1_randomget(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(CLASS1_TABLE_NAME, null, null, null, null, null, "RANDOM()", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        database(db);
        return cursor;
    }
    public  Cursor class2_randomget(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(CLASS2_TABLE_NAME, null, null, null, null, null, "RANDOM()", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        database(db);
        return cursor;
    }
    public  Cursor class3_randomget(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(CLASS3_TABLE_NAME, null, null, null, null, null, "RANDOM()", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        database(db);
        return cursor;
    }
    public  Cursor gettotalrecord(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(RECORD_TABLE_NAME, null, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        database(db);
        return cursor;
    }
    public  void database( SQLiteDatabase db){
         this.db=db;
    }
    public static SQLiteDatabase getdatabase( ){
            return db;
    }

}
