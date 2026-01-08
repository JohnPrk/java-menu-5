package menu.domain.coach;

import java.util.List;

import static menu.domain.coach.error.CoachErrorMessage.FIVE_CREWS_UPPER_LIMIT_ERROR_MESSAGE;
import static menu.domain.coach.error.CoachErrorMessage.TWO_CREWS_NEEDED_ERROR_MESSAGE;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        sizeValidate(coaches);
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    private static void sizeValidate(List<Coach> coaches) {
        if (coaches.size() > 5) {
            throw new IllegalArgumentException(FIVE_CREWS_UPPER_LIMIT_ERROR_MESSAGE.getMessage());
        }
        if (coaches.size() < 2) {
            throw new IllegalArgumentException(TWO_CREWS_NEEDED_ERROR_MESSAGE.getMessage());
        }
    }
}
