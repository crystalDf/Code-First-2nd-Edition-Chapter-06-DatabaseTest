package com.star.databasetest;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String DATABASE_BOOK_STORE = "BookStore.db";

    private MyDatabaseHelper mMyDatabaseHelper;
    private Button mCreateDatabaseButton;
    private Button mInsertDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyDatabaseHelper = new MyDatabaseHelper(this, DATABASE_BOOK_STORE, null, 2);

        mCreateDatabaseButton = (Button) findViewById(R.id.create_database);
        mCreateDatabaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyDatabaseHelper.getWritableDatabase();
            }
        });

        mInsertDataButton = (Button) findViewById(R.id.insert_data);
        mInsertDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqLiteDatabase = mMyDatabaseHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();

                contentValues.put(MyDatabaseHelper.COLUMN_NAME, "The Da Vinci Code");
                contentValues.put(MyDatabaseHelper.COLUMN_AUTHOR, "Dan Brown");
                contentValues.put(MyDatabaseHelper.COLUMN_PAGES, 454);
                contentValues.put(MyDatabaseHelper.COLUMN_PRICE, 16.96);

                sqLiteDatabase.insert(MyDatabaseHelper.TABLE_BOOK, null, contentValues);

                contentValues.clear();

                contentValues.put(MyDatabaseHelper.COLUMN_NAME, "The Lost Symbol");
                contentValues.put(MyDatabaseHelper.COLUMN_AUTHOR, "Dan Brown");
                contentValues.put(MyDatabaseHelper.COLUMN_PAGES, 510);
                contentValues.put(MyDatabaseHelper.COLUMN_PRICE, 19.95);

                sqLiteDatabase.insert(MyDatabaseHelper.TABLE_BOOK, null, contentValues);

            }
        });
    }
}
