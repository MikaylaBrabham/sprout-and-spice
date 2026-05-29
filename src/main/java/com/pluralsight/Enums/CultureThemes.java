package com.pluralsight.Enums;

public enum CultureThemes {
    //add different culture themes customers can choose from
    SOUTHERN_CAROLINA_LOWCOUNTRY("Southern Comfort Food"),
    YORUBA_NIGERIAN("Yoruba Nigerian Cuisine"),
    SALKEHATCHIE("Salkehatchie Cuisine"),
    SOUTH_INDIAN_GUJARATI("South Indian Gujarati Cuisine"),
    LEVANTINE_MEDITERRANEAN("Levantine Mediterranean Cuisine"),
    ITAL_CARIBBEAN("Ital Caribbean Cuisine"),
    OKINAWAN_JAPANESE("Okinawan Japanese Cuisine"),
    BRAZILIAN("Brazilian Cuisine"),
    DUTCH_CUISINE("Dutch Cuisine");

    private final String displayName;


    //add constructor for display name
    CultureThemes(String displayName) {
        this.displayName = displayName;
    }

    //add getter for display name
    public String getDisplayName() {
        return displayName;
    }
}
