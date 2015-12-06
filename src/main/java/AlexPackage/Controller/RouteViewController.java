package AlexPackage.Controller;

import AlexPackage.DB.Domain.Route;
import AlexPackage.DB.Helper.HelperChosenTag;
import AlexPackage.DB.Helper.HelperPlace;
import AlexPackage.DB.RouteDAOImplementation;
import AlexPackage.DB.Helper.HelperTags;
import AlexPackage.Model.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aborigens on 15-Nov-15.
 */
@Component
public class RouteViewController implements RouteController {

    @Autowired
    private RouteDAOImplementation routeMetaInfo;

    private Map<String, List> getTags(Map<String, List> model) {
        try {
            List<HelperTags> helperTagsList = routeMetaInfo.getTagsList();
            model.put("tags", helperTagsList);
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteViewController.getTags()");
            e.printStackTrace();
        }
        return model;
    }

    private List<HelperChosenTag> getTags(String chosenTag) {

        List<HelperChosenTag> chosenTagText = new ArrayList<>();

        try {
            HelperChosenTag chosen = new HelperChosenTag(chosenTag, routeMetaInfo.getTagById(chosenTag));
            chosenTagText.add(chosen);
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteViewController.getTags(String chosenString)");
            e.printStackTrace();
        }

        return chosenTagText;
    }

    private Map<String, List> getRoutes(Map<String, List> model, String routeTag) {
        try {
            List<Route> routesIdsDistance = routeMetaInfo.getRoutesIds(routeTag);
            Map<String, List> helperPlaces = routeMetaInfo.getPlaceIdsSequence(routesIdsDistance);
            List<Route> routeIdCoordinates = routeMetaInfo.gerRouteIdCoordinates(helperPlaces, routesIdsDistance);
            model.put("routeIds", routeIdCoordinates);
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteViewController.getRouteIds()");
            e.printStackTrace();
        }

        return model;
    }

    @Override
    public RouteModel execute(HttpServletRequest request) {

        Map<String, List> model = new HashMap<>();

        try {
            if (request.getParameter("tag") == null) {
                // is the initial load of the page, load all available tags
                model = getTags(model);
            } else {
                // we have tag and we want all route ids of that tag
                model = getRoutes(model, request.getParameter("tag"));
                // we also want all of them
                model = getTags(model);
                // we also want the chosen one, why - fancy and too lazy for asynchronous calls
                List<HelperChosenTag> chosenTagText = getTags(request.getParameter("tag"));
                model.put("chosenTag", chosenTagText);
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteViewController.execute()");
            e.printStackTrace();
        }

        return new RouteModel(model, "/RouteViewPage.jsp");
    }
}
