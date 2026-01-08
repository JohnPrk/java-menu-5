package menu;

import menu.controller.Controller;
import menu.domain.menu.RandomCategorySelector;
import menu.domain.menu.RandomMenuSelector;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new RandomMenuSelector(), new RandomCategorySelector());
        controller.run();
    }
}
