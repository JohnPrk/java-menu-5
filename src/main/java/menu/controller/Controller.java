package menu.controller;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.ExcludedMenus;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    public void run(List<String> allMenus) {
        OutputView.printLunchMenuRecommendationMessage();
        Coaches coaches = getCoaches();
    }

    private Coaches getCoaches() {
        List<String> nameList = InputView.inputCoachesName();
        List<Coach> coaches = nameList.stream()
                .map(name -> {
                    ExcludedMenus excludedMenus = InputView.inputExcludedMenus(name);
                    return new Coach(name, excludedMenus);
                }).collect(Collectors.toList());
        return new Coaches(coaches);
    }
}
