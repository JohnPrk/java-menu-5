package menu.controller;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.*;
import menu.domain.menu.dto.RecommendationMenuResult;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private final MenuSelector menuSelector;
    private final CategorySelector categorySelector;

    public Controller(MenuSelector menuSelector, CategorySelector categorySelector) {
        this.menuSelector = menuSelector;
        this.categorySelector = categorySelector;
    }

    public void run() {
        OutputView.printLunchMenuRecommendationMessage();
        Coaches coaches = getCoaches();
        AddMenuProcessor addMenuProcessor = new AddMenuProcessor(coaches, menuSelector, categorySelector);
        RecommendationMenuResult recommendationMenuResult = addMenuProcessor.process();
        OutputView.printRecommendationMenu(recommendationMenuResult);
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
