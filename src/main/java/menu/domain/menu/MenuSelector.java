package menu.domain.menu;

import java.util.List;

public interface MenuSelector {

    List<String> selectBy(String category);
}
