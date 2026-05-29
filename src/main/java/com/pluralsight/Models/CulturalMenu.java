package com.pluralsight.Models;
//import list
import java.util.List;

public class CulturalMenu {
    //add lists for every type of premium and regular toppings
    private String base;
    //vegetarian
    private List<String> vegetarianPremiums;
    private List<String> vegetarianRegulars;

    //vegan
    private List<String> veganPremiums;
    private List<String> veganRegulars;

    //gluten free
    private List<String> glutenFreePremiums;
    private List<String> glutenFreeRegulars;

    //condiments
    private List<String> condiments;

    // funfacts
    private List<String> funFact;


    //add constructors


    public CulturalMenu(String base, List<String> vegetarianPremiums,
                        List<String> vegetarianRegulars, List<String> veganPremiums,
                        List<String> veganRegulars, List<String> glutenFreePremiums,
                        List<String> glutenFreeRegulars, List<String> condiments,
                        List<String> funFact) {
        this.base = base;
        this.vegetarianPremiums = vegetarianPremiums;
        this.vegetarianRegulars = vegetarianRegulars;
        this.veganPremiums = veganPremiums;
        this.veganRegulars = veganRegulars;
        this.glutenFreePremiums = glutenFreePremiums;
        this.glutenFreeRegulars = glutenFreeRegulars;
        this.condiments = condiments;
        this.funFact = funFact;
    }
}
