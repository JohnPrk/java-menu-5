package menu.domain.coach.error;

public enum CoachErrorMessage {

    NAME_RANGE_ERROR_MESSAGE("[ERROR] 이름은 2~4글자여야 합니다."),
    FIVE_CREWS_UPPER_LIMIT_ERROR_MESSAGE("[ERROR] 코치는 최대 5명 이내로 입력해야 합니다."),
    TWO_CREWS_NEEDED_ERROR_MESSAGE("[ERROR] 코치는 최소 2명 이상으로 입력해야 합니다.");

    private final String message;

    CoachErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
