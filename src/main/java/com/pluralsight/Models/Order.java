package com.pluralsight.Models;

//add in imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Order {
    //add array for menu
    private ArrayList<MenuItem> menuItems;

    //add array for order from
    public Order() {
        this.menuItems = new ArrayList<>();
    }

    //add menu item to order
    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    //add is empty method
    public boolean isEmpty() {
        return menuItems.isEmpty();
    }

    //add has bowl method to check if customer order has mosaic bowl
    public boolean hasBowl() {
        return menuItems.stream().anyMatch(menuItem -> menuItem instanceof MosaicBowl);
    }

    //add method to check if order has drink or side; if no bowl they must get both
    public boolean hasDrinkOrSideDish() {
        return menuItems.stream().anyMatch
                (menuItem -> menuItem instanceof Drinks || menuItem instanceof MainSide);
    }

    //add totalprice to get total
    public double getTotalPrice() {
        return menuItems.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    //add order details to get newest to oldest orders in the given format
    public String getOrderDetailsAndFormat() {
        //add array for menuitems
        ArrayList<MenuItem> reversedMenuItems = new ArrayList<>(menuItems);
        Collections.reverse(reversedMenuItems);

        //format order details and create output
        String orderDetails = reversedMenuItems.stream()
                .map(MenuItem::getMenuDetails)
                .collect(Collectors.joining("\n"));

        //basic ouptut for order details
        return """
                ======================================
                            SPROUT & SPICE
                            **Mosaic Meals**
                ======================================
                """ + orderDetails +
                "\n\nTotal: $" + String.format("%.2f", getTotalPrice()) +
                "\n\nThank you for dining with us!" +
                "\n===================================";
    }
}
