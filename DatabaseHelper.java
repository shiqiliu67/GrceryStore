
/**
 * Created by shiqiliu
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
/*
CREATE DATABASE grocery store;
CREATE TABLE User(
userID INT PRIMARY KEY,
first_name varchar(30),
last_name varchar(30),
street_number INT,
street_name varchar(256),
apt_number int,
city varchar (30),
state varchar (10),
zip number(10),
username varchar(30),
password varchar(30)
);
*/
    // Logcat tag
    private static final String LOG = DatabaseHelper.class.getName();
    //data base name
    public static String DATABASE_NAME = "GroceryStore";
    //data base version
    private static final int DATABASE_VERSION = 1;
    //table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_Staff = "staff";
    private static final String TABLE_Customer = "Customer";
    private static final String TABLE_Deliver_address = "Deliver Address";
    private static final String TABLE_Orders = "Orders";
    private static final String TABLE_Card = "card";
    private static final String TABLE_Product = "Product";
    private static final String TABLE_Price = "price";
    private static final String TABLE_Supplier = "Supplier";
    private static final String TABLE_Warehouse = "warehouse";
    private static final String TABLE_Stock = "Stock";
    private static final String TABLE_Type = "Type";
    // Common column names
    private static final String KEY_ID = "user_id";
    //user table colum;
    private static final String key_USER_first_name = "first name";
    private static final String key_USER_last_name = "last name";
    private static final String key_USER_street_number = "street number";
    private static final String key_USER_street_name = "street name";
    private static final String key_USER_apt_number = "apt number";
    private static final String key_USER_city = "city";
    private static final String key_USER_state = "state";
    private static final String key_USER_zip= "zip";
    private static final String key_USER_username = "user name";
    private static final String key_USER_password = "pass word";
        private static final String CREATE_TABLE_USER= "CREATE TABLE "
            + TABLE_USER + "("+KEY_ID+" Integer," 
                                + key_USER_first_name+" TEXT,"
                                +key_USER_last_name+" TEXT,"
                                + key_USER_username+" TEXT,"
                                +key_USER_password+" TEXT,"
                                + key_USER_street_number + " INTEGER,"
                                + key_USER_street_name + " TEXT, "
                                + key_USER_apt_number+" Integer,"
                                + key_USER_city+" TEXT,"
                                + key_USER_state+" TEXT,"
                                + key_USER_zip+" Integer,"    
                                +");";
/*
CREATE TABLE Staff(
staffID INT PRIMARY KEY,
salary INT,
job_title varchar(100)
);

CREATE TABLE Customer(
customerID INT PRIMARY KEY,
balance INT
);
*/
    //staff table:
    private static final String key_staff_salary = "salary";
    private static final String key_staff_job = "job_title";
        private static final String CREATE_TABLE_staff= "CREATE TABLE "
            + TABLE_Staff + "("+KEY_ID+" Integer," 
                                + key_staff_salary+" Double,"
                                + key_staff_job+" TEXT,"    
                                +");";
    //customer table:
    private static final String key_customer_balance = "balance";
        private static final String CREATE_TABLE_Customer= "CREATE TABLE "
            + TABLE_Customer + "("+KEY_ID+" Integer," 
                                + key_customer_balance+" Double," //will double be used?   
                                +");";
    //CREATE TABLE Delivery_address(
