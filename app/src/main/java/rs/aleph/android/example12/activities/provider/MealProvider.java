package rs.aleph.android.example12.activities.provider;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Category;
import rs.aleph.android.example12.activities.model.Ingredients;
import rs.aleph.android.example12.activities.model.Meal;

/**
 * Created by androiddevelopment on 30.1.18..
 */

public class MealProvider {

    public static List<Meal> getMeals() {

        Category sideDish = new Category(0, "Side dish");
        Category mainDish = new Category(1, "Main dish");
        Category dessert = new Category(2, "Dessert");

        Ingredients potato = new Ingredients(0, "potato");
        Ingredients carrot = new Ingredients(1, "carrot");
        Ingredients seasonalVegetables = new Ingredients(2, "seasonal vegetables");
        Ingredients peas = new Ingredients(3, "peas");
        Ingredients tomato = new Ingredients(4, "tomato");
        Ingredients chesse = new Ingredients(5, "cheese");
        Ingredients oliveOil = new Ingredients(6, "olive oil");
        Ingredients chickenMeat = new Ingredients(7, "chicken meat");
        Ingredients moustardDressing = new Ingredients(8, "moustard dressing");
        Ingredients fishMeat = new Ingredients(9, "fish meat");
        Ingredients chocolate = new Ingredients(10, "chocolate");
        Ingredients butter = new Ingredients(11, "butter");
        Ingredients nuts = new Ingredients(12, "nuts");
        Ingredients strawberies = new Ingredients(13, "strawberies");
        Ingredients roseberries = new Ingredients(14, "roseberies");
        Ingredients bisquits = new Ingredients(15, "bisquits");
        Ingredients milk = new Ingredients(16, "milk");

        List<Ingredients> vegetables = new ArrayList<>();
        vegetables.add(potato);
        vegetables.add(carrot);
        vegetables.add(seasonalVegetables);

        List<Ingredients> sallat = new ArrayList<>();
        sallat.add(peas);
        sallat.add(tomato);
        sallat.add(chesse);
        sallat.add(seasonalVegetables);
        sallat.add(oliveOil);

        List<Ingredients> chicken = new ArrayList<>();
        chicken.add(chickenMeat);
        chicken.add(seasonalVegetables);
        chicken.add(moustardDressing);

        List<Ingredients> salmon = new ArrayList<>();
        salmon.add(fishMeat);
        salmon.add(oliveOil);
        salmon.add(seasonalVegetables);

        List<Ingredients> chocolateCake = new ArrayList<>();
        chocolateCake.add(chocolate);
        chocolateCake.add(butter);
        chocolateCake.add(nuts);

        List<Ingredients> cheeseCake = new ArrayList<>();
        cheeseCake.add(strawberies);
        cheeseCake.add(roseberries);
        cheeseCake.add(chesse);
        cheeseCake.add(bisquits);
        cheeseCake.add(milk);


        List<Meal> meals = new ArrayList<>();

        meals.add(new Meal("roasted-baby-spring-vegetables-ck.jpg", "Vegetables", "Roasted spring vegetables",
                sideDish, vegetables, 320, 470.0));
        meals.add(new Meal("side-dish2.jpg", "Sallat", "Fresh vegetables",
                sideDish, sallat, 200, 370.0));
        meals.add(new Meal("grilledchickenbreast.jpg", "Grilled chicken breast", "Grilled chicken breast with wegetables and mustard dressing",
                mainDish, chicken, 730, 950.0));
        meals.add(new Meal("Grilled-Salmon.jpg", "Grilled salmon", "Grilled salmon fish with grilled vegetables",
                mainDish, salmon, 650, 1500.0));
        meals.add(new Meal("chocolat-cake.jpg", "Chocolat cake", "Crispy bark with chocolate cream",
                dessert, chocolateCake, 1000, 400.0));
        meals.add(new Meal("chese-cake.jpeg", "Cheese cake", "Fresh cake with strawberries, roseberries and milky cream",
                dessert, cheeseCake, 430, 370.0));



        return meals;
    }

    public static List<String> getMealNames() {

        List<String> names = new ArrayList<>();
        names.add("Vegetables");
        names.add("Sallat");
        names.add("Grilled chicken Breast");
        names.add("Grilled salmon");
        names.add("Chocolat cake");
        names.add("Cheese cake");

        return names;
    }

    public static Meal getMealById(int id) {
        List<Meal> meals = getMeals();

                return meals.get(id);

    }
}
