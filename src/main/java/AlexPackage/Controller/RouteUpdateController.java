package AlexPackage.Controller;

import AlexPackage.DB.Domain.Route;
import AlexPackage.DB.Helper.HelperCountry;
import AlexPackage.DB.Helper.HelperTags;
import AlexPackage.DB.RouteDAOInterface;
import AlexPackage.Model.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static AlexPackage.DB.Domain.RouteBuilder.createRoute;

/**
 * Created by Aborigens on 19-Dec-15.
 */

@Component
public class RouteUpdateController implements RouteController {

    @Autowired
    private RouteDAOInterface routeMetaInfo;

    @Override
    public RouteModel execute(HttpServletRequest request) {

        Map<String, List> model = new HashMap<>();

        String destination = "/RouteUpdatePage.jsp";

        try {

            String routeId = request.getParameter("routeId");
            if (routeId != null) {

                String routeCountry = request.getParameter("helperCountry");
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
                        .withRouteId(routeId)
                        .build();


                destination = "/RouteUpdateAction.jsp";
                List<String> updateMessage = new ArrayList<>();
                if (routeMetaInfo.updateRoute(itinerary)) {
                    updateMessage.add("The route is updated.");
                } else {
                    updateMessage.add("The route is not updated.");
                }

                model.put("update", updateMessage);
            } else {

                List<HelperCountry> helperCountryList = routeMetaInfo.getCountryList();
                model.put("countries", helperCountryList);

                List<HelperTags> helperTagsList = routeMetaInfo.getTagsList();
                model.put("tags", helperTagsList);
            }

        } catch (Throwable e) {
            System.out.println("Exception while executing RouteCreationController.execute()");
            e.printStackTrace();
        }

        return new RouteModel(model, destination);
    }
}
