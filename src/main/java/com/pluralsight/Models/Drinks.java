package com.pluralsight.Models;


 import com.pluralsight.Enums.DrinkSize;
 import com.pluralsight.Enums.DrinkType;
 import com.pluralsight.Enums.CultureThemes;

public class Drinks extends MenuItem {

    //add properties
    private DrinkSize drinkSize;
    private String flavor;
    private DrinkType drinkType;
    private CultureThemes cultureTheme;

    //add constructors
    public Drinks(String name, DrinkSize drinkSize, String flavor, DrinkType drinkType, CultureThemes cultureTheme) {
        super("Drink");
        this.drinkSize = drinkSize;
        this.flavor = flavor;
        this.drinkType = drinkType;
        this.cultureTheme = cultureTheme;
    }

    //add methods
    @Override
    public double getPrice() {
        double total = drinkSize.getPrice();

        //add price for specialty drinks which cost a dollar more than regular tea blends
        if (drinkType == DrinkType.CULTURAL_SPECIALTY_DRINKS) {
            // add $.50 for specialty drinks
            total += .50;
        }
        //price for regular sodas
        if (drinkType == DrinkType.REGULAR_SODA) {
            // add $2.50 for regular fountain drink sodas (cost more to drink unhealthy >:) )
            total += 2.50;
        }
        return total;
    }

    @Override
    public String getMenuDetails() {
        String cultureDetails = switch (cultureTheme) {
            case SALKEHATCHIE -> "Peach hibiscus sweet tea inspired by the flavors of the Salkehatchie region.";
            case SOUTHERN_CAROLINA_LOWCOUNTRY ->
                    "A bright fruit tea inspired by the vibrant flavors of the Southern Carolina Lowcountry, featuring a blend of citrus and berries.";
            case SOUTH_INDIAN_TAMILIAN ->
                    "Experience the rich flavors of South India with our mango rose tea inspired by warm spices and floral notes.";
            case YORUBA_NIGERIAN ->
                    "Enjoy our ginger and hibiscus drink called Zobo which is a fan favorite all around Nigeria.";
            case LEVANTINE_MEDITERRANEAN ->
                    "Experience the vibrant and refreshing flavors of the Mediterranean with our mnit pomegranate lemonade, crafted out o fresh herbs and citrus.";
            case ITAL_CARIBBEAN ->
                    "Indulge in the bold and vibrant flavors of the Caribbean with our Ital-themed pineapple coconut ginger tea.";
            case OKINAWAN_JAPANESE ->
                    "Experience the unique flavors of Okinawa with our purple vanilla blended tea, which is heavily influenced by the traditional Okinawan purple sweet potato and infused with a hint of vanilla for a delightful twist.";
            case BRAZILIAN ->
                    "Discover the vibrant and diverse flavors of Brazil with our acai lime refresher heavily infused with tropical fruits.";
            case DUTCH_CUISINE ->
                    "Discover the unique flavors of Dutch cuisine with our D cinnamon apple rooibos tea inspired by the traditional Dutch apple pie.";
            default ->
                    "Our drink menu features a variety of options, including regular sodas and cultural specialty drinks. ";
        };
        //add drink output details with price
        return drinkSize + " " + flavor + " " + drinkType + " inspired by " + cultureTheme.getDisplayName() + "$ " + String.format("%.2f", getPrice()) + "\n";

    }
}
