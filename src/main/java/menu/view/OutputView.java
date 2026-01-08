package menu.view;

import menu.domain.menu.dto.RecommendationMenuResult;

import java.util.List;
import java.util.Queue;

public class OutputView {

    private static final String CATEGORIES = "[ 카테고리 | %s | %s | %s | %s | %s ]%n";
    private static final String COACH_AND_MENUS = "[ %s | %s | %s | %s | %s | %s ]%n";
    private static final String DAY_OF_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

    public static void printLunchMenuRecommendationMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public static void printRecommendationMenu(RecommendationMenuResult coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println(DAY_OF_WEEK);
        List<String> categories = coaches.getCategories();
        System.out.printf(CATEGORIES, categories.get(0), categories.get(1), categories.get(2), categories.get(3), categories.get(4));
        coaches.getCoaches()
                .forEach(coach -> {
                    Queue<String> weeklyMenus = coach.getWeeklyMenus();
                    System.out.printf(COACH_AND_MENUS, coach.getName(), weeklyMenus.poll(), weeklyMenus.poll(), weeklyMenus.poll(), weeklyMenus.poll(), weeklyMenus.poll());
                });
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
