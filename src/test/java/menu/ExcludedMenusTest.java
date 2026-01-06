package menu;

import menu.domain.menu.ExcludedMenus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static menu.domain.menu.error.MenuErrorMessage.*;

public class ExcludedMenusTest {

    @Test
    public void 존재하지_않는_음식을_입력했을_경우_예외가_발생한다() {
        Assertions.assertThatThrownBy(
                        () -> new ExcludedMenus(List.of("나베")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_EXISTS_MENU_ERROR_MESSAGE.getMessage());
    }

    @Test
    public void 못_먹는_음식이_0개에서_2개일_경우_예외가_발생하지_않는다() {
        List<String> emptyList = List.of();
        List<String> oneMenu = List.of("우동");
        List<String> twoMenu = List.of("우동", "규동");
        Assertions.assertThatCode(() -> {
            new ExcludedMenus(null);
            new ExcludedMenus(emptyList);
            new ExcludedMenus(oneMenu);
            new ExcludedMenus(twoMenu);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 못_먹는_음식이_2개를_초과할_경우_예외가_발생합니다() {
        Assertions.assertThatThrownBy(
                        () -> new ExcludedMenus(List.of("우동", "규동", "미소시루")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCLUDES_MENUS_RANGE_ERROR_MESSAGE.getMessage());
    }

    @Test
    public void 못_먹는_음식이_같을_경우_예외가_발생합니다() {
        Assertions.assertThatThrownBy(
                        () -> new ExcludedMenus(List.of("우동", "우동")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NO_DUPLICATE_MENU_ERROR_MESSAGE.getMessage());
    }
}
