package com.junfan.grocerystore;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class ShopActivity extends AppCompatActivity {

    EditText search;
    TextView itemName;
    String item;
    EditText amount;
    TextView price;
    String pr;

    DatabaseHandler handler = new DatabaseHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        setTitle("4-twentyfive");
    }

    public void onSearch(View view){
        search = (EditText) findViewById(R.id.searchText);
        itemName = (TextView) findViewById(R.id.itemText);
        item = search.getText().toString();
        price = (TextView) findViewById(R.id.itemPrice);
        pr = handler.searchPrice(item);



        if(handler.searchItem(item) == true){
            itemName.setText(item);
            price.setText(pr);
        }else{
            itemName.setText("We couldn't find the item, maybe staff didn't put it in warehouse, sorry");
        }
    }

    public void onAddShoppingCart(View view){
        amount = (EditText) findViewById(R.id.itemAmount);
        int am = Integer.parseInt(amount.getText().toString());
        String am1 = amount.getText().toString();
        /*stringArrayList.add(item);
        intArrayList.add(am);
        priceArrayList.add(am * (Integer.parseInt(pr)));*/
        Order order = new Order();
        order.setOrder_item(item + "\t" + am1);
        //order.setOrder_amount(String.valueOf(am));
        //order.setOrder_total(String.valueOf(am * (Integer.parseInt(pr))));
        handler.insertOrder(order);
    }

    public void onShoppingCart(View view){
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

}
