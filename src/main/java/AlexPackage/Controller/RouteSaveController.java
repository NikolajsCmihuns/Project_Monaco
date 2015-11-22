package AlexPackage.Controller;

import AlexPackage.DB.Domain.Route;
import AlexPackage.DB.RouteDAOImplementation;
import AlexPackage.Model.RouteModel;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aborigens on 13-Nov-15.
 */
public class RouteSaveController implements RouteController {

    @Override
    public RouteModel execute(HttpServletRequest request) {

        Boolean isSaved = false;

        try {
            String routeCountry = request.getParameter("country");
            String routeCity = request.getParameter("city");
            String routeName = request.getParameter("routeName");
            String routeTag = request.getParameter("tag"); // table route
            String route = request.getParameter("route"); // table place & places_in_route
            String distance = request.getParameter("routeDistance"); // table route

            Route itinerary = new Route(routeCountry, routeCity, routeName, routeTag, route, distance);
            RouteDAOImplementation routeDAOImplementation = new RouteDAOImplementation();

            isSaved = routeDAOImplementation.saveRoute(itinerary);
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteSaveController.execute()");
            e.printStackTrace();
        }

        return new RouteModel(isSaved, "/RouteCreationAction.jsp");
    }
}



