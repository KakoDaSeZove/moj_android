package rs.aleph.android.example12.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Category;

/**
 * Created by androiddevelopment on 30.1.18..
 */

public class CategoryProvider {

    public static List<Category> getCategories() {

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "Side dish"));
        categories.add(new Category(1, "Main dish"));
        categories.add(new Category(2, "Dessert"));
        return categories;
    }

    public static List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        names.add("Side dish");
        names.add("Main dish");
        names.add("Dessert");
        return names;
    }

    public static Category getCategoryById(int id) {
        switch (id) {
            case 0:
                return new Category(0, "Side dish");
            case 1:
                return new Category(1, "Main dish");
            case 2:
                return new Category(2, "Dessert");
            default:
                return null;
        }
    }
}
