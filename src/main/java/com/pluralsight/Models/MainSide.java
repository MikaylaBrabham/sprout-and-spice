package com.pluralsight.Models;

public class MainSide extends MenuItem {

    //add private string typing
    private String type;

    // add constructor for type
    public MainSide(String name, String type) {
        super(name);
        this.type = type;
    }
//add override for price and details

    @Override
    public double getPrice() {
        return 1.50;
    }

    //add overide for details and format
    @Override
    public String getMenuDetails() {
        return type + "Main Side Dish $" + String.format("%.2f", getPrice());
    }
}
