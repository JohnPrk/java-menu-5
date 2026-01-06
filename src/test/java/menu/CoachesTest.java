package menu;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static menu.domain.coach.error.CoachErrorMessage.FIVE_CREWS_UPPER_LIMIT_ERROR_MESSAGE;
import static menu.domain.coach.error.CoachErrorMessage.TWO_CREWS_NEEDED_ERROR_MESSAGE;

public class CoachesTest {

    private final Coach john = new Coach("john");
    private final Coach bill = new Coach("bill");
    private final Coach song = new Coach("song");
    private final Coach hoon = new Coach("hoon");
    private final Coach shin = new Coach("shin");
    private final Coach tom = new Coach("tom");

    private final List<Coach> coaches = List.of(john, bill);

    @Test
    public void 정상_범위의_인원을_가진_코치_리스트를_넣으면_코치들_객체를_생성할_수_있다() {
        Assertions.assertThat(new Coaches(coaches)).isExactlyInstanceOf(Coaches.class);
    }

    @Test
    public void 두_명_이하의_코치_리스트를_넣으면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Coaches(List.of(john)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TWO_CREWS_NEEDED_ERROR_MESSAGE.getMessage());
    }

    @Test
    public void 다섯_명_초과의_코치_리스트를_넣으면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Coaches(List.of(john, bill, song, hoon, tom, shin)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(FIVE_CREWS_UPPER_LIMIT_ERROR_MESSAGE.getMessage());
    }
}
