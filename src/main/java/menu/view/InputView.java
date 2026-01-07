package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_COACHES_NAME_MESSAGE = "메뉴 추천을 받을 코치의 이름을 입력받는다. 올바른 값이 아니면 예외 처리한다.";

    public static List<String> inputCoachesName() {
        System.out.println(INPUT_COACHES_NAME_MESSAGE);
        String coachesName = Console.readLine();
        InputValidator.coachesSeparatorRegexValid(coachesName);
        return Arrays.stream(coachesName.split(",")).collect(Collectors.toList());
    }
}
