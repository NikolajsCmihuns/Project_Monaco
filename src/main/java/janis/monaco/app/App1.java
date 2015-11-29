package janis.monaco.app;


import janis.monaco.database.place.PlaceDAOImpl;
import janis.monaco.database.PlaceDAO;
import janis.monaco.domain.Place;

import java.util.List;


/**
 * Created by janis on 11/2/15.
 */
public class App1 {
    public static void main(String[] args){




        PlaceDAO pl = new PlaceDAOImpl();


        List<Place> places = pl.getAll();



        for(Place place : places)
        {
            System.out.println("id: " + place.getPlaceId() + ", Name: " + place.getPlaceName() + ", Address: " + place.getPlaceAddress());

        }




    }
}

