package com.example.weatherchekk.pojo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ReminderDatabase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME= "reminders";
    public static final String TABLE_REMINDER = "Reminders";
    public static final String COLUMN_ID = "id";

    public static final String COLUMN_CITY= "city"; //city name
    public static final String COLUMN_HOUR = "hour"; //hour
    public static final String  COLUMN_MINUTE = "minute"; //minute
    public static final String COLUMN_AM = "am"; //am_pm
    public static final String COLUMN_EDIT = "edit"; //edit


    public static final String CREATE_REMINDERS_TABLE = "CREATE TABLE "+
            TABLE_REMINDER+"("+COLUMN_ID+" INTEGER PRIMARY KEY,"+
            COLUMN_HOUR + " TEXT, " +
            COLUMN_MINUTE + " TEXT, " +
            COLUMN_AM + " TEXT, "+
            COLUMN_CITY + " TEXT, " +
            COLUMN_EDIT + " TEXT) ";


    public ReminderDatabase(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_REMINDERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addProject(reminds project){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CITY, project.getCity());
        values.put(COLUMN_HOUR, project.getHour());
        values.put(COLUMN_MINUTE, project.getMinute());
        values.put(COLUMN_AM, project.getAm());
        values.put(COLUMN_EDIT, project.getEdit());
        db.insert(TABLE_REMINDER, null, values);
        db.close();
    }

    public reminds getView(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        reminds remind = null;
        Cursor cursor = db.query(TABLE_REMINDER,new String[]{COLUMN_ID, COLUMN_HOUR, COLUMN_MINUTE, COLUMN_AM, COLUMN_CITY, COLUMN_EDIT},COLUMN_ID + "= ?", new String[]{String.valueOf(id)},null,null,null);

        if(cursor.moveToFirst()){
            remind = new reminds(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5));
        }
        db.close();
        return remind;
    }

    public ArrayList<reminds> getAllProject(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_REMINDER, null);
        ArrayList<reminds> reminders = new ArrayList<>();
        while (cursor.moveToNext()){
            reminders.add(new reminds(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)));
        }
        db.close();
        return reminders;
    }

    public int updateData(reminds Reminds){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CITY, Reminds.getCity());
        values.put(COLUMN_HOUR, Reminds.getHour());
        values.put(COLUMN_MINUTE, Reminds.getMinute());
        values.put(COLUMN_AM, Reminds.getAm());
        values.put(COLUMN_EDIT, Reminds.getEdit());
        return db.update(TABLE_REMINDER,values,COLUMN_ID+ "=?", new String[]{String.valueOf(Reminds.getId())});
    }

    public void deleteProject(int view){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_REMINDER, COLUMN_ID +  "=?",
                new String[]{String.valueOf(view)});
        db.close();
    }
}
