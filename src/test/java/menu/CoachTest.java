package menu;

import menu.domain.coach.Coach;
import menu.domain.menu.ExcludedMenus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static menu.domain.coach.error.CoachErrorMessage.NAME_RANGE_ERROR_MESSAGE;

public class CoachTest {

    @Test
    public void 정상_글자수를_가진_이름을_넣으면_코치_객체를_생성할_수_있다() {
        Assertions.assertThat(new Coach("john")).isExactlyInstanceOf(Coach.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"j", "richard"})
    public void 정상_글자수가_아닐경우_예외가_발생한다(String wrongName) {
        Assertions.assertThatThrownBy(() -> new Coach(wrongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_RANGE_ERROR_MESSAGE.getMessage());
    }
}
