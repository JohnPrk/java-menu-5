package menu.view;

public class InputValidator {

    private static final String SEPARATOR_REGEX = "^[가-힣]+(,[가-힣]+)*$";
    private static final String SEPARATOR_REGEX_ERROR_MESSAGE = "[ERROR] 올바르지 않은 형식입니다.";

    public static void coachesValid(String coaches) {
        separatorRegexValid(coaches);
    }

    public static void menusValid(String menus) {
        if (menus == null || menus.isEmpty()) {
            return;
        }
        separatorRegexValid(menus);
    }

    private static void separatorRegexValid(String menus) {
        if (!menus.matches(SEPARATOR_REGEX)) {
            throw new IllegalArgumentException(SEPARATOR_REGEX_ERROR_MESSAGE);
        }
    }
}
