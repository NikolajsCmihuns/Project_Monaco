package AlexPackage.Controller;

import AlexPackage.DB.Domain.Route;
import AlexPackage.DB.RouteDAOImplementation;
import AlexPackage.DB.Helper.Tags;
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
            List<Tags> tagsList = routeMetaInfo.getTagsList();
            model.put("tags", tagsList);
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteViewController.getTags()");
            e.printStackTrace();
        }
        return model;
    }

    private Map<String, List> getRouteIds(Map<String, List> model, String routeTag) {
        try {
            List<Route> routeIds = routeMetaInfo.getRoutes(routeTag);
            model.put("routeIds", routeIds);
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
                model = getRouteIds(model, request.getParameter("tag"));
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteViewController.execute()");
            e.printStackTrace();
        }

        return new RouteModel(model, "/RouteViewPage.jsp");
    }
}
