package MaximPackage.Servlet.MVC.Controllers;

import MaximPackage.Servlet.MVC.MVCController;
import MaximPackage.Servlet.MVC.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maximpuskels on 11/26/15.
 */

@Component
public class RegistrationController implements MVCController {
    @Override
    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("","");
    }
}
