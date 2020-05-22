package com.junfan.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {

    DatabaseHandler handler = new DatabaseHandler(this);
    private EditText itemName;
    private EditText category;
    private EditText price;
    private EditText size;
    private EditText itemAmount;
    private EditText wareSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        setTitle("Modify product");
    }

    public void onAdd1(View view){
        itemName = (EditText) findViewById(R.id.item_name);
        category = (EditText) findViewById(R.id.item_category);
        price = (EditText) findViewById(R.id.item_price);
        size = (EditText) findViewById(R.id.item_size);
        itemAmount = (EditText) findViewById(R.id.item_amount);
        wareSave = (EditText) findViewById(R.id.warehouseSave);

        String in = itemName.getText().toString();
        String cat = category.getText().toString();
        double pr = Double.parseDouble(price.getText().toString());
        int s = Integer.parseInt(size.getText().toString());
        int ia = Integer.valueOf(itemAmount.getText().toString());
        int ws = Integer.valueOf(wareSave.getText().toString());

        Product product = new Product();
        product.setItemName(in);
        product.setCatefory(cat);
        product.setPrice(pr);
        product.setSize(s);
        product.setAmount(ia);
        //product.setWarehouseToSave(ws);
        if(handler.searchFruit(in) == false && handler.searchhouse(String.valueOf(ws))){
            Toast.makeText(this,"It has been added to this warehouse", Toast.LENGTH_SHORT).show();
        }else {
            handler.insertProduct(product);
            Toast.makeText(this, "Successfully Added", Toast.LENGTH_SHORT).show();
        }
    }

    public void onFinish2(View view){
        Intent intent = new Intent(this, FinishActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Finish all settings", Toast.LENGTH_SHORT).show();
    }

    public void onItemDel(View view){
        Toast.makeText(this,"This item has been deleted", Toast.LENGTH_SHORT).show();
    }
}
