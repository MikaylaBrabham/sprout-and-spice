package com.pluralsight.Enums;

public enum BowlSize {

    // different bowl sizes with prices

    //small = sprout
    SPROUT(5.00),

    //medium = bloom
    BLOOM(8.00),
    //large = harvest
    HARVEST(10.00);

    private final double BasePrice;

    //add constructor for baseprice

    BowlSize(double basePrice) {
        BasePrice = basePrice;
    }
    //add getter for baseprice

    public double getBasePrice() {
        return BasePrice;
    }
}
