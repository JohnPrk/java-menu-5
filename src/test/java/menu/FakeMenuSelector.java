package menu;

import menu.domain.menu.MenuSelector;

import java.util.HashMap;
import java.util.List;

public class FakeMenuSelector implements MenuSelector {

    private final List<List<String>> korean =
            List.of(
                    List.of("제육볶음", "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이"),
                    List.of("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
                    List.of("김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음", "김치찌개"),
                    List.of("쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음", "김치찌개", "김밥"),
                    List.of("된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음", "김치찌개", "김밥", "쌈밥"),
                    List.of("비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음", "김치찌개", "김밥", "쌈밥", "된장찌개")
            );
    private final List<List<String>> japenese =
            List.of(
                    List.of("가츠동", "규동", "우동", "미소시루", "스시", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
                    List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
                    List.of("우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼", "규동"),
                    List.of("미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼", "규동", "우동"),
                    List.of("스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼", "규동", "우동", "미소시루"),
                    List.of("가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼", "규동", "우동", "미소시루", "스시")
            );
    private final List<List<String>> chinese =
            List.of(
                    List.of("짜장면", "깐풍기", "볶음면", "동파육", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
                    List.of("짬뽕", "깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
                    List.of("깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채", "짬뽕"),
                    List.of("볶음면", "동파육", "짜장면", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채", "짬뽕", "깐풍기"),
                    List.of("동파육", "짜장면", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채", "짬뽕", "깐풍기", "볶음면"),
                    List.of("짜장면", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채", "짬뽕", "깐풍기", "볶음면", "동파육")
            );
    private final List<List<String>> asian =
            List.of(
                    List.of("카오 팟", "팟타이", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
                    List.of("파인애플 볶음밥", "팟타이", "카오 팟", "나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
                    List.of("팟타이", "카오 팟", "나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜", "파인애플 볶음밥"),
                    List.of("카오 팟", "나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜", "파인애플 볶음밥", "팟타이"),
                    List.of("나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜", "파인애플 볶음밥", "팟타이", "카오 팟"),
                    List.of("쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜", "파인애플 볶음밥", "팟타이", "카오 팟", "나시고렝")
            );

    private final List<List<String>> western =
            List.of(
                    List.of("스파게티", "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "피자", "파니니"),
                    List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"),
                    List.of("그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니", "라자냐"),
                    List.of("뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니", "라자냐", "그라탱"),
                    List.of("끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니", "라자냐", "그라탱", "뇨끼"),
                    List.of("프렌치 토스트", "바게트", "스파게티", "피자", "파니니", "라자냐", "그라탱", "뇨끼", "끼슈")
            );

    private final HashMap<String, Integer> menuCount = setUpCount();
    private final HashMap<String, List<List<String>>> menu = setUpMenu();

    @Override
    public List<String> selectBy(String category) {
        List<List<String>> menus = menu.get(category);
        int count = menuCount.get(category);
        menuCount.replace(category, count + 1);
        return menus.get(count);
    }

    private HashMap<String, Integer> setUpCount() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("일식", 0);
        hashMap.put("한식", 0);
        hashMap.put("중식", 0);
        hashMap.put("아시안", 0);
        hashMap.put("양식", 0);
        return hashMap;
    }

    private HashMap<String, List<List<String>>> setUpMenu() {
        HashMap<String, List<List<String>>> hashMap = new HashMap<>();
        hashMap.put("일식", japenese);
        hashMap.put("한식", korean);
        hashMap.put("중식", chinese);
        hashMap.put("아시안", asian);
        hashMap.put("양식", western);
        return hashMap;
    }
}
