package menu.domain.menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomMenuSelector implements MenuSelector {

    @Override
    public List<String> selectBy(String category) {
        List<String> menus = MenuCategoryFinder.findMenu(category);
        return Randoms.shuffle(menus);
    }
}
