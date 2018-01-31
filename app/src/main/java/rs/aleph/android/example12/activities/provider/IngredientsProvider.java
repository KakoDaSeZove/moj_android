package rs.aleph.android.example12.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Ingredients;
import rs.aleph.android.example12.activities.model.Meal;

/**
 * Created by tijana on 31.1.18..
 */

public class IngredientsProvider {

    public static List<Ingredients> getIngredients() {

        List<Ingredients> ingredients = new ArrayList<>();
        ingredients.add(new Ingredients(0, "potato"));
        ingredients.add(new Ingredients(1, "carrot"));
        ingredients.add(new Ingredients(2, "seasonal vegetables"));
        ingredients.add(new Ingredients(3, "peas"));
        ingredients.add(new Ingredients(4, "tomato"));
        ingredients.add(new Ingredients(5, "cheese"));
        ingredients.add(new Ingredients(6,"olive oil"));
        ingredients.add(new Ingredients(7, "chicken meat"));
        ingredients.add(new Ingredients(8, "moustard dressing"));
        ingredients.add(new Ingredients(9, "fish meat"));
        ingredients.add(new Ingredients(10, "chocolate"));
        ingredients.add(new Ingredients(11, "butter"));
        ingredients.add(new Ingredients(12, "nuts"));
        ingredients.add(new Ingredients(13, "strawberies"));
        ingredients.add(new Ingredients(14, "roseberies"));
        ingredients.add(new Ingredients(15, "bisquits"));
        ingredients.add(new Ingredients(16, "milk"));

        return ingredients;
    }

    public static List<String> getIngredientsNames(Meal meal) {
        List<String> names = new ArrayList<>();

        for(Ingredients i : meal.getIngredients()){
            names.add(i.getName());
        }

        return names;
    }

    /*

        Meal vegetables = new Meal(0,"Vegetables");
        Meal sallat = new Meal(1, "Sallat");
        Meal chicken = new Meal(2, "Grilled chicken breast");
        Meal salmon = new Meal(3, "Grilled salmon");
        Meal chocolateCake = new Meal(4, "Chocolat cake");
        Meal chesseCake = new Meal(5, "Cheese cake");

        switch (id) {
            case 0:
                names.add("potato");
                names.add("carrot");
                names.add("seasonal vegetables");
                return names;
            case 1:
                names.add("peas");
                names.add("tomato");
                names.add("seasonal vegetables");
                names.add("cheese");
                names.add("olive oil");
                return names;
            case 2:
                names.add("chicken meat");
                names.add("seasonal vegetables");
                names.add("moustard dressing");
                return names;
            case 3:
                names.add("fish meat");
                names.add("seasonal vegetables");
                names.add("olive oil");
                return names;
            case 4:
                names.add("chocolate");
                names.add("butter");
                names.add("nuts");
                return names;
            case 5:
                names.add("strawberies");
                names.add("roseberies");
                names.add("bisquits");
                names.add("cheese");
                names.add("milk");
                return names;
            default:
                return null;
        }*/



    /*public static Ingredients getIngredientsById(int id) {
        switch (id) {
            case 0:
                return new Ingredients(0, "potato");
            case 1:
                return new Ingredients(1, "carrot");
            case 2:
                return new Ingredients(2, "seasonal vegetables");
            case 3:
                return new Ingredients(3, "peas");
            case 4:
                return new Ingredients(4, "tomato");
            case 5:
                return new Ingredients(5, "cheese");
            case 6:
                return new Ingredients(6, "olive oil");
            case 7:
                return new Ingredients(7, "chicken meat");
            case 8:
                return new Ingredients(8, "moustard dressing");
            case 9:
                return new Ingredients(9, "fish meat");
            case 10:
                return new Ingredients(10, "chocolate");
            case 11:
                return new Ingredients(11, "butter");
            case 12:
                return new Ingredients(12, "nuts");
            case 13:
                return new Ingredients(13, "strawberies");
            case 14:
                return new Ingredients(14, "roseberies");
            case 15:
                return new Ingredients(15, "bisquits");
            case 16:
                return new Ingredients(16, "milk");
            default:
                return null;
        }
    }*/
}


