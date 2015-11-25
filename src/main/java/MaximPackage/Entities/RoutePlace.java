package MaximPackage.Entities;

/**
 * Created by maksimspuskels on 18/10/15.
 * This class is subclass of Place class.
 * It is structured like this in order to separate single place from place that is used in route.
 * We require some more information for place that is used in the route (like routeID)
 */
public class RoutePlace extends Place {


    public RoutePlace(double latitude, double longitude, String city, String country, String placeName, String placeAddress) {
        super(latitude, longitude, city, country, placeName, placeAddress);
    }
}