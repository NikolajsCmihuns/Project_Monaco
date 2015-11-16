package AlexPackage;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aborigens on 15-Nov-15.
 */
public class RouteViewController implements RouteController {

    @Override
    public RouteModel execute(HttpServletRequest request) {
        return new RouteModel("" ,"/RouteViewPage.jsp");
    }
}
