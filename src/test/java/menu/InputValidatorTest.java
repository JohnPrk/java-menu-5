package menu;

import menu.view.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"토미,제임스,포코", "토미,제임스", "토미"})
    public void 이름과_구분자가_정확하게_들어가면_예외가_발생하지_않는다(String coaches) {
        Assertions.assertThatCode(() -> InputValidator.separatorRegexValid(coaches))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"토미,,포코", ",토미", ""})
    public void 이름과_구분자의_형식이_잘못될_경우_예외가_발생한다(String coaches) {
        Assertions.assertThatThrownBy(() -> InputValidator.separatorRegexValid(coaches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 형식입니다.");
    }
}
