package com.junfan.grocerystore;

public class Warehouse {
    private int warehouseID;
    private String warehouseAddress;
    private int warehouseCapacity;

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public void setWarehouseCapacity(int warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public int getWarehouseCapacity() {
        return warehouseCapacity;
    }
}
