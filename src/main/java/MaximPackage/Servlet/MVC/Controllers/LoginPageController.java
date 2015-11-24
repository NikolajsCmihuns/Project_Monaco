package MaximPackage.Servlet.MVC.Controllers;

import MaximPackage.Servlet.MVC.DataSources.LoginDataSource;
import MaximPackage.Servlet.MVC.MVCController;
import MaximPackage.Servlet.MVC.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maksimspuskels on 03/11/15.
 */

@Component
public class LoginPageController implements MVCController {

    @Override
    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel(new LoginDataSource(), "/LoginPage.jsp");
    }
}
