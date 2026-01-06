package menu.domain.menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static menu.domain.menu.error.MenuErrorMessage.*;

public class ExcludedMenus {

    private final List<String> menu;

    public ExcludedMenus(List<String> menu) {
        if (menu == null) {
            this.menu = new ArrayList<>();
            return;
        }
        sizeValidate(menu);
        duplicateValidate(menu);
        includeValidate(menu);
        this.menu = menu;
    }

    private void duplicateValidate(List<String> menu) {
        HashSet<String> menuList = new HashSet<>(menu);
        if (menuList.size() != menu.size()) {
            throw new IllegalArgumentException(NO_DUPLICATE_MENU_ERROR_MESSAGE.getMessage());
        }
    }

    private void includeValidate(List<String> excludedMenus) {
        boolean notExistsStatus = excludedMenus.stream()
                .anyMatch(AllMenu::notExists);
        if (notExistsStatus) {
            throw new IllegalArgumentException(NOT_EXISTS_MENU_ERROR_MESSAGE.getMessage());
        }
    }

    private void sizeValidate(List<String> excludedMenus) {
        if (excludedMenus.size() > 2) {
            throw new IllegalArgumentException(EXCLUDES_MENUS_RANGE_ERROR_MESSAGE.getMessage());
        }
    }
}
