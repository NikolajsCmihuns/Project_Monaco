package MaximPackage.Servlet.MVC.Controllers;

import MaximPackage.Servlet.MVC.DataSources.LandingPageDS;
import MaximPackage.Servlet.MVC.DataSources.LoginDataSource;
import MaximPackage.Servlet.MVC.MVCController;
import MaximPackage.Servlet.MVC.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by maksimspuskels on 26/11/15.
 */

@Component
public class SessionCheckController implements MVCController {
    @Override
    public MVCModel execute(HttpServletRequest request) {
        // Get session and check logged user id existence
        HttpSession session = request.getSession();
        Optional<Integer> userID = (Optional<Integer>)session.getAttribute("userID");
        // If id exists proceed to main page else login page
        MVCModel model;
        if (userID != null) {
            LandingPageDS dataSource = new LandingPageDS(userID);
            model = new MVCModel(dataSource, "/LandingPage.jsp"); // Rename to main page / landing page
        }
        else {
            model = new MVCModel(new LoginDataSource(), "/LoginPage.jsp");
        }

        return model;
    }
}
