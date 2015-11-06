package AlexPackage;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aborigens on 05-Nov-15.
 */
public interface RouteController {

    RouteModel execute(HttpServletRequest request);

}
