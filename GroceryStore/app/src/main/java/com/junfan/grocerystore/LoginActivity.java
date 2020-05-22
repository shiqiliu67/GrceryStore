package com.junfan.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DatabaseHandler handler = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonClick(View view){
        //handler.insertStaff();
        EditText staffName = (EditText) findViewById(R.id.susername);
        EditText staffPass = (EditText) findViewById(R.id.spassword);
        String staffN = staffName.getText().toString();
        String staffP = staffPass.getText().toString();
        String passcode = handler.searchStaff(staffN);

        if(!staffP.equals(passcode)){
            Toast.makeText(this,"User name and password doesn't match", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, WarehouseActivity.class);
            startActivity(intent);
        }
    }
}

