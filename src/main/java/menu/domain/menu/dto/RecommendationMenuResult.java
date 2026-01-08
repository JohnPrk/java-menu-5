package menu.domain.menu.dto;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;

import java.util.List;

public class RecommendationMenuResult {

    private final List<Coach> coaches;
    private final List<String> categories;

    private RecommendationMenuResult(List<String> categories, Coaches coaches) {
        this.categories = categories;
        this.coaches = coaches.getCoaches();
    }

    public static RecommendationMenuResult from(List<String> categories, Coaches coaches) {
        return new RecommendationMenuResult(categories, coaches);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<String> getCategories() {
        return categories;
    }
}
