package AlexPackage.MonacoConsole;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aborigens on 23-Oct-15.
 */
public class Menu {

    private final String EXIT = "Exit";
    private final String CREATE_ROUTE = "Create Route";
    private final String VIEW_ROUTE = "View Route";

    private Map<Integer, String> userMenu;
    private Map<Integer, Execute> menuActions;

    public Menu() {
        userMenu = new HashMap<Integer, String>();
        userMenu.put(7, EXIT);
        userMenu.put(1, CREATE_ROUTE);
        userMenu.put(2, VIEW_ROUTE);

        menuActions = new HashMap<Integer, Execute>();
        menuActions.put(7, new Exit());
        menuActions.put(1, new CreateRoute());
        menuActions.put(2, new RouteView());
    }

    public Map<Integer, Execute> getMenuActions() {
        return menuActions;
    }

    public Map<Integer, String> getUserMenu() {
        return userMenu;
    }

}
