package AlexPackage;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aborigens on 06-Nov-15.
 */
public class RouteCreationController implements RouteController {
    @Override
    public RouteModel execute(HttpServletRequest request) {
        return new RouteModel("Create Route" ,"/RouteCreationPage.jsp");
    }
}
