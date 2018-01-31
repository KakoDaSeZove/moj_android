package rs.aleph.android.example12.activities.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by androiddevelopment on 27.1.18..
 */

public class Meal {
    private int id;
    private String image;
    private String name;
    private String description;
    private Category category;
    private List<Ingredients> ingredients;
    private int calories;
    private double price;

    public Meal() {
        ingredients = new ArrayList<>();

    }

    public Meal(int id, String name) {
        this.id = id;
        this.name = name;
        ingredients = new ArrayList<>();
    }

    public Meal(String image, String name, String description, Category category, List<Ingredients> ingredients, int calories, double price) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.category = category;
        this.ingredients = ingredients;
        this.calories = calories;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", ingredients=" + ingredients + '\'' +
                ", calories=" + calories + '\'' +
                ", price=" + price + '\'' +
                '}';
    }
}
