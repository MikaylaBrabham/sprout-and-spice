package com.pluralsight.Services;

//import my meals and toppings
import com.pluralsight.Enums.BowlSize;
import com.pluralsight.Enums.CultureThemes;
import com.pluralsight.Enums.ToppingType;
import com.pluralsight.Models.CulturalMenu;
import com.pluralsight.Models.MosaicBowl;
import com.pluralsight.Models.Toppings;

//import hashmap
import java.util.HashMap;
import java.util.Map;

public class SignatureBowlService {

    //add strings
    private Map<CultureThemes, MosaicBowl> signatureBowls;
    private MenuServices menuServices;

    //add constructor

    public SignatureBowlService(MenuServices menuServices) {
        signatureBowls = signatureBowls;
        this.menuServices = menuServices;
        loadSignatureBowls();
    }
}
