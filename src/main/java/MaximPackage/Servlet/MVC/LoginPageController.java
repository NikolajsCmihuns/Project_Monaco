package MaximPackage.Servlet.MVC;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maksimspuskels on 03/11/15.
 */

public class LoginPageController implements MVCController{
    @Override
    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Login page here", "/LoginPage.jsp");
    }
}
