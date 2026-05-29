package com.pluralsight.UI;

//import my packages
import com.pluralsight.Enums.*;
import com.pluralsight.Models.*;
import com.pluralsight.Services.*;

//import list and scanners
import java.util.List;
import java.util.Scanner;
public class UserInterface {

    //add properties
    private Scanner myScanner;
    private MenuServices menuServices;
    private DrinkService drinkService;
    private SignatureBowlService signatureBowlService;
    private ReceiptManager receiptManager;

    //add constants for UI
    public UserInterface() {
        myScanner = new Scanner(System.in);
        menuServices = new MenuServices();
        drinkService = new DrinkService();
        signatureBowlService = new SignatureBowlService(menuServices);
        receiptManager = new ReceiptManager();
    }
    //add homescreen
    public void displayHomeScreen() {

        //add boolean to start loop
        boolean running = true;

        //create menu for home display screen
        while (running) {
            System.out.println("\n============================================");
            System.out.println("         Welcome to Sprout and Spice!    ");
            System.out.println("   Mosaic of Global Flavors in Every Bowl!   ");
            System.out.println("\n============================================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            //add scanner for user input
            String userChoice = myScanner.nextLine();

            //add switch case for user input
            switch (userChoice) {
                case "1" -> displayHomeScreen(new Order());
                case "0" -> {
                    running = false;
                    System.out.println("Thank You For Dining With Sprout & Spice!");}
                default -> System.out.println("Invalid, Please try again.");
            }
        }
    }
    //add order screen options
    private void displayOrderScreen(Order order) {
        boolean ordering = true;

        //add if statement to format order system newest -> oldest
        while (ordering) {
            if(!order.isEmpty()) {
                System.out.println("\nCurrent Order - Newest First:");
                System.out.println(order.getOrderDetailsAndFormat());
            }

        //add order screen menu for user to build their bowl and order or cancel
        while (ordering) {
            System.out.println("\n============================================");
            System.out.println("             ~ Order Screen ~                       ");
            System.out.println("         Build Your Mosaic Bowl!    ");
            System.out.println("   Choose from our Global Menu Options!   ");
            System.out.println("\n============================================");
            System.out.println("\n");
            System.out.println("\tPlease Select an Option:");
            System.out.println("1) Add a Signature Bowl");
            System.out.println("2) Add a Drink");
            System.out.println("3) Add a Main Side Dish");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            String userChoice = myScanner.nextLine();

            //options based off user choices
            switch (userChoice) {
                case "1"-> order.addMenuItem(displaySignatureBowls()).loadSignatureBowl(order);
                case "2" -> drinkService.displayDrinks(order);
                case "3" -> menuServices.displaySides(order);
                case "4" -> displayCurrentOrder(order);
                case "0" -> {ordering = false;
                    System.out.println("Your Order is Canceled, Returning to Home Screen.");
                }
                default: System.out.println("Invalid, Please try again.");
            }
        }
    }
private MosaicBowl buildCustomBowl() {
    //add bowl size menu options for user
    System.out.println("\n====== Choose Your Bowl Size =======");
    System.out.println("1) Sprout Bowl (Small)");
    System.out.println("2) Bloom Bowl (Medium)");
    System.out.println("3) Harvest Bowl (Large)");

    //add bowl size switch options for user input
    String bowlSizeChoice = myScanner.nextLine();
    BowlSize bowlSize = switch (bowlSizeChoice) {
        case "1" -> BowlSize.SPROUT;
        case "2" -> BowlSize.BLOOM;
        case "3" -> BowlSize.HARVEST;
        default -> {System.out.println("Invalid choice, defaulting to Sprout Bowl.");
            yield BowlSize.SPROUT;
        }///  The code I think I want to present on
    };

    //add culture theme options for user
    System.out.println("\nChoose Your Culture Theme:");
    List<CultureThemes> cultureThemesList = List.of(CultureThemes.values());
    for (int i = 0; i < cultureThemesList.size(); i++) {
        System.out.println((i + 1) + ") " + cultureThemesList.get(i));
    }

    String cultureThemeChoice = myScanner.nextLine();
    CultureThemes cultureTheme = switch (cultureThemeChoice) {
        case "1" -> CultureThemes.SALKEHATCHIE;
        case "2" -> CultureThemes.MEDITERRANEAN_MIX;
        case "3" -> CultureThemes.LATIN_FLAVOR;
        case "4" -> CultureThemes.MIDDLE_EASTERN_SPICE;
        default -> {
            System.out.println("Invalid choice, defaulting to Asian Fusion.");
            yield CultureThemes.ASIAN_FUSION;
        }
    };

    //add passport power up option for user
    System.out.println("\nWould you like to add the Passport Power-Up for $0.15? (Y/N)");
    String passportChoice = myScanner.nextLine();
    boolean passportPowerUp = passportChoice.equalsIgnoreCase("Y");

    return new MosaicBowl(bowlSize, cultureTheme, passportPowerUp);
}
