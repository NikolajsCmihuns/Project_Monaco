package AlexPackage.Controller;

import AlexPackage.DB.Helper.HelperCountry;
import AlexPackage.DB.Helper.HelperTags;
import AlexPackage.DB.RouteDAOImplementation;
import AlexPackage.Model.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aborigens on 06-Nov-15.
 */
@Component
public class RouteCreationController implements RouteController {

    @Autowired
    private RouteDAOImplementation routeMetaInfo;

    @Override
    public RouteModel execute(HttpServletRequest request) {

        Map<String, List> model = new HashMap<>();

        try {

            List<HelperCountry> helperCountryList = routeMetaInfo.getCountryList();
            model.put("countries", helperCountryList);

            List<HelperTags> helperTagsList = routeMetaInfo.getTagsList();
            model.put("tags", helperTagsList);

        } catch (Throwable e) {
            System.out.println("Exception while executing RouteCreationController.execute()");
            e.printStackTrace();
        }

        return new RouteModel(model, "/RouteCreationPage.jsp");
    }
}