/*customer_id INT REFERENCES Customer,
name varchar(30),
street_number INT,
street_name varchar(256),
apt_number int,
city varchar (30),
state varchar (10),
zip number(10),
primary key (customer_id)
);

CREATE TABLE Orders(
orderID INT PRIMARY KEY,
customer_id INT REFERENCES Customer,
order_total INT
);
*/
    //delivery table:
    private static final String key_deliver_name = "name";
    private static final String key_deliver_street_number = "street number";
    private static final String key_deliver_street_name = "street name";
    private static final String key_deliver_apt_number = "apt number";
    private static final String key_deliver_city = "city";
    private static final String key_deliver_state = "state";
    private static final String key_deliver_zip= "zip";
    private static final String CREATE_TABLE_Deliver_address= "CREATE TABLE "
            + TABLE_Deliver_address + "("+KEY_ID+" Integer," 
                                + key_deliver_name+" TEXT,"
                                + key_deliver_street_number + " INTEGER,"
                                + key_deliver_street_name + " TEXT, "
                                + key_deliver_apt_number+" Integer,"
                                + key_deliver_city+" TEXT,"
                                + key_deliver_state+" TEXT,"
                                + key_deliver_zip+" Integer,"    
                                +");";
    //orders:
    private static final String key_orderID = "orderID";
    private static final String key_order_total = "order_total";
    private static final String CREATE_TABLE_Orders= "CREATE TABLE "
            + TABLE_Orders + "("+key_orderID+" Integer," 
                                +KEY_ID+" Integer,"
                                +key_order_total+" Integer," //ORDER total is int? based sql 
                                +");";
    /*
CREATE TABLE Card(
card_number number(20) PRIMARY KEY,
first_name varchar(30),
last_name varchar(30),
expiration date,
security_code number(10),
street_number INT,
street_name varchar(256),
apt_number int,
city varchar (30),
state varchar (10),
zip number(10)
);

CREATE TABLE Product(
item_name varchar(40) PRIMARY KEY,
category varchar(20),
size int check (sizes > 0)
);*/
//card table
    private static final String key_card_first_name = "first name";
    private static final String key_card_last_name = "last name";
    private static final String key_card_street_number = "street number";
    private static final String key_card_street_name = "street name";
    private static final String key_card_apt_number = "apt number";
    private static final String key_card_city = "city";
    private static final String key_card_state = "state";
    private static final String key_card_zip= "zip";
    private static final String key_card_number = "card_number";
    private static final String key_card_expiration_date = "expiration_date";
    private static final String key_card_security_code = "security_code";
            private static final String CREATE_TABLE_Card= "CREATE TABLE "
            + TABLE_card + "("+key_card_number+" Integer," 
                                + key_card_first_name+" TEXT,"
                                + key_card_last_name+" TEXT,"
                                + key_card_street_number + " INTEGER,"
                                + key_card_street_name + " TEXT, "
                                + key_card_apt_number+" Integer,"
                                + key_card_city+" TEXT,"
                                + key_card_state+" TEXT,"
                                + key_card_zip+" Integer,"
                                + key_scard_expiration_date+" TEXT,"// this date i choose string maybe numberic is better
                                + key_card_security_code+" Integer,"
                                
                                +");";
//product:
    private static final String key_product_item_name = "item_name";
    private static final String key_product_catagory = "catagory";
    private static final String key_product_size = "size";
            private static final String CREATE_TABLE_Product= "CREATE TABLE "
            + TABLE_Product + "("
                                + key_product_item_name+" TEXT,"
                                + key_product_catagory+" TEXT,"
                                + key_product_size+" Integer,"
                                +");";
/*
CREATE TABLE Price(
item_name varchar(40),
price numeric(5,0) check (price >= 0),
foreign key (item_name) references product
);

CREATE TABLE Supplier(
supplierID INT PRIMARY KEY,
item_name varchar(40),
first_name varchar(30),
last_name varchar(30),
street_number INT,
street_name varchar(256),
city varchar (30),
state varchar (10),
zip number(10),
price numeric(5,0) check (price >= 0),
foreign key (item_name) references Product,
foreign key (price) references Price
);
*/
//price table
    private static final String key_price_item_name = "item_name";
    private static final String key_price = "price";
        private static final String CREATE_TABLE_Price= "CREATE TABLE "
            + TABLE_Price + "(" + key_price_item_name+" TEXT,"
                                + key_price+" Integer,"
                                +");";
//supplier
    private static final String key_supplierId = "supplierID";
    private static final String key_supplier_item_name = "item_name";
    private static final String key_supplier_first_name = "first name";
    private static final String key_supplier_last_name = "last name";
    private static final String key_supplier_street_number = "street number";
    private static final String key_supplier_street_name = "street name";
    private static final String key_supplier_apt_number = "apt number";
    private static final String key_supplier_city = "city";
    private static final String key_supplier_state = "state";
    private static final String key_supplier_zip= "zip";
    private static final String key_supplier_price = "price";
        private static final String CREATE_TABLE_Supplier= "CREATE TABLE "
            + TABLE_Supplier + "("+key_supplierId+" Integer," 
                                + key_supplier_street_number + " INTEGER,"
                                + key_supplier_street_name + " TEXT, "
                                + key_supplier_apt_number+" Integer,"
                                + key_supplier_city+" TEXT,"
                                + key_supplier_state+" TEXT,"
                                + key_supplier_zip+" Integer,"
                                + key_supplier_item_name+" TEXT,"
                                + key_supplier_price+" Integer,"
                                + key_supplier_first_name+" TEXT,"
                                + key_supplier_last_name+" TEXT,"
                                +");";
