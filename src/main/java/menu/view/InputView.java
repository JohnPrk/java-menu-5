package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.menu.ExcludedMenus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_COACHES_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_EXCLUDED_MENUS_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.%n";

    public static List<String> inputCoachesName() {
        System.out.println(INPUT_COACHES_NAME_MESSAGE);
        String coachesName = Console.readLine();
        InputValidator.coachesValid(coachesName);
        System.out.println();
        return Arrays.stream(coachesName.split(",")).collect(Collectors.toList());
    }

    public static ExcludedMenus inputExcludedMenus(String name) {
        System.out.printf(INPUT_EXCLUDED_MENUS_MESSAGE, name);
        String excludedMenus = Console.readLine();
        InputValidator.menusValid(excludedMenus);
        List<String> menuList = Arrays.stream(excludedMenus.split(",")).collect(Collectors.toList());
        System.out.println();
        return new ExcludedMenus(menuList);
    }
}
