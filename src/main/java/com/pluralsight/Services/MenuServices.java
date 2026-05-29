package com.pluralsight.Services;

//import my packages

import com.pluralsight.Enums.CultureThemes;
import com.pluralsight.Models.CulturalMenu;

//import hashmap, lists, and maps
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MenuServices {

    //add properties
    private Map<CultureThemes, CulturalMenu> menu;

    public MenuServices() {
        menu = new HashMap<>();
        loadMyMenu();
    }
    private void loadMyMenu() {
        //create menu options for Southern Comfort Food
        menu.put(CultureThemes.SOUTHERN_CAROLINA_LOWCOUNTRY, new CulturalMenu(
                List.of("Cornbread bites", "Collard Greens"),
                List.of("Fried Green Tomatoes", "Hush Puppies"),
                List.of("Vegan Jambalaya", "Red Beans and Rice"),
                List.of("Yellow Grits", "Vegan Shrimp"),
                        ""
                        , "Fried Chicken", "Shrimp and Grits"),

        ))

        //create menu options for Salkahatchie
        menu.put(CultureThemes.SALKEHATCHIE, new CulturalMenu



        //create menu options for Yoruba Nigerian Cuisine
        menu.put(CultureThemes.YORUBA_NIGERIAN, new CulturalMenu();
        // create menu options for South Indian Tamilian Cuisine
        menu.put(CultureThemes.SOUTH_INDIAN_TAMILIAN, new CulturalMenu());
        //create menu options for Levantine Mediterranean Cuisine
        menu.put(CultureThemes.LEVANTINE_MEDITERRANEAN, new CulturalMenu())
        //create menu options for Ital Caribbean Cuisine
        menu.put(CultureThemes.ITAL_CARIBBEAN, new CulturalMenu())
        //create menu options for Okinawan Japanese Cuisine
        menu.put(CultureThemes.OKINAWAN_JAPANESE, new CulturalMenu())
        //create menu options for Brazilian Cuisine
        menu.put(CultureThemes.BRAZILIAN, new CulturalMenu())
        //create menu options for Dutch Cuisine
        menu.put(CultureThemes.DUTCH_CUISINE, new CulturalMenu())


    }
    /
    ));


    //add a method to load menu
    public CulturalMenu getMenu(CultureThemes theme) {
        return menu.get(theme);
    }
}
