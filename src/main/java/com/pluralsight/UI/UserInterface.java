package com.pluralsight.UI;

// import my packages
import com.pluralsight.Enums.*;
import com.pluralsight.Models.*;
import com.pluralsight.Services.*;

// import list and scanner
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    // add properties
    private Scanner myScanner;
    private MenuServices menuServices;
    private DrinkService drinkService;
    private SignatureBowlService signatureBowlService;
    private ReceiptManager receiptManager;

    // add constructor
    public UserInterface() {
        myScanner = new Scanner(System.in);
        menuServices = new MenuServices();
        drinkService = new DrinkService();
        signatureBowlService = new SignatureBowlService(menuServices);
        receiptManager = new ReceiptManager();
    }

    // add home screen
    public void displayHomeScreen() {
        boolean running = true;

        while (running) {
            System.out.println("\n============================================");
            System.out.println("         Welcome to Sprout and Spice!");
            System.out.println("   Mosaic of Global Flavors in Every Bowl!");
            System.out.println("============================================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            String userChoice = myScanner.nextLine();

            switch (userChoice) {
                case "1":
                    displayOrderScreen(new Order());
                    break;
                case "0":
                    running = false;
                    System.out.println("Thank You For Dining With Sprout & Spice!");
                    break;
                default:
                    System.out.println("Invalid, please try again.");
            }
        }
    }

    // add order screen
    private void displayOrderScreen(Order order) {
        boolean ordering = true;

        while (ordering) {
            if (!order.isEmpty()) {
                System.out.println("\nCurrent Order - Newest First:");
                System.out.println(order.getOrderDetailsAndFormat());
            }

            System.out.println("\n============================================");
            System.out.println("              Order Screen");
            System.out.println("============================================");
            System.out.println("1) Add a Signature Bowl Item");
            System.out.println("2) Build Your Own Bowl Item");
            System.out.println("3) Add a Drink");
            System.out.println("4) Add a Main Side Dish");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            String userChoice = myScanner.nextLine();

            switch (userChoice) {
                case "1":
                    order.addMenuItem(displaySignatureBowls());
                    break;
                case "2":
                    order.addMenuItem(buildCustomBowl());
                    break;
                case "3":
                    drinkService.displayDrinks(order);
                    break;
                case "4":
                    menuServices.displaySides(order);
                    break;
                case "5":
                    displayCurrentOrder(order);
                    ordering = false;
                    break;
                case "0":
                    ordering = false;
                    System.out.println("Your order is canceled. Returning to home screen.");
                    break;
                default:
                    System.out.println("Invalid, please try again.");
            }
        }
    }

    // add signature bowl logic
    private MosaicBowl displaySignatureBowls() {
        System.out.println("\n====== Signature Bowls ======");

        List<CultureThemes> cultureThemesList = List.of(CultureThemes.values());

        for (int i = 0; i < cultureThemesList.size(); i++) {
            System.out.println((i + 1) + ") " + cultureThemesList.get(i).getDisplayName());
        }

        System.out.print("Choose a culture theme: ");
        int cultureChoice = Integer.parseInt(myScanner.nextLine());

        CultureThemes selectedTheme = cultureThemesList.get(cultureChoice - 1);

        BowlSize bowlSize = chooseBowlSize();

        return signatureBowlService.createSignatureBowl(selectedTheme, bowlSize);
    }

    // build custom bowl
    private MosaicBowl buildCustomBowl() {
        System.out.println("\n====== Build Your Own Bowl ======");

        BowlSize bowlSize = chooseBowlSize();

        System.out.println("\nChoose Your Culture Theme:");
        List<CultureThemes> cultureThemesList = List.of(CultureThemes.values());

        for (int i = 0; i < cultureThemesList.size(); i++) {
            System.out.println((i + 1) + ") " + cultureThemesList.get(i).getDisplayName());
        }

        System.out.print("Choose a culture theme: ");
        int cultureChoice = Integer.parseInt(myScanner.nextLine());

        CultureThemes cultureTheme = cultureThemesList.get(cultureChoice - 1);

        System.out.print("\nWould you like Passport Power-Up for $0.15? (Y/N): ");
        String passportChoice = myScanner.nextLine();

        boolean passportPowerUp = passportChoice.equalsIgnoreCase("Y");

        return new MosaicBowl(bowlSize, cultureTheme, passportPowerUp);
    }

    // choose bowl size
    private BowlSize chooseBowlSize() {
        System.out.println("\n====== Choose Your Bowl Size ======");
        System.out.println("1) Sprout Bowl (Small)");
        System.out.println("2) Bloom Bowl (Medium)");
        System.out.println("3) Harvest Bowl (Large)");
        System.out.print("Choose a size: ");

        String bowlSizeChoice = myScanner.nextLine();

        return switch (bowlSizeChoice) {
            case "1" -> BowlSize.SPROUT;
            case "2" -> BowlSize.BLOOM;
            case "3" -> BowlSize.HARVEST;
            default -> {
                System.out.println("Invalid choice, defaulting to Sprout Bowl.");
                yield BowlSize.SPROUT;
            }
        };
    }

    // checkout screen
    private void displayCurrentOrder(Order order) {
        if (order.isEmpty()) {
            System.out.println("Your order is empty. Please add something first.");
            return;
        }

        System.out.println("\n========== CHECKOUT ==========");
        System.out.println(order.getOrderDetailsAndFormat());

        System.out.println("1) Confirm Order");
        System.out.println("0) Cancel");
        System.out.print("Choose an option: ");

        String choice = myScanner.nextLine();

        switch (choice) {
            case "1":
                receiptManager.createReceipt(order);
                System.out.println("Receipt saved!");
                break;
            case "0":
                System.out.println("Order canceled. Returning to home screen.");
                break;
            default:
                System.out.println("Invalid.");
        }
    }
}