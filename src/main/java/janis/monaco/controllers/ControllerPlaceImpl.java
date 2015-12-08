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
        int size = places.size();
        String [] placeIdStrArr = new String[size];
        String [] latitudeStrArr = new String[size];
        String [] longitudeStrArr = new String[size];
        String [] imageURLStrArr = new String[size];
        String [] placeNameStrArr = new String[size];
        String [] placeAddressStrArr = new String[size];
        String [] placeTypeIdStrArr = new String[size];
        List placeList = new ArrayList();
        int counter = 0;

            for(Place place : places)
            {
                counter++;
                placeIdStrArr [counter-1] = String.valueOf(place.getPlaceId());
                latitudeStrArr [counter-1] = String.valueOf(place.getLatitude());
                longitudeStrArr [counter-1] = String.valueOf(place.getLongitude());
                imageURLStrArr [counter-1] = place.getImageUrl();
                placeNameStrArr [counter-1] = place.getPlaceName();
                placeAddressStrArr [counter-1] = place.getPlaceAddress();
                placeTypeIdStrArr [counter-1] = String.valueOf(place.getPlaceTypeId());

            }

        placeList.add(placeIdStrArr);
        placeList.add(latitudeStrArr);
        placeList.add(longitudeStrArr);
        placeList.add(imageURLStrArr);
        placeList.add(placeNameStrArr);
        placeList.add(placeAddressStrArr);
        placeList.add(placeTypeIdStrArr);


        return new MVCModel(placeList, "/views/place_views/place.jsp");
    }
}
