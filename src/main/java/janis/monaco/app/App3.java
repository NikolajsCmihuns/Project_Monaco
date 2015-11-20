package janis.monaco.app;


import janis.monaco.database.PlaceDAO;
import janis.monaco.database.place.PlaceDAOImpl;
import janis.monaco.domain.Place;


/**
 * Created by janis on 11/2/15.
 */
public class App3 {
    public static void main(String[] args){




        PlaceDAO pl = new PlaceDAOImpl();

        Place place = pl.getById(2);


            System.out.println("id: " + place.getPlaceId() + ", Name: " + place.getPlaceName() + ", Address: " + place.getPlaceAddress());






    }
}

