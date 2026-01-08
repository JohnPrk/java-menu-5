package menu.domain.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryList {

    private final List<String> categories;
    private final HashMap<String, Integer> categoryCount;

    public CategoryList() {
        this.categories = new ArrayList<>();
        this.categoryCount = new HashMap<>();
    }

    public List<String> getCategories() {
        return categories;
    }

    public boolean isGreaterThanFive() {
        return categories.size() >= 5;
    }

    public void add(String category) {
        if (isOverCategoryCountLimit(category)) {
            return;
        }
        categories.add(category);
        categoryCount.putIfAbsent(category, 0);
        categoryCount.replace(category, categoryCount.get(category) + 1);
    }

    private boolean isOverCategoryCountLimit(String category) {
        return categoryCount.getOrDefault(category, 1) > 2;
    }
}