/*
CREATE TABLE Warehouse(
warehouseID INT PRIMARY KEY,
item_name varchar(40),
street_number INT,
street_name varchar(256),
city varchar (30),
state varchar (10),
zip number(10),
capacity INT,
foreign key (item_name) references Product
);
*/  private static final String key_warehouseId = "warehouseID";
    private static final String key_warehouse_item_name = "item_name";
    private static final String key_warehouse_street_number = "street number";
    private static final String key_warehouse_street_name = "street name";
    private static final String key_warehouse_apt_number = "apt number";
    private static final String key_warehouse_city = "city";
    private static final String key_warehouse_state = "state";
    private static final String key_warehouse_zip= "zip";
    private static final String key_warehouse_capacity = "capacity";
    //create table
    private static final String CREATE_TABLE_Warehouse = "CREATE TABLE "
            + TABLE_Warehouse + "("+key_warehouseId+" Integer," 
                                + key_warehouse_street_number + " INTEGER,"
                                + key_warehouse_street_name + " TEXT, "
                                + key_warehouse_apt_number+" Integer,"
                                + key_warehouse_city+" TEXT,"
                                + key_warehouse_state+" TEXT,"
                                + key_warehouse_zip+" Integer,"
                                + key_warehouse_item_name+" TEXT,"
                                + key_warehouse_capacity+" Integer,"
                                +");";
//stock
    private static final String key_stock_item_name = "item_name";
    private static final String key_stock_street_number = "street number";
    private static final String key_stock_street_name = "street name";
    private static final String key_stock_apt_number = "apt number";
    private static final String key_stock_city = "city";
    private static final String key_stock_state = "state";
    private static final String key_stock_zip= "zip";
    private static final String key_stock_amount = "amount";
    //type;
    private static final String key_type_category = "category";
    private static final String key_type_item_name= "item_name";
    private static final String key_type_information = "information";
