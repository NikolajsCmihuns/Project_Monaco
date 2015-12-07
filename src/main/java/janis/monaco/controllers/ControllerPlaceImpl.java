package janis.monaco.controllers;

import janis.monaco.database.PlaceDAO;
import janis.monaco.domain.Place;
import janis.monaco.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by janis on 11/19/15.
 */

@Controller
public class ControllerPlaceImpl implements ControllerPlace {

    @Autowired
    PlaceDAO placeDAO;

    @Transactional
    public MVCModel execute(HttpServletRequest request) {

        List<Place> places = null;
        System.out.println("ControllerPlace is called!!!");

            places = placeDAO.getAll();

            for(Place place : places)
            {
                System.out.println("id: " + place.getPlaceId() + ", Name: " + place.getPlaceName() + ", Address: " + place.getPlaceAddress());

            }
            System.out.println("The places list lenght is: "+places.size());


        return new MVCModel("Login page here", "/place.jsp");
    }
}
