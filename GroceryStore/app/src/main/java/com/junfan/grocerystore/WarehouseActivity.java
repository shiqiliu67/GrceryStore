package com.junfan.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WarehouseActivity extends AppCompatActivity {

    private EditText wareID;
    private EditText wareAdd;
    private EditText wareCap;
    DatabaseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);

    }

    public void onAdd(View view){
        wareID = (EditText) findViewById(R.id.ware_id);
        wareAdd = (EditText) findViewById(R.id.ware_address);
        wareCap = (EditText) findViewById(R.id.ware_capacity);

        int ID = Integer.valueOf(wareID.getText().toString());
        String addr = wareAdd.getText().toString();
        int cap = Integer.valueOf(wareCap.getText().toString());

        Warehouse warehouse = new Warehouse();

        warehouse.setWarehouseID(ID);
        warehouse.setWarehouseAddress(addr);
        warehouse.setWarehouseCapacity(cap);

        handler = new DatabaseHandler(this);
        handler.insertWarehouse(warehouse);
        Toast.makeText(this, "Successfully Added", Toast.LENGTH_SHORT).show();
    }

    public void onFinish(View view){
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }
}
