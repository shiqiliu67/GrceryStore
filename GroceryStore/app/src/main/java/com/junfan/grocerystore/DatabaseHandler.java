package com.junfan.grocerystore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    public static String DATABASE_NAME = "GroceryStore";
    private static final String TABLE_Staff = "staff";
    private static final String TABLE_Customer = "Customer";
    private static final String TABLE_Deliver_address = "DeliverAddress";
    private static final String TABLE_Orders = "Orders";
    private static final String TABLE_Card = "card";
    private static final String TABLE_Product = "Product";
    private static final String TABLE_Price = "price";
    private static final String TABLE_Supplier = "Supplier";
    private static final String TABLE_Warehouse = "warehouse";
    private static final String TABLE_Stock = "Stock";
    private static final String TABLE_Type = "Type";

    private static final String KEY_ID = "user_id";

    private static final String key_Customer_first_name = "first_name";
    private static final String key_Customer_last_name = "last_name";
    /*private static final String key_USER_street_number = "street_number";
    private static final String key_USER_street_name = "street_name";
    private static final String key_USER_apt_number = "apt_number";
    private static final String key_USER_city = "city";
    private static final String key_USER_state = "state";
    private static final String key_USER_zip = "zip";*/
    private static final String key_Customer_username = "username";
    private static final String key_Customer_password = "password";

    private static final String key_staff_first_name = "first_name";
    private static final String key_staff_last_name = "last_name";
    private static final String key_staff_salary = "salary";
    private static final String key_staff_job = "job_title";
    private static final String key_staff_deliver = "deliver_address";
    private static final String key_staff_username = "username";
    private static final String key_staff_password = "password";

    SQLiteDatabase db;

    private static final String CREATE_TABLE_staff = "CREATE TABLE "
            + TABLE_Staff + "(" + KEY_ID + " Integer,"
            + key_staff_first_name + " TEXT,"
            + key_staff_last_name + " TEXT,"
            + key_staff_username + " TEXT,"
            + key_staff_password + " TEXT,"
            + key_staff_deliver + " TEXT,"
            + key_staff_salary + " Double,"
            + key_staff_job + " TEXT);";

    private static final String key_customer_balance = "balance";
    private static final String key_customer_deliver = "deliver_address";

    private static final String CREATE_TABLE_Customer = "CREATE TABLE "
            + TABLE_Customer + "(" + KEY_ID + " Integer,"
            + key_Customer_first_name + " TEXT,"
            + key_Customer_last_name + " TEXT,"
            + key_Customer_username + " TEXT,"
            + key_Customer_password + " TEXT,"
            + key_customer_deliver + " Text,"
            + key_customer_balance + " Double);";

    private static final String key_deliver_name = "name";
    private static final String key_deliver_street_number = "street_number";
    private static final String key_deliver_street_name = "street_name";
    private static final String key_deliver_apt_number = "apt_number";
    private static final String key_deliver_city = "city";
    private static final String key_deliver_state = "state";
    private static final String key_deliver_zip = "zip";
    private static final String key_deliver_address = "deliver_address";
    private static final String CREATE_TABLE_Deliver_address = "CREATE TABLE "
            + TABLE_Deliver_address + "(" + KEY_ID + " Integer,"
            + key_deliver_name + " TEXT,"
            /*+ key_deliver_street_number + " INTEGER,"
            + key_deliver_street_name + " TEXT, "
            + key_deliver_apt_number + " Integer,"
            + key_deliver_city + " TEXT,"
            + key_deliver_state + " TEXT,"
            + key_deliver_zip + " Integer*/
            + key_deliver_address + " TEXT);";

    //private static final String key_orderID = "orderID";
    //private static final String key_order_total = "order_total";
    private static final String key_order_item = "order_item";
    //private static final String key_order_amount = "order_amount";
    private static final String CREATE_TABLE_Orders = "CREATE TABLE "
            + TABLE_Orders + "("
            + key_order_item + " TEXT);";
            //+ key_order_amount + " TEXT,"
            //+ key_order_total + " TEXT);";

    private static final String key_card_first_name = "first_name";
    private static final String key_card_last_name = "last_name";
    private static final String key_card_street_number = "street_number";
    private static final String key_card_street_name = "street_name";
    private static final String key_card_apt_number = "apt_number";
    private static final String key_card_city = "city";
    private static final String key_card_state = "state";
    private static final String key_card_zip = "zip";
    private static final String key_card_number = "card_number";
    private static final String key_card_expiration_date = "expiration_date";
    private static final String key_card_security_code = "security_code";

    private static final String CREATE_TABLE_Card = "CREATE TABLE "
            + TABLE_Card + "(" + key_card_number + " TEXT,"
            + key_card_first_name + " TEXT,"
            + key_card_last_name + " TEXT,"
            /*+ key_card_street_number + " INTEGER,"
            + key_card_street_name + " TEXT, "
            + key_card_apt_number + " Integer,"
            + key_card_city + " TEXT,"
            + key_card_state + " TEXT,"
            + key_card_zip + " Integer,"*/
            + key_card_expiration_date + " TEXT,"// this date i choose string maybe numberic is better
            + key_card_security_code + " Integer);";

    private static final String key_product_item_name = "item_name";
    private static final String key_product_catagory = "catagory";
    private static final String key_product_size = "size";
    private static final String key_product_price = "price";
    private static final String key_product_amount = "amount";

    private static final String CREATE_TABLE_Product = "CREATE TABLE "
            + TABLE_Product + "("
            + key_product_item_name + " TEXT,"
            + key_product_catagory + " TEXT,"
            + key_product_price + " TEXT,"
            + key_product_amount + " TEXT,"
            + key_product_size + " TEXT);";

    /*private static final String key_price_item_name = "item_name";
    private static final String key_price = "price";

    private static final String CREATE_TABLE_Price = "CREATE TABLE "
            + TABLE_Price + "(" + key_price_item_name + " TEXT,"
            + key_price + " Integer);";*/

    private static final String key_supplierId = "supplierID";
    private static final String key_supplier_item_name = "item_name";
    private static final String key_supplier_first_name = "first_name";
    private static final String key_supplier_last_name = "last_name";
    private static final String key_supplier_street_number = "street_number";
    private static final String key_supplier_street_name = "street_name";
    private static final String key_supplier_apt_number = "apt_number";
    private static final String key_supplier_city = "city";
    private static final String key_supplier_state = "state";
    private static final String key_supplier_zip = "zip";
    private static final String key_supplier_price = "price";

    private static final String CREATE_TABLE_Supplier = "CREATE TABLE "
            + TABLE_Supplier + "(" + key_supplierId + " Integer,"
            + key_supplier_street_number + " INTEGER,"
            + key_supplier_street_name + " TEXT, "
            + key_supplier_apt_number + " Integer,"
            + key_supplier_city + " TEXT,"
            + key_supplier_state + " TEXT,"
            + key_supplier_zip + " Integer,"
            + key_supplier_item_name + " TEXT,"
            + key_supplier_price + " Integer,"
            + key_supplier_first_name + " TEXT,"
            + key_supplier_last_name + " TEXT);";

    private static final String key_warehouseId = "warehouseID";
    private static final String key_warehouse_item_name = "item_name";
    private static final String key_warehouse_street_number = "street_number";
    private static final String key_warehouse_street_name = "street_name";
    private static final String key_warehouse_apt_number = "apt_number";
    private static final String key_warehouse_city = "city";
    private static final String key_warehouse_state = "state";
    private static final String key_warehouse_zip = "zip";
    private static final String key_warehouse_addr = "address";
    private static final String key_warehouse_capacity = "capacity";
    private static final String key_warehouse_stock = "stock";
    //create table
    private static final String CREATE_TABLE_Warehouse = "CREATE TABLE "
            + TABLE_Warehouse + " ("
            + key_warehouseId + " TEXT,"
            + key_warehouse_addr + " TEXT,"
            //+ key_warehouse_item_name + " TEXT,"
            //+ key_warehouse_stock + " TEXT,"
            + key_warehouse_capacity + " TEXT);";

    private static final String key_stock_item_name = "item_name";
    private static final String key_stock_street_number = "street_number";
    private static final String key_stock_street_name = "street_name";
    private static final String key_stock_apt_number = "apt_number";
    private static final String key_stock_city = "city";
    private static final String key_stock_state = "state";
    private static final String key_stock_zip = "zip";
    private static final String key_stock_amount = "amount";
    //type;
    private static final String key_type_category = "category";
    private static final String key_type_item_name = "item_name";
    private static final String key_type_information = "information";

    private static final String CREATE_TABLE_Stock = "CREATE TABLE "
            + TABLE_Stock + "(" /*+ key_stock_street_number + " INTEGER,"
            + key_stock_street_name + " TEXT,"
            + key_stock_city + " TEXT,"
            + key_stock_state + " TEXT,"
            + key_stock_zip + " Integer,"*/
            + key_stock_amount + " TEXT,"
            + key_stock_item_name + " TEXT);";

    private static final String CREATE_TABLE_Type = "CREATE TABLE "
            + TABLE_Type + "(" + key_type_category + " varchar,"
            + key_type_item_name + " TEXT,"
            + key_type_information + " TEXT);";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_staff);
        db.execSQL(CREATE_TABLE_Customer);
        db.execSQL(CREATE_TABLE_Deliver_address);
        db.execSQL(CREATE_TABLE_Orders);
        db.execSQL(CREATE_TABLE_Card);
        db.execSQL(CREATE_TABLE_Product);
        //db.execSQL(CREATE_TABLE_Price);
        db.execSQL(CREATE_TABLE_Supplier);
        db.execSQL(CREATE_TABLE_Warehouse);
        db.execSQL(CREATE_TABLE_Stock);
        db.execSQL(CREATE_TABLE_Type);
    }

    public void insertCustomer(Customer customer){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "SELECT * FROM " + TABLE_Customer + ";";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(KEY_ID, String.valueOf(count));
        values.put(key_Customer_first_name, customer.getFirstName());
        values.put(key_Customer_last_name, customer.getLastName());
        values.put(key_Customer_username, customer.getUsername());
        values.put(key_Customer_password, customer.getPassword());
        values.put(key_customer_deliver, customer.getAddress());

        db.insert(TABLE_Customer, null, values);
        //db.close();
    }

    public void insertStaff(Staff staff){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(key_Customer_first_name, staff.getFirstName());
        values.put(key_staff_last_name, staff.getLastName());
        values.put(key_staff_username, staff.getUsername());
        values.put(key_staff_password, staff.getPassword());

        db.insert(TABLE_Staff, null, values);
        //db.close();
    }

    public void insertCard(Card card){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(key_card_first_name, card.getFirstName());
        values.put(key_card_last_name, card.getLastName());
        values.put(key_card_number, card.getCardNumber());
        values.put(key_card_security_code, card.getCvv());
        values.put(key_card_expiration_date, card.getExpiration());

        db.insert(TABLE_Card, null, values);
        //db.close();
    }

    public void insertWarehouse(Warehouse warehouse){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(key_warehouseId, String.valueOf(warehouse.getWarehouseID()));
        values.put(key_warehouse_capacity, String.valueOf(warehouse.getWarehouseCapacity()));
        values.put(key_warehouse_addr, warehouse.getWarehouseAddress());

        db.insert(TABLE_Warehouse, null, values);
        //db.close();
    }

    public void insertProduct(Product product){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(key_product_item_name, product.getItemName());
        values.put(key_product_catagory, product.getCatefory());
        values.put(key_product_size, String.valueOf(product.getSize()));
        values.put(key_product_price, String.valueOf(product.getPrice()));
        //values.put(key_stock_item_name, product.getItemName());
        //values.put(key_stock_amount, String.valueOf(product.getAmount()));

        db.insert(TABLE_Product, null, values);
        //db.close();
    }

    public void insertOrder(Order order){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(key_order_item, order.getOrder_item());
        //values.put(key_order_amount, order.getOrder_amount());
        //values.put(key_order_total, order.getOrder_total());

        db.insert(TABLE_Orders, null, values);
    }

    public String searchStaff(String sname){
        db = getReadableDatabase();
        String query = "SELECT username, password FROM " + TABLE_Staff + ";";
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "NOT FOUND";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(sname)){
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }

    public String searchPass(String uname){
        db = this.getReadableDatabase();
        String query = "SELECT username, password FROM " + TABLE_Customer + ";";
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "NOT FOUND";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    public boolean searchUser(String uname){
        db = this.getReadableDatabase();
        String query = "SELECT username FROM " + TABLE_Customer + ";";
        Cursor cursor = db.rawQuery(query,null);
        String b = "";
        boolean a= true;
        if(cursor.moveToFirst()){
            do{
                b = cursor.getString(0);
                if(b.equals(uname)){
                    a = false;
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return a;
    }

    public boolean searchFruit(String itemName){
        db = this.getReadableDatabase();
        String query = "SELECT item_name FROM " + TABLE_Product + ";";
        Cursor cursor = db.rawQuery(query,null);
        String b = "";
        boolean a= true;
        if(cursor.moveToFirst()){
            do{
                b = cursor.getString(0);
                if(b.equals(itemName)){
                    a = false;
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return a;
    }

    public boolean searchhouse(String wareName){
        db = this.getReadableDatabase();
        String query = "SELECT warehouseID FROM " + TABLE_Warehouse + ";";
        Cursor cursor = db.rawQuery(query,null);
        String b = "";
        boolean a= true;
        if(cursor.moveToFirst()){
            do{
                b = cursor.getString(0);
                if(b.equals(wareName)){
                    a = false;
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return a;
    }

    public Cursor getListContents(){
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_Warehouse + ";";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public Cursor getListContents2(){
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_Product + ";";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public boolean searchItem(String item){
        db = this.getReadableDatabase();
        String query = "SELECT item_name FROM " + TABLE_Product + ";";
        Cursor cursor = db.rawQuery(query, null);
        boolean a = false;
        String b = "";
        if(cursor.moveToFirst()){
            do{
                b = cursor.getString(0);
                if(b.equals(item)){
                    a = true;
                    break;
                }
            }while(cursor.moveToNext());
        }
        return a;
    }

    public String searchPrice(String item){
        db = this.getReadableDatabase();
        String query = "SELECT item_name, price FROM " + TABLE_Product + ";";
        Cursor cursor = db.rawQuery(query,null);
        String b = "";
        String a = "";
        if(cursor.moveToFirst()){
            do{
                b = cursor.getString(0);
                a = cursor.getString(1);
                if(b.equals(item)){
                    return a;
                }
            }while(cursor.moveToNext());
        }
        return a;
    }

    public Cursor viewOrder(){
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_Orders + ";";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Staff + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Customer + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Deliver_address + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Orders + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Card + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Product + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Price + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Supplier + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Warehouse + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Stock + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Type + "'");
        onCreate(db);
    }
}
