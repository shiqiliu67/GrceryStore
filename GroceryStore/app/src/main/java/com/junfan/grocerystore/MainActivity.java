package com.junfan.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHandler handler = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumpToRegister(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(View view){
        EditText username = (EditText) findViewById(R.id.lusername);
        EditText password = (EditText) findViewById(R.id.lpassword);
        String nameStr = username.getText().toString();
        String pass = password.getText().toString();
        String passcode = handler.searchPass(nameStr);
        if(!pass.equals(passcode)){
            Toast.makeText(this,"User name and password don't match", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this,ShopActivity.class);
            intent.putExtra("Username",nameStr);
            startActivity(intent);
        }
    }

    public void jumpToStaff(View view){
        Staff staff = new Staff();
        staff.setLastName("Fan");
        staff.setFirstName("Jun");
        staff.setUsername("jf0001");
        staff.setPassword("0001");
        handler.insertStaff(staff);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
