package menu;

import menu.view.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"토미,제임스,포코", "토미,제임스", "토미"})
    public void 이름과_구분자가_정확하게_들어가면_예외가_발생하지_않는다(String coaches) {
        Assertions.assertThatCode(() -> InputValidator.coachesValid(coaches))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"토미,,포코", ",토미", ""})
    public void 이름과_구분자의_형식이_잘못될_경우_예외가_발생한다(String coaches) {
        Assertions.assertThatThrownBy(() -> InputValidator.coachesValid(coaches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 형식입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"팟타이,우동", "칼국수", "토미"})
    public void 메뉴와_구분자가_정확하게_들어가면_예외가_발생하지_않는다(String coaches) {
        Assertions.assertThatCode(() -> InputValidator.menusValid(coaches))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void null과_빈_값이_들어가도_예외가_발생하지_않는다(String nullOrEmpty) {
        Assertions.assertThatCode(() -> InputValidator.menusValid(nullOrEmpty))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"팟타이,,우동", ",우동"})
    public void 메뉴와_구분자의_형식이_잘못될_경우_예외가_발생한다(String coaches) {
        Assertions.assertThatThrownBy(() -> InputValidator.coachesValid(coaches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 형식입니다.");
    }
}
