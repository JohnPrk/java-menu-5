package menu.domain.coach;

import menu.domain.menu.ExcludedMenus;

import java.util.LinkedList;
import java.util.Queue;

import static menu.domain.coach.error.CoachErrorMessage.NAME_RANGE_ERROR_MESSAGE;

public class Coach {

    private final String name;
    private ExcludedMenus excludedMenus;
    private Queue<String> weeklyMenus;

    public Coach(String name, ExcludedMenus excludedMenus) {
        nameValidate(name);
        this.name = name;
        this.excludedMenus = excludedMenus;
        weeklyMenus = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Queue<String> getWeeklyMenus() {
        return weeklyMenus;
    }

    public boolean assignMenu(String menu) {
        if (isAlreadyAssign(menu)) return false;
        if (isExcludedMenu(menu)) return false;
        return weeklyMenus.add(menu);
    }

    private void nameValidate(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(NAME_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isExcludedMenu(String menu) {
        return excludedMenus.contains(menu);
    }

    private boolean isAlreadyAssign(String menu) {
        return weeklyMenus.contains(menu);
    }
}
