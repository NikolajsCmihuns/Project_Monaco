package MaximPackage.Servlet.MVC.Controllers;

import MaximPackage.Services.LoginService;
import MaximPackage.Servlet.MVC.DataSources.LandingPageDS;

import MaximPackage.Servlet.MVC.MVCController;

import MaximPackage.Servlet.MVC.MVCModel;
import MaximPackage.Entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by maksimspuskels on 25/11/15.
 */

@Component
public class LoginController implements MVCController {

    @Autowired
    LoginService loginService;

    @Override
    public MVCModel executePost(HttpServletRequest request) {

        String nickName = request.getParameter("lNickName");
        String password = request.getParameter("lPassword");

        Optional<Integer> loggedUserID = loginService.tryLogin(nickName, password);

        MVCModel returnModel;

        if (loggedUserID.get() != User.USER_NOT_FOUND) {
            HttpSession session = request.getSession();
            session.setAttribute("userID", loggedUserID);

            LandingPageDS dataSource = new LandingPageDS(loggedUserID);
            returnModel = new MVCModel(dataSource, "/JSPs/LandingPage.jsp");
        }
        else {
            // TODO: Implement failure page
            returnModel = new MVCModel("", "/JSPs/Login/LoginPage.jsp");
        }

        return returnModel;
    }
}

