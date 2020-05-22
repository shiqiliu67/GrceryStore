package com.junfan.grocerystore;

public class Staff {
    private int staffID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int streetNum;
    private String streetName;
    private int aptNum;
    private String city;
    private String state;
    private int zip;
    private double salary;
    private String job;

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setAptNum(int aptNum) {
        this.aptNum = aptNum;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getAptNum() {
        return aptNum;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public double getSalary() {
        return salary;
    }

    public String getJob() {
        return job;
    }
}
