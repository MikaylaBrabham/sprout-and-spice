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
    //create menu options for Southern Comfort Food

    //create menu options for Salkahatchie


    // create menu options for South Indian Tamilian Cuisine
    //create menu options for Levantine Mediterranean Cuisine
    //create menu options for Ital Caribbean Cuisine
    //create menu options for Okinawan Japanese Cuisine
    //create menu options for Brazilian Cuisine
    //create menu options for Dutch Cuisine
    //create menu options for Yoruba Nigerian Cuisine
    ));


    //add a method to load menu
    public CulturalMenu getMenu(CultureThemes theme) {
        return menu.get(theme);
    }
}
