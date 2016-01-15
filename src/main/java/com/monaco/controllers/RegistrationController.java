package com.monaco.controllers;

import com.monaco.datasources.LandingPageDS;
import com.monaco.datasources.RegistrationPageDS;
import com.monaco.entities.User;
import com.monaco.mvc.MVCController;
import com.monaco.mvc.MVCModel;
import com.monaco.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by maximpuskels on 11/26/15.
 */

@Controller
public class RegistrationController implements MVCController {

    private static final String EMPTY_STRING = "";

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
        Optional<String> nickName   = getStringFromRequest(request, "rNickName");
        Optional<String> password   = getStringFromRequest(request,"rPassword");
        Optional<String> email      = getStringFromRequest(request, "rEmail");
        Optional<Integer> cityID    = getIntegerFromRequest(request, "rCity");
        Optional<Integer> countryID = getIntegerFromRequest(request, "rCountry");
        // Additional
        Optional<String> name       = getStringFromRequest(request, "rName");
        Optional<String> surname    = getStringFromRequest(request, "rSurname");
        Optional<Integer> age       = getIntegerFromRequest(request, "rAge");
        Optional<Integer> tagID     = getIntegerFromRequest(request, "rTag");

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

    private Optional<String> getStringFromRequest(HttpServletRequest request, String key) {
        Optional<String> returnObject = Optional.empty();
        if (request.getParameterMap().containsKey(key) && !request.getParameter(key).isEmpty()) {
            returnObject = Optional.of(request.getParameter(key));
        }
        return returnObject;
    }

    private Optional<Integer> getIntegerFromRequest(HttpServletRequest request, String key) {
        Optional<Integer> returnObject = Optional.empty();
        if (request.getParameterMap().containsKey(key) && !request.getParameter(key).isEmpty()) {
            returnObject = Optional.of(Integer.valueOf(request.getParameter(key)));
        }
        return returnObject;
    }

    @Override
    public MVCModel executeGet(HttpServletRequest request) {
        datasource.generateDatasource();
        return new MVCModel(datasource, "/JSPs/Login/RegistrationPage.jsp");
    }
}
