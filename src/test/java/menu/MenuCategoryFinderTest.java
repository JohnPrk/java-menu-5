package menu;

import menu.domain.menu.MenuCategoryFinder;
import menu.domain.menu.error.MenuErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MenuCategoryFinderTest {

    @ParameterizedTest
    @CsvSource(value = {"규동,일식", "김밥,한식", "깐풍기,중식", "팟타이,아시안", "라자냐,양식"}, delimiterString = ",")
    public void 메뉴에_맞춰_카테고리를_찾을_수_있다(String menu, String category) {
        Assertions.assertThat(MenuCategoryFinder.findCategory(menu)).isEqualTo(category);
    }

    @Test
    public void 메뉴에_맞는_카테고리가_없을_경우_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> MenuCategoryFinder.findCategory("오마카세"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MenuErrorMessage.NO_MATCHING_CATEGORY_ERROR_MESSAGE.getMessage());
    }
}
