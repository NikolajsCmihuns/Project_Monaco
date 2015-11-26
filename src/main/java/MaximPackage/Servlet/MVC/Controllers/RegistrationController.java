package MaximPackage.Servlet.MVC.Controllers;

import MaximPackage.Database.UserDAOImplementation;
import MaximPackage.Entities.User;
import MaximPackage.Services.RegistrationService;
import MaximPackage.Servlet.MVC.DataSources.LandingPageDS;

import MaximPackage.Servlet.MVC.DataSources.RegistrationDataSource;
import MaximPackage.Servlet.MVC.MVCController;
import MaximPackage.Servlet.MVC.MVCModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by maximpuskels on 11/26/15.
 */

@Component
public class RegistrationController implements MVCController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    UserDAOImplementation userDAO;

    @Override
    public MVCModel executeGet(HttpServletRequest request) {
        return new MVCModel(new RegistrationDataSource(), "/JSPs/Login/RegistrationPage.jsp");
    }

    @Override
    public MVCModel executePost(HttpServletRequest request) {

        MVCModel model;

        // Mandatory
        String nickName = request.getParameter("rNickName");
        String password = request.getParameter("rPassword");
        String email = request.getParameter("rEmail");
        Integer cityID = Integer.valueOf(request.getParameter("rCity"));
        Integer countryID = Integer.valueOf(request.getParameter("rCountry"));

        // Additional
        String name = request.getParameter("rName");
        String surname = request.getParameter("rSurname");
        Integer age = Integer.valueOf(request.getParameter("rAge"));
        Integer tagID = Integer.valueOf(request.getParameter("rTag"));

        Optional<Integer> registeredUserID = registrationService.tryRegistration(nickName, password, email, cityID, countryID, name, surname, age, tagID);


        if (registeredUserID.get() != User.USER_NOT_FOUND) {
            request.getSession().setAttribute("userID", registeredUserID);
            model = new MVCModel(new LandingPageDS(registeredUserID), "/JSPs/LandingPage.jsp");
        } else {
            // TODO: Implement failure page
            model = new MVCModel("", "/JSPs/Login/LoginPage.jsp");
        }

        return model;
    }
}
