package janis.monaco.controllers;

import janis.monaco.mvc.MVCModel;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by janis on 12/22/15.
 */

@Controller
public class ControllerPlaceRezultImpl implements ControllerPlaceRezult {


    public MVCModel execute(HttpServletRequest request) {

        System.out.println("ControllerPlaceRezult is called!!!");



        System.out.println(request.getParameter("placeName"));
        System.out.println(request.getParameter("placeTypeId"));


        return new MVCModel("", "/views/place_views/placeRezult.jsp");
    }

}
