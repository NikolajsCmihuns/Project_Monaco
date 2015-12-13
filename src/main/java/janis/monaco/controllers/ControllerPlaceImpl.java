package janis.monaco.controllers;

import janis.monaco.database.PlaceDAO;
import janis.monaco.domain.Place;
import janis.monaco.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
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


        System.out.println("ControllerPlace is called!!!");

        List<Place>  places = placeDAO.getAll();
       ;
        List placeList = new ArrayList();


            for(Place place : places)
            {

                String [] properties = new String[7];
                properties [0] = String.valueOf(place.getPlaceId());
                properties [1] = String.valueOf(place.getLatitude());
                properties [2] = String.valueOf(place.getLongitude());
                properties [3] = place.getImageUrl();
                properties [4] = place.getPlaceName();
                properties [5] = place.getPlaceAddress();
                properties [6] = String.valueOf(place.getPlaceTypeId());
                placeList.add(properties);

            }




        return new MVCModel(placeList, "/views/place_views/place.jsp");
    }
}
