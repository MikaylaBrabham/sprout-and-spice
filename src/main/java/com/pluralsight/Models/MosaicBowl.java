package com.pluralsight.Models;

//import my bowlsize and culture themes
import com.pluralsight.Enums.BowlSize;
import com.pluralsight.Enums.CultureThemes;

//import arrays and stream
import java.util.ArrayList;
import java.util.stream.Collectors;

//create meals from menu class
public class MosaicBowl extends MenuItem{
    //add properties
    private BowlSize bowlSize;
    private CultureThemes cultureTheme;
    private ArrayList<MainSide> mainSides;
    private ArrayList<Toppings> toppings;
    private String signatureName;
    private boolean passportPowerUp;

    //add constructors

    public MosaicBowl(String name, BowlSize bowlSize, CultureThemes cultureTheme,
                      ArrayList<MainSide> mainSides, ArrayList<Toppings> toppings,
                      String signatureName, boolean passportPowerUp) {
        super("Mosaic Bowl");
        this.bowlSize = bowlSize;
        this.cultureTheme = cultureTheme;
        this.mainSides = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.signatureName = "Build Your Own Mosaic Bowl"; // <-- maybe add opt bring your own bowl for % off
        this.passportPowerUp = passportPowerUp;
    }

    //add signature mosaic bowl signature
    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
    }
    //add main sides and toppings to mosaic bowl
    public void addMainSides(MainSide mainSide) {
        mainSide.add(mainSides);
    }
    public void addToppings(Toppings topping) {
        topping.add(toppings);
    }

    //get price by overriding method
    @Override
    public double getPrice() {
        double toppingsTotalPrice = toppings.stream()
                .mapToDouble(topping -> topping.getPrice(bowlSize))
                .sum();

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
                : toppings.stream().map(toppings -> toppings.getMealDetails())
                .collect(Collectors.joining(",\t\n "));

        //get premium toppings
        long premiumToppingsCount = toppings.stream()
                .filter(Toppings :: isPremium).count();
        if(premiumToppingsCount > 0) {
            toppingList += "\nNote: " + premiumToppingsCount + " Premium Topping(s) Added!";
        }

        //add meal sides
        String mainSidesList = mainSides.isEmpty()
                ? "Your Main Side Selection is Empty"
                : mainSides.stream().map(MainSide::getMealDetails)
                .collect(Collectors.joining(",\t\n "));

        // add details and format  bowl size, culture theme, main sides, toppings, and passport power up
        return signatureName + "\n" +
                "Mosaic Bowl Size: " + bowlSize + "\n" +
                "Culture Theme: " + cultureTheme.getDisplayName() + "\n" +
                "Main Sides: " + mainSidesList + "\n" +
                "Toppings: " + toppingList + "\n" +
                "Premium Toppings: " + premiumToppingsCount + "\n" +
                "Passport Power Up: " + (passportPowerUp ? "Yes" : "No") + "\n";
    }
}
}
