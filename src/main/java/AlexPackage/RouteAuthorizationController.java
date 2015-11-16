package AlexPackage;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aborigens on 16-Nov-15.
 */
public class RouteAuthorizationController implements RouteController {
    @Override
    public RouteModel execute(HttpServletRequest request) {
        return new RouteModel("You Shall not Pass!" ,"/RouteAuthorizationPage.jsp");
    }
}
