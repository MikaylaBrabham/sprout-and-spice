package com.pluralsight.Models;

public class MainSide extends MenuItem {

    //add private string typing
    private String sideType;

    // add constructor for type
    public MainSide(String sideType) {
        super("Main Side");
        this.sideType = sideType;
    }
//add override for price and details
    @Override
    public double getPrice() {
        return 1.50;
    }

    //add overide for details and format
    @Override
    public String getMenuDetails() {
        return sideType + "Main Side Dish $" + String.format("%.2f", getPrice());
    }

    @Override
    public void setBase(String s) {

    }
}
