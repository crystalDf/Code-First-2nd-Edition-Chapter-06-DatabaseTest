package com.star.databasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String DATABASE_BOOK_STORE = "BookStore.db";

    private MyDatabaseHelper mMyDatabaseHelper;
    private Button mCreateDatabaseButton;

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
    }
}
