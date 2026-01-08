package menu.domain.menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomCategorySelector implements CategorySelector {

    public List<String> select() {
        CategoryList categoryList = new CategoryList();
        while (!categoryList.isGreaterThanFive()) {
            int number = Randoms.pickNumberInRange(1, 5);
            categoryList.add(MenuCategoryFinder.findCategory(number));
        }
        return categoryList.getCategories();
    }
}
