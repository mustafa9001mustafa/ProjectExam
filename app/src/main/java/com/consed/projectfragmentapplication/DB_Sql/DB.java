package com.consed.projectfragmentapplication.DB_Sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sql";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "val";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String AGE_COLUMN = "age";

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                ID_COLUMN + " INTEGER PRIMARY KEY, " +
                NAME_COLUMN + " TEXT, " +
                AGE_COLUMN + " INTEGER)";
        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    SQLiteDatabase sql_db;


    public void openDB() {
        sql_db = getWritableDatabase();
    }

    public void closeDB() {
        if (sql_db != null) {
            sql_db.close();
        }
    }

    public void insertData(Val val) {
        SQLiteDatabase db = getWritableDatabase();
        String insertQuery = "INSERT INTO " + TABLE_NAME + " (" + NAME_COLUMN + ", " + AGE_COLUMN + ") " +
                "VALUES ('" + val.getName() + "', " + val.getAge() + ")";
        db.execSQL(insertQuery);
        db.close();
    }

    public void deleteData(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, ID_COLUMN + "=?", new String[]{String.valueOf(id)});
        db.close();
    }


    public ArrayList<Val> SelectData() {
        ArrayList<Val> allContacts = new ArrayList<>();

        Cursor C = sql_db.rawQuery("select * from "+TABLE_NAME, null);

        while (C.moveToNext()) {
            int id = C.getInt(0);
            String name = C.getString(1);
            int age = C.getInt(2);
            allContacts.add(new Val(id, name, age));
        }

        return allContacts;
    }

}
