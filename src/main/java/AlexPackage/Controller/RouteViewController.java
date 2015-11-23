package AlexPackage.Controller;

import AlexPackage.DB.RouteDAOImplementation;
import AlexPackage.DB.Helper.Tags;
import AlexPackage.Model.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
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

    @Override
    public RouteModel execute(HttpServletRequest request) {

        Map<String, List> model = new HashMap<>();

        try {
            List<Tags> tagsList = routeMetaInfo.getTagsList();
            model.put("tags", tagsList);
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteViewController.execute()");
            e.printStackTrace();
        }

        return new RouteModel(model, "/RouteViewPage.jsp");
    }
}
