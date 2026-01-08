package menu.domain.menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomCategorySelector implements CategorySelector {

    public List<String> select() {
        SelectedCategories selectedCategories = new SelectedCategories();
        while (!selectedCategories.isGreaterThanFive()) {
            int number = Randoms.pickNumberInRange(1, 5);
            selectedCategories.add(MenuCategoryFinder.findCategory(number));
        }
        return selectedCategories.getCategories();
    }
}
