package com.junfan.grocerystore;

public class Product {
    private String itemName;
    private String catefory;
    private int size;
    private double price;
    private int amount;
    private int warehouseToSave;

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCatefory(String catefory) {
        this.catefory = catefory;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWarehouseToSave(int warehouseToSave) {
        this.warehouseToSave = warehouseToSave;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCatefory() {
        return catefory;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public int getWarehouseToSave() {
        return warehouseToSave;
    }

    public int getAmount() {
        return amount;
    }
}
