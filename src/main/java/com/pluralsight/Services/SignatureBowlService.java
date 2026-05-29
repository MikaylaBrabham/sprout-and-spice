package com.pluralsight.Services;

//import my meals and toppings
import com.pluralsight.Enums.BowlSize;
import com.pluralsight.Enums.CultureThemes;
import com.pluralsight.Enums.ToppingType;
import com.pluralsight.Models.CulturalMenu;
import com.pluralsight.Models.MosaicBowl;
import com.pluralsight.Models.Toppings;

//import hashmap
import java.util.Map;

public class SignatureBowlService {

    //add strings
    private Map<CultureThemes, String> signatureBowls;
    private MenuServices menuServices;

    //add constructor
    public SignatureBowlService(MenuServices menuServices) {
        signatureBowls = signatureBowls;
        this.menuServices = menuServices;
        loadSignatureBowls();
    }

    //assign names for each signature bowl
    //trying not to make them sound corny
    private void loadSignatureBowls() {

        String southernComfortBowl = signatureBowls.put(CultureThemes.SOUTHERN_CAROLINA_LOWCOUNTRY, "Southern Comfort Bowl");// S.O MOM
        signatureBowls.put(CultureThemes.SALKEHATCHIE, "Low Country Bowl")// S.O GRANDMA
        signatureBowls.put(CultureThemes.YORUBA_NIGERIAN, "Joy Bowl"); // S.O MICHAEL
        signatureBowls.put(CultureThemes.SOUTH_INDIAN_TAMILIAN, "Golden Bowl"); // S.O SMITA
        signatureBowls.put(CultureThemes.LEVANTINE_MEDITERRANEAN, "Garden Bowl"); // S.O GABRIEL
        signatureBowls.put(CultureThemes.ITAL_CARIBBEAN, "Island Bowl"); // S.O KESIAH
        signatureBowls.put(CultureThemes.OKINAWAN_JAPANESE, "Purple Bowl");
        signatureBowls.put(CultureThemes.BRAZILIAN, "Rainbow Bowl");
        signatureBowls.put(CultureThemes.DUTCH_CUISINE, "Tulip Bowl");

    }
    //add mosaic bowl options to make own
    public MosaicBowl createSignatureBowl(CultureThemes theme, BowlSize bowlSize) {
        CulturalMenu menu = menuServices.getMenu(theme);

        //add mosaic bowl with size and theme
        MosaicBowl bowl = new MosaicBowl(bowlSize, theme, false);
        bowl.setSignatureName(getSignatureBowls(theme));
        //add base and toppings to signature bowl
        bowl.addToppings(new Toppings(menu.getVeganPremiums().get(0), ToppingType.VEGAN_PREMIUM_TOPPING, false));
        bowl.addToppings(new Toppings(menu.getVeganRegulars().get(0), ToppingType.VEGAN_REGULAR_TOPPING, false));
        bowl.addToppings(new Toppings(menu.getGlutenFreeRegulars().get(0), ToppingType.GLUTEN_FREE_REGULAR_TOPPING, false));
        bowl.addToppings(new Toppings(menu.getGlutenFreePremiums().get(0), ToppingType.GLUTEN_FREE_PREMIUM_TOPPING, false));
        bowl.addToppings(new Toppings(menu.getCondiments().get(0), ToppingType.CONDIMENTS, false));
        //bowl.setSignatureName(signatureBowls.get(theme));
        return bowl;
    }
    //return signature bowl name for specific culture theme
    public String getSignatureBowls(CultureThemes theme) {
        return signatureBowls.get(theme);
    }
}
