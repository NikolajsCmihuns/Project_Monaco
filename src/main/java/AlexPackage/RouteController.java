package AlexPackage;

import lv.javaguru.java2.database.DBException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aborigens on 05-Nov-15.
 */
public interface RouteController {
    RouteModel execute(HttpServletRequest request);
}
