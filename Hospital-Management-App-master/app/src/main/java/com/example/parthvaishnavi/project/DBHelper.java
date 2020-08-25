package com.example.parthvaishnavi.project;

/**
 * Created by Anant Kedia on 07-08-2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Doctor.db";
    public static final String TABLE_NAME = "doctors_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "FNAME";
    private static final String COL_3 = "LNAME";
    private static final String COL_4 = "AGE";
    private static final String COL_5 = "FEES";
    private static final String COL_6 = "DEPARTMENT";
    private static final String COL_7 = "PHONE_NUMBER";

    private static final int version_name = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, version_name);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,FNAME TEXT,LNAME TEXT,AGE INTEGER,FEES INTEGER,DEPARTMENT TEXT,PHONE_NUMBER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fname, String lname, String age, String fees, String department,String phone_number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, fname);
        contentValues.put(COL_3, lname);
        contentValues.put(COL_4, age);
        contentValues.put(COL_5, fees);
        contentValues.put(COL_6, department);
        contentValues.put(COL_7, phone_number);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String fname, String lname, String age, String fees, String department,String phone_number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, fname);
        contentValues.put(COL_3, lname);
        contentValues.put(COL_4, age);
        contentValues.put(COL_5, fees);
        contentValues.put(COL_6, department);
        contentValues.put(COL_7, phone_number);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }
}
