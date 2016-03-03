package com.myprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Veritabanı Versiyon
    private static final int DATABASE_VERSION = 1;
    // Veritabanı İsmi
    private static final String DATABASE_NAME = "mydb";
    //Tablo ismi
    static final String TABLE_NAME = "names";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //Veritabanındaki tablonun olusturulması icin kullanılacak metod
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DB_TABLE = " CREATE TABLE " + TABLE_NAME
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " name TEXT NOT NULL);";
        db.execSQL(CREATE_DB_TABLE);
    }
    //Cihazda aynı adda daha once kullanmış bir tablo varsa onu silip, yeni tabloyu olusturan metod
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
