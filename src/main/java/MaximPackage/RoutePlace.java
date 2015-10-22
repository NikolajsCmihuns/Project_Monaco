package MaximPackage;

/**
 * Created by maksimspuskels on 18/10/15.
 * This class is subclass of Place class.
 * It is structured like this in order to separate single place from place that is used in route.
 * We require some more information for place that is used in the route (like routeID)
 */
public class RoutePlace extends Place {


    public RoutePlace(Integer placeID, double latitude, double longitude, Object city, Object country, String placeName, String placeAddress) {
        super(placeID, latitude, longitude, city, country, placeName, placeAddress);
    }
}