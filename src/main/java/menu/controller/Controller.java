package menu.controller;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    public void run(List<String> allMenus) {
        getCoaches();
    }

    private static Coaches getCoaches() {
        List<String> nameList = InputView.inputCoachesName();
        List<Coach> coachList = nameList.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
        return new Coaches(coachList);
    }
}
