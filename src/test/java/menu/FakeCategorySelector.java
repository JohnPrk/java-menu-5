package menu;

import menu.domain.menu.CategorySelector;

import java.util.List;

public class FakeCategorySelector implements CategorySelector {

    private int count = 0;

    private final List<List<String>> categories =
            List.of(
                    List.of("한식", "일식", "양식", "중식", "양식"),
                    List.of("일식", "양식", "중식", "양식", "한식"),
                    List.of("양식", "중식", "양식", "한식", "일식")
            );

    @Override
    public List<String> select() {
        return categories.get(count++);
    }
}
