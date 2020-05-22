package com.junfan.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CongratActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrat);
        setTitle("Congratulations");
    }

    public void goToShop(View view){
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);
    }
}
