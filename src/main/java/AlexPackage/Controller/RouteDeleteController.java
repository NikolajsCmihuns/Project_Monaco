package AlexPackage.Controller;

import AlexPackage.DB.Domain.Route;
import AlexPackage.DB.Helper.HelperTags;
import AlexPackage.DB.RouteDAOImplementation;
import AlexPackage.DB.RouteDAOInterface;
import AlexPackage.Model.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Aborigens on 12-Dec-15.
 */
@Component
public class RouteDeleteController implements RouteController {

    @Autowired
    private RouteDAOInterface routeMetaInfo;

    private Optional<Integer> getUserIdFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Optional<Integer>) session.getAttribute("userID");
    }

    private Map<String, List> getRoutes(Map<String, List> model, Optional<Integer> userId) {
        try {
            List<Route> userRoutes = routeMetaInfo.getUserRoutes(userId);
            model.put("routesToDelete", userRoutes);

            List<HelperTags> helperTagses = new ArrayList<>();
            Iterator<Route> routeIterator = userRoutes.iterator();
            while (routeIterator.hasNext()) {
                Route route = routeIterator.next();
                HelperTags helperTags = new HelperTags(Integer.parseInt(route.getRouteTag()), routeMetaInfo.getTagById(route.getRouteTag()));
                helperTagses.add(helperTags);
            }
            model.put("routesToDeleteTags", helperTagses);
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDeleteController.getRoutes()");
            e.printStackTrace();
        }

        return model;
    }

    private void deleteRoutes(String[] routesToDeleteIds) {
        try {
            routeMetaInfo.deleteRoutesMass(routesToDeleteIds);
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDeleteController.deleteRoutes()");
            e.printStackTrace();
        }
    }

    @Override
    public RouteModel execute(HttpServletRequest request) {

        Map<String, List> model = new HashMap<>();

        try {
//             delete if we know what to delete only
            if (request.getParameter("hiddenRoutesToDelete") != null) {
                String[] routesToDeleteIds = request.getParameter("hiddenRoutesToDelete").split(",");
                deleteRoutes(routesToDeleteIds);
            }
            model = getRoutes(model, getUserIdFromSession(request));
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDeleteController.execute()");
            e.printStackTrace();
        }

        return new RouteModel(model, "/RouteDeletePage.jsp");
    }
}
