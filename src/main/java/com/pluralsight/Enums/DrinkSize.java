package com.pluralsight.Enums;

public enum DrinkSize {

    // drink sizes
    SMALL(1.00),
    MEDIUM(3.00),
    LARGE(5.00);

    private final double price;

    // constructor for price
    DrinkSize(double price) {
        this.price = price;
    }
    // getter for price
    public double getPrice() {
        return price;
    }
}
