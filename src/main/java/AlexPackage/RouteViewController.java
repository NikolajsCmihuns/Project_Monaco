package AlexPackage;

import AlexPackage.DB.RouteDAOImplementation;
import AlexPackage.DB.Tags;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aborigens on 15-Nov-15.
 */
public class RouteViewController implements RouteController {

    @Override
    public RouteModel execute(HttpServletRequest request) {

        Map<String, List> model = new HashMap<>();

        try {
            RouteDAOImplementation routeMetaInfo = new RouteDAOImplementation();
            List<Tags> tagsList = routeMetaInfo.getTagsList();
            model.put("tags", tagsList);
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteViewController.execute()");
            e.printStackTrace();
        }

        return new RouteModel(model, "/RouteViewPage.jsp");
    }
}
