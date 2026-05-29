package com.pluralsight.Models;

//import my bowlsize and culture themes
import com.pluralsight.Enums.BowlSize;
import com.pluralsight.Enums.CultureThemes;

//import arrays and stream
import java.util.stream.Collectors;
import java.util.ArrayList;

//create meals from menu class
public abstract class MosaicBowl extends MenuItem{
    //add properties
    private final BowlSize bowlSize;
    private final CultureThemes cultureTheme;
    private String base;
    private final ArrayList<Toppings> toppings;
    private String signatureName;
    private final boolean passportPowerUp;

    //add constructors

    public MosaicBowl(BowlSize bowlSize, CultureThemes cultureTheme, boolean passportPowerUp) {
        super("Mosaic Bowl");
        this.bowlSize = bowlSize;
        this.cultureTheme = cultureTheme;
        this.passportPowerUp = passportPowerUp;
        this.toppings = new ArrayList<>();
        this.signatureName = "Build Your Own Mosaic Bowl";
    }
    // maybe add opt bring your own bowl for %10-15 off
    //add signature mosaic bowl signature
    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
    }
    //add main sides and toppings to mosaic bowl
    public void addToppings(Toppings topping) {
        toppings.add(topping);
    }

    //get price by overriding method
    @Override
    public double getPrice() {
        double toppingsTotalPrice = toppings.stream()
                .mapToDouble(topping -> topping.getPrice(bowlSize)).sum();


        //passportpower up is an extra 15cents to instill knowledge about  using paper materials
        // opens up the door for reduce reuse recycle and composting education
        //returns the total of mosaic bowl -- can only get passportbadge with food purchase
        return bowlSize.getBasePrice() + toppingsTotalPrice + (passportPowerUp ? 0.15: 0);
    }

    @Override
    public String getMenuDetails() {
        //if no toppings selcted return a message
        String toppingList = toppings.isEmpty()
                ? "Your Topping Selection is Empty"
                : toppings.stream()
                .map(Toppings::getMealDetails)
                .collect(Collectors.joining(",\t\n "));

        //get premium toppings
        long premiumToppingsCount = toppings.stream()
                .filter(Toppings::isPremium).count();

        if (premiumToppingsCount > 0) {
            toppingList += "\nNote: " + premiumToppingsCount + " Premium Topping(s) Added!";
        }

        // add details and format  bowl size, culture theme, main sides, toppings, and passport power up
        return signatureName + "\n" +
                "Mosaic Bowl Size: " + bowlSize + "\n" +
                "Culture Theme: " + cultureTheme.getDisplayName() + "\n" +
                "Base: " + base + "\n" +
                "Toppings: " + toppingList + "\n" +
                "Premium Toppings: " + premiumToppingsCount + "\n" +
                "Passport Power Up: " + (passportPowerUp ? "Yes" : "No") + "\n" +
                "Price: $" + String.format("%.2f", getPrice()) + "\n";
    }
}

