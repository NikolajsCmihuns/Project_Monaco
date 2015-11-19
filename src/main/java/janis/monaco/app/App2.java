package janis.monaco.app;


import janis.monaco.database.PlaceDAO;
import janis.monaco.database.place.PlaceDAOImpl;
import janis.monaco.domain.entities.Place;

import java.util.List;


/**
 * Created by janis on 11/2/15.
 */
public class App2 {
    public static void main(String[] args){




        PlaceDAO pl = new PlaceDAOImpl();

        Place place = pl.getRequired(-2);


            System.out.println("id: " + place.getPlaceId() + ", Name: " + place.getPlaceName() + ", Address: " + place.getPlaceAddress());






    }
}

