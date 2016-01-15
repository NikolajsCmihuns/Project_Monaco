package com.monaco.controllers;

import com.monaco.dataSources.LandingPageDS;
import com.monaco.Entities.User;
import com.monaco.MVC.MVCController;
import com.monaco.MVC.MVCModel;

import com.monaco.Services.LoginServiceInterface;
import lv.javaguru.java2.database.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by maksimspuskels on 25/11/15.
 */

@Controller
public class LoginController implements MVCController {

    @Autowired
    LoginServiceInterface loginService;

    @Autowired
    LandingPageDS dataSource;

    @Override
    public MVCModel executePost(HttpServletRequest request) {

        String nickName = request.getParameter("lNickName");
        String password = request.getParameter("lPassword");

        try {
            Optional<User> loggedUser = loginService.tryLogin(nickName, password);

            if (loggedUser.isPresent()) {
                HttpSession session = request.getSession();
                session.setAttribute("userID", loggedUser.get().getUserID());
                dataSource.setUserNickname(loggedUser.get().getNickname());
                return new MVCModel(dataSource, "/JSPs/LandingPage.jsp");
            }
            else {
                // TODO: Implement failure page
                return new MVCModel("", "/JSPs/Login/LoginPage.jsp");
            }
        }
        catch (DBException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public MVCModel executeGet(HttpServletRequest request) {
        MVCModel model = new MVCModel("", "/JSPs/Login/LoginPage.jsp");
        return model;
    }
}

