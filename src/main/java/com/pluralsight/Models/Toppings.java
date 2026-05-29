package com.pluralsight.Models;

//import topping types and bowl sizes
import com.pluralsight.Enums.ToppingType;
import com.pluralsight.Enums.BowlSize;


public class Toppings {
    //add properties
    private String name;
    private ToppingType toppingType;
    private boolean anyExtras;


    //add constructors
    public Toppings(String name, ToppingType toppingType, boolean anyExtras) {
        this.name = name;
        this.toppingType = toppingType;
        this.anyExtras = anyExtras;
    }

    //add getters
    public ToppingType getType() {
        return toppingType;
    }

    //add premium options for toppings
    public boolean isPremium() {
        return toppingType == ToppingType.VEGETARIAN_PREMIUM_TOPPING ||
               toppingType == ToppingType.VEGAN_PREMIUM_TOPPING ||
               toppingType == ToppingType.GLUTEN_FREE_PREMIUM_TOPPING;
    }
    // get bowl prices
    public double getPrice(BowlSize bowlSize) {
        // premium toppings cost more = more unhealthy
        // regular toppings cost less = healthier option
        if (!isPremium()) {
            return 0;
        }
        // create switch to display menu items with premium prices
        double mosaicBowlPrice = switch (bowlSize) {
            case SPROUT -> 1.00;
            case BLOOM -> 1.75;
            case HARVEST -> 2.75;
        };

        //add switch options for extras
        // low rate because want to encourage healthy intuitive eating
        if (anyExtras) {
            mosaicBowlPrice += switch (bowlSize) {
                case SPROUT -> 0.50;
                case BLOOM -> 0.75;
                case HARVEST -> 1.00;
            };
        }
        return mosaicBowlPrice;
    }


    //output for the different options
    public String getMealDetails() {
        return name + " " + (isPremium() ? "Premium Options: " : "Regular Options: ") + "-" + toppingType;
    }
}

