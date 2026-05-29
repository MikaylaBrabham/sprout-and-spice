package com.pluralsight.Services;

//import my packages
import com.pluralsight.Enums.CultureThemes;

//import hashmap, lists, and maps
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MenuServices {

    //add properties
    private Map<CultureThemes, List<String>> culturalBases;

    private Map<CultureThemes, List<String>> funFacts;

    //add constructors
    public MenuServices() {
        cultureIngredients = new HashMap<>();
        funFacts = new HashMap<>();
    }
}
