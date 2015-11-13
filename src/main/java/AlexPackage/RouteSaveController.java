package AlexPackage;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aborigens on 13-Nov-15.
 */
public class RouteSaveController implements RouteController {

    @Override
    public RouteModel execute(HttpServletRequest request) {
        return new RouteModel("" ,"/RouteCreationAction.jsp");
    }
}
