package com.junfan.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PayinfoActivity extends AppCompatActivity {

    private EditText firstname;
    private EditText lastname;
    private EditText cardNumber;
    private EditText cvv;
    private EditText expiration;
    DatabaseHandler handler = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payinfo);
        setTitle("Payment Information");
    }

    public void jumpToProfile(View view){
        firstname = (EditText) findViewById(R.id.pfirstname);
        lastname = (EditText) findViewById(R.id.plastname);
        cardNumber = (EditText) findViewById(R.id.pcardnumber);
        cvv = (EditText) findViewById(R.id.cvv);
        expiration = (EditText) findViewById(R.id.expiration);

        String fn = firstname.getText().toString();
        String ln = lastname.getText().toString();
        String cn = cardNumber.getText().toString();
        int cv = Integer.parseInt(cvv.getText().toString());
        String exp = expiration.getText().toString();

        Card card = new Card();
        card.setFirstName(fn);
        card.setLastName(ln);
        card.setCardNumber(cn);
        card.setCvv(cv);
        card.setExpiration(exp);

        handler.insertCard(card);

        Intent intent = new Intent(this, CongratActivity.class);
        startActivity(intent);
    }
}
