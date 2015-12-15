package AlexPackage.Controller;

import AlexPackage.DB.Domain.Route;
import AlexPackage.DB.RouteDAOImplementation;
import AlexPackage.DB.RouteDAOInterface;
import AlexPackage.Model.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static AlexPackage.DB.Domain.RouteBuilder.createRoute;

/**
 * Created by Aborigens on 13-Nov-15.
 */
@Component
public class RouteSaveController implements RouteController {

    @Autowired
    private RouteDAOInterface routeMetaInfo;

    @Override
    public RouteModel execute(HttpServletRequest request) {

        String message = "Ooops, something went wrong!";

        try {
            String routeCountry = request.getParameter("country");
            String routeCity = request.getParameter("city");
            String routeName = request.getParameter("routeName");
            String routeTag = request.getParameter("tag"); // table route
            String route = request.getParameter("route"); // table place & places_in_route
            String distance = request.getParameter("routeDistance"); // table route

            Route itinerary = createRoute()
                    .withRouteCountry(routeCountry)
                    .withRouteCity(routeCity)
                    .withRouteName(routeName)
                    .withRouteTag(routeTag)
                    .withRoute(route)
                    .withRouteDistance(distance)
                    .build();

            if (routeMetaInfo.saveRoute(itinerary)) {
                message = "Your route is saved!";
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteSaveController.execute()");
            e.printStackTrace();
        }

        return new RouteModel(message, "/RouteCreationAction.jsp");
    }
}

