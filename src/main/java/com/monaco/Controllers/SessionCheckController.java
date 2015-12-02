package com.monaco.Controllers;

import com.monaco.DataSources.LandingPageDS;
import com.monaco.MVC.MVCController;
import com.monaco.MVC.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by maksimspuskels on 26/11/15.
 */

@Component
public class SessionCheckController implements MVCController {

    @Autowired
    private LandingPageDS dataSource;

    @Override
    public MVCModel executeGet(HttpServletRequest request) {
        // Get session and check logged user id existence
        HttpSession session = request.getSession();
        Optional<Integer> userID = (Optional<Integer>)session.getAttribute("userID");
        // If id exists proceed to main page else login page
        MVCModel model;
        if (userID != null && userID.isPresent()) {
            dataSource.updateUserNicknameFromUserID(userID.get());
            model = new MVCModel(dataSource, "/JSPs/LandingPage.jsp");
        }
        else {
            model = new MVCModel("", "/JSPs/Login/LoginPage.jsp");
        }

        return model;
    }
}