/*CREATE TABLE Stock(
street_number INT,
street_name varchar(256),
city varchar (30),
state varchar (10),
zip number(10),
item_name varchar(40) references Product,
amount INT
);

CREATE TABLE Type(
category varchar(20) PRIMARY KEY,
item_name varchar(40) references Product,
information varchar(265)
);
*/

    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_FIRSTNAME + " TEXT );";

    private static final String CREATE_TABLE_Stock = "CREATE TABLE "
            + TABLE_Stock + "(" + key_stock_street_number + " INTEGER,"
                                + key_stock_street_name + " TEXT "
                                + key_stock_apt_number+" Integer"
                                + key_stock_city+" TEXT"
                                + key_stock_state+" TEXT"
                                + key_stock_zip+" Integer"
                                + key_stock_item_name+" TEXT"
                                +");";

    private static final String CREATE_TABLE_Type = "CREATE TABLE "
            + TABLE_Type + "(" + key_type_category + " varchar,"
                               + key_type_item_name + " TEXT,"
                               +key_type_information+" TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_staff);
        db.execSQL(CREATE_TABLE_Customer);
        db.execSQL(CREATE_TABLE_Deliver_address);
        db.execSQL(CREATE_TABLE_Orders);
        db.execSQL(CREATE_TABLE_Card);
        db.execSQL(CREATE_TABLE_Product);
        db.execSQL(CREATE_TABLE_Price);
        db.execSQL(CREATE_TABLE_Supplier);
        db.execSQL(CREATE_TABLE_Warehouse);
        db.execSQL(CREATE_TABLE_Stock);
        db.execSQL(CREATE_TABLE_Type);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Staff + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Customer + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Deliver_address + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Orders + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_card + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Product + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Price + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Supplier+ "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Warehouse + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Stock + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Type + "'");
        onCreate(db);
    }

    // public void addUser(String first_name, String last_name , String ) {
    //     SQLiteDatabase db = this.getWritableDatabase();
    //     //adding user name in users table
    //     ContentValues values = new ContentValues();
    //     values.put(KEY_FIRSTNAME, name);
    //    // db.insert(TABLE_USER, null, values);
    //     long id = db.insertWithOnConflict(TABLE_USER, null, values, SQLiteDatabase.CONFLICT_IGNORE);

    //     //adding user hobby in users_hobby table
    //     ContentValues valuesHobby = new ContentValues();
    //     valuesHobby.put(KEY_ID, id);
    //     valuesHobby.put(KEY_HOBBY, hobby);
    //     db.insert(TABLE_USER_HOBBY, null, valuesHobby);

    //     //adding user city in users_city table
    //     ContentValues valuesCity = new ContentValues();
    //     valuesCity.put(KEY_ID, id);
    //     valuesCity.put(KEY_CITY, city);
    //     db.insert(TABLE_USER_CITY, null, valuesCity);
    // }

    // public ArrayList<UserModel> getAllUsers() {
    //     ArrayList<UserModel> userModelArrayList = new ArrayList<UserModel>();

    //     String selectQuery = "SELECT  * FROM " + TABLE_USER;
    //     SQLiteDatabase db = this.getReadableDatabase();
    //     Cursor c = db.rawQuery(selectQuery, null);
    //     // looping through all rows and adding to list
    //     if (c.moveToFirst()) {
    //         do {
    //             UserModel userModel = new UserModel();
    //             userModel.setId(c.getInt(c.getColumnIndex(KEY_ID)));
    //             userModel.setName(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));

    //                         //getting user hobby where id = id from user_hobby table
    //                       //  String selectHobbyQuery = "SELECT  * FROM " + TABLE_USER_HOBBY +" WHERE "+KEY_ID+" = "+ userModel.getId();
    //                        // Log.d("oppp",selectHobbyQuery);
    //                         //SQLiteDatabase dbhobby = this.getReadableDatabase();
    //                         Cursor cHobby = db.rawQuery(selectHobbyQuery, null);

    //                                     if (cHobby.moveToFirst()) {
    //                                         do {
    //                                             userModel.setHobby(cHobby.getString(cHobby.getColumnIndex(KEY_HOBBY)));
    //                                         } while (cHobby.moveToNext());
    //                                     }

    //                         //getting user city where id = id from user_city table
    //                         String selectCityQuery = "SELECT  * FROM " + TABLE_USER_CITY+" WHERE "+KEY_ID+" = "+ userModel.getId();;
    //                         //SQLiteDatabase dbCity = this.getReadableDatabase();
    //                         Cursor cCity = db.rawQuery(selectCityQuery, null);

    //                         if (cCity.moveToFirst()) {
    //                             do {
    //                                 userModel.setCity(cCity.getString(cCity.getColumnIndex(KEY_CITY)));
    //                             } while (cCity.moveToNext());
    //                         }

    //                 // adding to Students list
    //                 userModelArrayList.add(userModel);
    //             } while (c.moveToNext());
    //      }
    //     return userModelArrayList;
    // }

    public void updateUser(int id, String first_name, String last_name,String street_name, int street_number, String city, String state,int zip) {
        SQLiteDatabase db = this.getWritableDatabase();

        // updating name in users table
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
        db.update(TABLE_USER, values, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        // updating name in users_name table
        ContentValues valuesName = new ContentValues();
        valuesName.put(key_USER_first_name, first_name);
        valuesName.put(key_USER_last_name, last_name);
        db.update(TABLE_USER, valuesName, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        // updating city in users_adress table //might use arraylist
        ContentValues valuesAdress = new ContentValues();
        valuesAdress.put(key_USER_street_number,street_number);
        valuesAdress.put(key_USER_street_name,street_name);
        valuesAdress.put(key_USER_city,city);
        valuesAdress.put(key_USER_zip,zip);
        db.update(TABLE_USER, valuesAdress, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }
       //how to edit delete
    public void deleteUSer(int id) {

        // delete row in students table based on id
        SQLiteDatabase db = this.getWritableDatabase();

        //deleting from users table
        db.delete(TABLE_USER, KEY_ID + " = ?",new String[]{String.valueOf(id)});

        //deleting from users_hobby table
        db.delete(TABLE_USER_HOBBY, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        //deleting from users_city table
        db.delete(TABLE_USER_CITY, KEY_ID + " = ?",new String[]{String.valueOf(id)});
    }

}

