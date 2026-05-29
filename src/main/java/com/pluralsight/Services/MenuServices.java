package com.pluralsight.Services;

//import my packages

import com.pluralsight.Enums.CultureThemes;
import com.pluralsight.Models.CulturalMenu;
import com.pluralsight.Models.Order;

//import hashmap, lists, and maps
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MenuServices {

    //add properties
    private final Map<CultureThemes, CulturalMenu> menu;

    //add new hashmap and load menu
    public MenuServices() {
        menu = new HashMap<>();
        loadMyMenu();
    }

    private void loadMyMenu() {

        // Southern Carolina Lowcountry
        menu.put(CultureThemes.SOUTHERN_CAROLINA_LOWCOUNTRY, new CulturalMenu(
                // vegetarian regular
                List.of("Yellow Grits", "Cornbread Bites", "Collard Greens"),
                // vegetarian premium
                List.of("Fried Green Tomatoes", "Sweet Potato Hash"),
                // vegan regular
                List.of("Red Beans and Rice", "Okra Stew", "Cabbage Mix"),
                // vegan premium
                List.of("Vegan Jambalaya", "Smoked Mushroom BBQ"),
                // gluten free regular
                List.of("Rice Pilaf", "Black Eyed Peas"),
                // gluten free premium
                List.of("Cajun Sweet Potato Bowl", "Herbed Garlic Veggies"),
                // condiments
                List.of("Maple Glaze", "Hot Sauce", "Garlic Herb Sauce"),
                // specialty drinks
                List.of("Peach Rooibos Tea", "Berry Sweet Tea Cooler")));

        // Salkahatchie Indigenous Inspired
        menu.put(CultureThemes.SALKEHATCHIE, new CulturalMenu(

                List.of("Wild Rice", "Roasted Corn"),
                List.of("Stuffed Squash Boats", "Maple Roasted Root Vegetables"),
                List.of("Bean Stew", "Sunflower Seed Bowl"),
                List.of("Wild Berry Harvest Bowl", "Smoked Cedar Veggies"),
                List.of("Roasted Potatoes", "Corn Cakes"),
                List.of("Ancient Grain Bowl", "Maple Seed Crunch"),
                List.of("Berry Sauce", "Herb Oil"),
                List.of("Berry Harvest Cooler", "Maple Mint Tea")));

        // Yoruba Nigerian Cuisine
        menu.put(CultureThemes.YORUBA_NIGERIAN, new CulturalMenu(

                List.of("Jollof Rice", "Plantains", "Vegetable Rice"),
                List.of("Yam Fritters", "Egusi Veggie Mix"),
                List.of("Bean Stew", "Pepper Rice"),
                List.of("Vegan Jollof Bowl", "Spicy Coconut Chickpeas"),
                List.of("Rice", "Roasted Yam"),
                List.of("Pepper Veggie Bowl", "Cassava Crisps"),
                List.of("Pepper Sauce", "Tomato Stew"),
                List.of("Mango Zobo Cooler", "Pineapple Ginger Hibiscus Tea")));

        // South Indian Tamilian Cuisine
        menu.put(CultureThemes.SOUTH_INDIAN_TAMILIAN, new CulturalMenu(

                List.of("Turmeric Rice", "Vegetable Curry", "Lentils"),
                List.of("Masala Potatoes", "Paneer Inspired Veggies"),
                List.of("Chickpea Curry", "Coconut Rice"),
                List.of("Golden Curry Bowl", "Spiced Lentil Bowl"),
                List.of("Rice Cakes", "Roasted Chickpeas"),
                List.of("Coconut Curry Veggies", "Spiced Rice Bowl"),
                List.of("Mint Chutney", "Mango Chutney"),
                List.of("Mango Rose Cooler", "Cardamom Vanilla Tea")));

        // Levantine Mediterranean
        menu.put(CultureThemes.LEVANTINE_MEDITERRANEAN, new CulturalMenu(

                List.of("Falafel", "Hummus", "Cucumber Salad"),
                List.of("Stuffed Grape Leaves", "Herbed Couscous"),
                List.of("Lentil Bowl", "Roasted Eggplant"),
                List.of("Falafel Garden Bowl", "Tahini Chickpea Bowl"),
                List.of("Rice Pilaf", "Roasted Cauliflower"),
                List.of("Mediterranean Salad", "Tahini Herb Bowl"),
                List.of("Tahini Sauce", "Garlic Yogurt Sauce"),
                List.of("Mint Pomegranate Cooler", "Lemon Rose Tea")));

        // Ital Caribbean
        menu.put(CultureThemes.ITAL_CARIBBEAN, new CulturalMenu(

                List.of("Plantains", "Rice and Peas", "Callaloo"),
                List.of("Coconut Veggie Stew", "Sweet Pepper Bowl"),
                List.of("Bean Curry", "Island Veggie Mix"),
                List.of("Ital Rainbow Bowl", "Coconut Curry Bowl"),
                List.of("Rice", "Roasted Cassava"),
                List.of("Island Harvest Bowl", "Jerk Veggie Bowl"),
                List.of("Pineapple Sauce", "Ginger Lime Sauce"),
                List.of("Pineapple Ginger Cooler", "Coconut Berry Tea")));

        // Okinawan Japanese
        menu.put(CultureThemes.OKINAWAN_JAPANESE, new CulturalMenu(

                List.of("Purple Sweet Potato", "Rice", "Sesame Vegetables"),
                List.of("Miso Glazed Veggies", "Tofu Rice Cakes"),
                List.of("Seaweed Rice Bowl", "Vegetable Soup"),
                List.of("Purple Power Bowl", "Tofu Garden Bowl"),
                List.of("Rice Noodles", "Sweet Potato Cubes"),
                List.of("Sesame Veggie Bowl", "Ginger Rice Bowl"),
                List.of("Sesame Sauce", "Ginger Soy Glaze"),
                List.of("Purple Sweet Potato Smoothie", "Berry Matcha-Free Tea")));

        // Brazilian Cuisine
        menu.put(CultureThemes.BRAZILIAN, new CulturalMenu(
                List.of("Rice", "Black Beans", "Collard Greens"),
                List.of("Cassava Fries", "Brazilian Veggie Bowl"),
                List.of("Coconut Rice", "Plantain Mix"),
                List.of("Rio Rainbow Bowl", "Spiced Bean Bowl"),
                List.of("Roasted Cassava", "Herbed Rice"),
                List.of("Citrus Veggie Bowl", "Cassava Crunch Bowl"),
                List.of("Cilantro Lime Sauce", "Garlic Citrus Sauce"),
                List.of("Acai Berry Cooler", "Lime Coconut Tea")));

        // Dutch Cuisine
        menu.put(CultureThemes.DUTCH_CUISINE, new CulturalMenu(
                List.of("Potatoes", "Red Cabbage", "Pea Soup"),
                List.of("Vegetable Stamppot", "Mushroom Ragout"),
                List.of("Vegetable Stew", "Herbed Rice"),
                List.of("Dutch Harvest Bowl", "Mushroom Veggie Bowl"),
                List.of("Roasted Potatoes", "Braised Red Cabbage"),
                List.of("Cabbage Veggie Bowl", "Potato Herb Bowl"),
                List.of("Mustard Sauce", "Garlic Herb Sauce"),
                List.of("Dutch Apple Spice Cooler", "Berry Cinnamon Tea")));
    }


    //add a method to load menu
    public CulturalMenu getMenu(CultureThemes cultureTheme) {
        return menu.get(cultureTheme);
    }

    public void displaySides(Order order) {
    }
}






