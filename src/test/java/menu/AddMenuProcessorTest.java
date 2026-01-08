package menu;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.AddMenuProcessor;
import menu.domain.menu.CategorySelector;
import menu.domain.menu.ExcludedMenus;
import menu.domain.menu.MenuSelector;
import menu.domain.menu.dto.RecommendationMenuResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

public class AddMenuProcessorTest {

    private final MenuSelector menuSelector = new FakeMenuSelector();
    private final CategorySelector categorySelector = new FakeCategorySelector();
    private final Coaches coaches = new Coaches(
            List.of(
                    new Coach("포비", new ExcludedMenus(List.of())),
                    new Coach("브라운", new ExcludedMenus(List.of("김밥", "나시고렝"))),
                    new Coach("제이슨", new ExcludedMenus(List.of("동파육")))
            ));

    @Test
    public void 메뉴_선택_및_카테고리_선택_페이크_객체를_사용하여_협력_객체의_고립을_만들고_메뉴_추가_프로세서를_진행하면_코치에게_추천_메뉴가_등록된다() {
        AddMenuProcessor addMenuProcessor = new AddMenuProcessor(coaches, menuSelector, categorySelector);
        RecommendationMenuResult recommendationMenuResult = addMenuProcessor.process();
        List<Coach> coachesList = recommendationMenuResult.getCoaches();
        List<List<String>> answer = List.of(
                List.of("제육볶음", "가츠동", "스파게티", "짜장면", "뇨끼"),
                List.of("김치찌개", "규동", "라자냐", "짬뽕", "끼슈"),
                List.of("김밥", "우동", "그라탱", "깐풍기", "프렌치 토스트")
        );
        for (int index = 0; index < coachesList.size(); index++) {
            Queue<String> weeklyMenus = coachesList.get(index).getWeeklyMenus();
            Assertions.assertThat(weeklyMenus.toString()).isEqualTo(answer.get(index).toString());
        }
    }
}
