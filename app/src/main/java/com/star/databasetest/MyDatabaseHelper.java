package com.star.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_BOOK = "book";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_PAGES = "pages";
    public static final String COLUMN_NAME = "name";

    public static final String CREATE_BOOK = "create table " + TABLE_BOOK + " (" +
            COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_AUTHOR + " text, " +
            COLUMN_PRICE + " real " +
            COLUMN_PAGES + " integer, " +
            COLUMN_NAME + " text" +
            ")";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_BOOK);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
