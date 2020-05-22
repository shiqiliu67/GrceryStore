package com.junfan.grocerystore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText password2;
    private EditText firstname;
    private EditText lastname;
    private EditText deliverAddress;
    DatabaseHandler handler = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("New User Register");
    }

    public void jumpToPaymentInfo(View view){
        username = findViewById(R.id.cUsername);
        password = findViewById(R.id.cPassword);
        password2 = findViewById(R.id.cfpassword);
        firstname = findViewById(R.id.cfirstname);
        lastname = findViewById(R.id.clastname);
        deliverAddress = findViewById(R.id.daddress);

        String nameStr = username.getText().toString();
        String pass = password.getText().toString();
        String pass2 = password2.getText().toString();
        String fn = firstname.getText().toString();
        String ln = lastname.getText().toString();
        String deliver = deliverAddress.getText().toString();
        //1234 S abc ave 2 Chicago IL 60616
        //String [] token = deliver.split(" ");
        if(handler.searchUser(nameStr) == false){
            Toast.makeText(this,"User name has been registered, try another one", Toast.LENGTH_SHORT).show();
        }else if(!pass.equals(pass2)){
            Toast.makeText(this, "Two passwords doesn't match", Toast.LENGTH_SHORT).show();
        }else {
            Customer cus = new Customer();
            cus.setUsername(nameStr);
            cus.setPassword(pass);
            cus.setFirstName(fn);
            cus.setLastName(ln);
            cus.setAddress(deliver);

            handler.insertCustomer(cus);

            Staff staff = new Staff();
            staff.setUsername("jf0001");
            staff.setPassword("0001");
            staff.setFirstName("Jun");
            staff.setLastName("Fan");

            handler.insertStaff(staff);
            Intent intent = new Intent(this, PayinfoActivity.class);
            startActivity(intent);
        }
    }


}
