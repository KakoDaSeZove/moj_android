package rs.aleph.android.example12.activities.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tijana on 28.1.18..
 */

public class Category {

     private int id;
     private String name;
     private List<Meal> meals;

     public Category(){
          meals = new ArrayList<>();
     }

     public Category(int id, String name) {

          this.id = id;
          this.name = name;

          meals = new ArrayList<>();
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public List<Meal> getMeals() {
          return meals;
     }

     public void setMeals(List<Meal> meals) {
          this.meals = meals;
     }
}
