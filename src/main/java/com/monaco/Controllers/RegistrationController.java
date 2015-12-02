package com.monaco.Controllers;

import com.monaco.DataSources.LandingPageDS;
import com.monaco.DataSources.RegistrationPageDS;
import com.monaco.Entities.User;
import com.monaco.MVC.MVCController;
import com.monaco.MVC.MVCModel;
import com.monaco.Services.RegistrationService;
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
    private RegistrationService registrationService;

    @Autowired
    private RegistrationPageDS datasource;

    @Autowired
    private LandingPageDS landingPageDS;

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

        Optional<User> registeredUser = registrationService.tryRegistration(nickName, password, email, cityID, countryID, name, surname, age, tagID);

        if (registeredUser.isPresent()) {
            request.getSession().setAttribute("userID", registeredUser.get().getUserID());
            landingPageDS.setUserNickname(registeredUser.get().getNickname());
            model = new MVCModel(landingPageDS, "/JSPs/LandingPage.jsp");
        } else {
            // TODO: Implement failure page
            model = new MVCModel("", "/JSPs/Login/LoginPage.jsp");
        }

        return model;
    }

    @Override
    public MVCModel executeGet(HttpServletRequest request) {
        datasource.generateDatasource();
        return new MVCModel(datasource, "/JSPs/Login/RegistrationPage.jsp");
    }
}
