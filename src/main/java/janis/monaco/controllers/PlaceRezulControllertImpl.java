package janis.monaco.controllers;

import janis.monaco.database.PlaceDAO;
import janis.monaco.domain.Place;
import janis.monaco.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

/**
 * Created by janis on 12/22/15.
 */

@Controller
public class PlaceRezulControllertImpl implements PlaceRezultController {

    @Autowired
    PlaceDAO placeDAO;

    @Transactional
    public MVCModel execute(HttpServletRequest request) {

        System.out.println("ControllerPlaceRezult is called!!!");

        Place place = new Place();
        place.setLongitude(Double.valueOf(request.getParameter("longitude")));
        place.setLatitude(Double.valueOf(request.getParameter("latitude")));
        place.setImageUrl(request.getParameter("imageURL"));
        place.setPlaceTypeId(210);
        place.setPlaceName(request.getParameter("placeName"));
        place.setPlaceAddress(request.getParameter("address"));

        placeDAO.create(place);

        System.out.println(request.getParameter("placeName"));
        System.out.println(request.getParameter("placeTypeId"));


        return new MVCModel("", "/views/place_views/placeRezult.jsp");
    }

}
