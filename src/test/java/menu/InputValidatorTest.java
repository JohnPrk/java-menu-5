package menu;

import menu.view.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"토미,제임스,포코", "토미,제임스", "토미"})
    public void test(String coaches) {
        Assertions.assertThatCode(() -> InputValidator.coachesSeparatorRegexValid(coaches))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"토미,,포코", ",토미", ""})
    public void test2(String coaches) {
        Assertions.assertThatThrownBy(() -> InputValidator.coachesSeparatorRegexValid(coaches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 형식입니다.");
    }
}