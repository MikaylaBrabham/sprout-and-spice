package com.pluralsight.Services;

//import my culture theme

//import hashmaps, list, and map
import com.pluralsight.Enums.CultureThemes;
import com.pluralsight.Models.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrinkService {

    //add list to hold fountain drink options
    private List<String> regularDrinkOptions;
    private Map<CultureThemes, String> specialtyDrinkOptions;

    //create list of regular soda options = super overpriced to motivate healthy choices
    //off brand like shasta
    public DrinkService() {
        regularDrinkOptions = List.of(
                "Sprite", "Coke", "Diet Coke", "Dr. Pepper",
                "Fanta", "Mountain Dew",//issss for youuu!
                "Pepsi", "Root Beer", "Ginger Ale", "Orange Soda"
        );

        //create hashmap of speciality drink options for each culture theme
        specialtyDrinkOptions = new HashMap<>();

        //add new specialty drinks
        specialtyDrinkOptions.put(CultureThemes.SOUTHERN_CAROLINA_LOWCOUNTRY,"Citrus Mint Iced Tea");
        specialtyDrinkOptions.put(CultureThemes.YORUBA_NIGERIAN,"Mango Zobo Berry Cooler");
        specialtyDrinkOptions.put(CultureThemes.SALKEHATCHIE,"Peach Hibiscus Tea");
        specialtyDrinkOptions.put(CultureThemes.SOUTH_INDIAN_TAMILIAN,"Mango Rose Tea");
        specialtyDrinkOptions.put(CultureThemes.LEVANTINE_MEDITERRANEAN,"Mint Pomegranate Lemonade");
        specialtyDrinkOptions.put(CultureThemes.ITAL_CARIBBEAN,"Pineapple Coconut Ginger Tea");
        specialtyDrinkOptions.put(CultureThemes.OKINAWAN_JAPANESE,"Purple Vanilla Blended Tea");
        specialtyDrinkOptions.put(CultureThemes.BRAZILIAN,"Acai Lime Refresher");
        specialtyDrinkOptions.put(CultureThemes.DUTCH_CUISINE,"Dutch Apple Spice Tea");

    }

    //get list of regular drinks
    public List<String> getRegularDrinkOptions() {
        return regularDrinkOptions;
    }

    //get list of specialty theme
    public Map<CultureThemes, String>  getSpecialtyDrinks() {
       return specialtyDrinkOptions;
    }

    // get specialty drink options for a specific culture theme
    public String getSpecialtyDrinkOptions(CultureThemes theme) {
        return specialtyDrinkOptions.get(theme);
    }

    public void displayDrinks(Order order) {
    }
}

