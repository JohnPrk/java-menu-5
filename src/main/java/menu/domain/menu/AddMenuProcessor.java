package menu.domain.menu;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.dto.RecommendationMenuResult;

import java.util.List;

public class AddMenuProcessor {

    private final Coaches coaches;
    private final MenuSelector menuSelector;
    private final CategorySelector categorySelector;

    public AddMenuProcessor(Coaches coaches, MenuSelector menuSelector, CategorySelector categorySelector) {
        this.coaches = coaches;
        this.menuSelector = menuSelector;
        this.categorySelector = categorySelector;
    }

    public RecommendationMenuResult process() {
        List<String> categories = categorySelector.select();
        for (String category : categories) {
            for (Coach coach : coaches.getCoaches()) {
                addMenuFrom(category, coach);
            }
        }
        return RecommendationMenuResult.from(categories, coaches);
    }

    private void addMenuFrom(String category, Coach coach) {
        boolean addSuccessFlag = true;
        while (addSuccessFlag) {
            List<String> menus = menuSelector.selectBy(category);
            String menu = menus.get(0);
            if (coach.assignMenu(menu)) {
                addSuccessFlag = false;
            }
        }
    }
}
