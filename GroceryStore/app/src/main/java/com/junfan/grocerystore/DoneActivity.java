package com.junfan.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        setTitle("All done");
    }
}
