package com.pluralsight.Models;
//import list for menu items
import java.util.List;

public class CulturalMenu {

    //add properties
    private final List<String> bases;
    private final List<String> vegetarianPremiums;
    private final List<String> vegetarianRegulars;
    private final List<String> veganPremiums;
    private final List<String> veganRegulars;
    private final List<String> glutenFreePremiums;
    private final List<String> glutenFreeRegulars;

    private List<String> condiments;
    //private List<String> specialtyDrinks;
    //private List<String> funFacts) --



    //add constructor for menu items

    public CulturalMenu(List<String> bases, List<String> vegetarianPremiums, List<String> vegetarianRegulars, List<String> veganPremiums, List<String> veganRegulars,
                        List<String> glutenFreePremiums, List<String> glutenFreeRegulars) {
        this.bases = bases;
        this.vegetarianPremiums = vegetarianPremiums;
        this.vegetarianRegulars = vegetarianRegulars;
        this.veganPremiums = veganPremiums;
        this.veganRegulars = veganRegulars;
        this.glutenFreePremiums = glutenFreePremiums;
        this.glutenFreeRegulars = glutenFreeRegulars;
        //this.specialtyDrinks = specialtyDrinks;
            }

            //add getters for menu items
            public List<String> getBases () {
                return bases;
            }

            public List<String> getVegetarianPremiums () {
                return vegetarianPremiums;
            }

            public List<String> getVegetarianRegulars () {
                return vegetarianRegulars;
            }

            public List<String> getVeganPremiums () {
                return veganPremiums;
            }

            public List<String> getVeganRegulars () {
                return veganRegulars;
            }

            public List<String> getGlutenFreePremiums () {
                return glutenFreePremiums;
            }

            public List<String> getGlutenFreeRegulars () {
                return glutenFreeRegulars;
            }

            public List<String> getCondiments () {
                return condiments;


            //public List<String> getSpecialtyDrinks () {
               // return specialtyDrinks;
            }
        }

    //public List<String> getFunFacts() {
      //  return funFacts;

