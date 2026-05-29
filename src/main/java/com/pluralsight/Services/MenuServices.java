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
    private Map<CultureThemes, CulturalMenu> menuMap;

    public MenuServices() {
        menuMap = new HashMap<>();
        loadMyMenu();
    }
}
}
