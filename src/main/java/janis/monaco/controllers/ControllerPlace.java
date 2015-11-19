package janis.monaco.controllers;


import janis.monaco.mvc.MVCController;
import janis.monaco.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by janis on 11/19/15.
 */

@Component
public class ControllerPlace implements MVCController {


    @Override
    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Login page here", "/spring.jsp");
    }
}
