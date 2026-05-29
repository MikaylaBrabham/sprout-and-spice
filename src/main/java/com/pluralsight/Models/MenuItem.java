package com.pluralsight.Models;

public abstract class MenuItem {

    //get name
    private String name;

    // add constructor for name
    public MenuItem(String name) {
        this.name = name;
    }

    //add getter for name
    public String getName() {
        return name;
    }

    // add abstract method for price and details
    public abstract double getPrice();
    public abstract String getMenuDetails();

    public abstract void setBase(String s);
}
