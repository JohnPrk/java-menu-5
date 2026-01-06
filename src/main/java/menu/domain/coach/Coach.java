package menu.domain.coach;

import menu.domain.menu.ExcludedMenus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static menu.domain.coach.error.CoachErrorMessage.NAME_RANGE_ERROR_MESSAGE;

public class Coach {

    private final String name;
    private ExcludedMenus excludedMenus;
    private Queue<String> weeklyMenus;
    private HashMap<String, Integer> categoryCount;

    public Coach(String name) {
        nameValidate(name);
        this.name = name;
        weeklyMenus = new LinkedList<>();
        categoryCount = new HashMap<>();
    }

    private void nameValidate(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(NAME_RANGE_ERROR_MESSAGE.getMessage());
        }
    }
}
