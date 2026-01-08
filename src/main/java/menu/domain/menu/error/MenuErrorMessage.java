package menu.domain.menu.error;

public enum MenuErrorMessage {

    EXCLUDES_MENUS_RANGE_ERROR_MESSAGE("[ERROR] 못 먹는 음식은 0-2개여야 합니다."),
    NOT_EXISTS_MENU_ERROR_MESSAGE("[ERROR] 존재하는 메뉴가 아닙니다."),
    NO_DUPLICATE_MENU_ERROR_MESSAGE("[ERROR] 동일한 메뉴를 넣을 수 없습니다."),
    NO_MATCHING_MENU_ERROR_MESSAGE("[ERROR] 카테고리에 맞는 메뉴가 존재하지 않습니다.");

    private final String message;

    MenuErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
