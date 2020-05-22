package com.junfan.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        setTitle("Check out");
    }

    public void onSetted(View view){
        Intent intent = new Intent(this,DoneActivity.class);
        startActivity(intent);
    }

    public void onDelete(View view){
        Toast.makeText(this,"Your payment info has been deleted",Toast.LENGTH_LONG).show();
    }

    public void onReplace(View view){
        Intent intent = new Intent(this, PayinfoActivity.class);
        startActivity(intent);
    }

}
