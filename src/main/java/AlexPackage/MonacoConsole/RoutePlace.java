package AlexPackage.MonacoConsole;

import java.util.ArrayList;

/**
 * Created by Aborigens on 23-Oct-15.
 */
public class RoutePlace {

    private int id;
    private String routeName;
    private String placeCountry;
    private String placeCity;
    private String placeName;
    private ArrayList<RoutePlace> routePlace;


    public RoutePlace(int id, String routeName, String placeCountry, String placeCity, String placeName) {
        this.id = id;
        this.routeName = routeName;
        this.placeCountry = placeCountry;
        this.placeCity = placeCity;
        this.placeName = placeName;
        this.routePlace = new ArrayList<>();
    }

    public void addRoutePlace(RoutePlace routePlace) {
        this.routePlace.add(routePlace);
    }

    public RoutePlace getRoutePlace(int index, RoutePlace currentLevelRoutPlace) {

        RoutePlace currentNode = currentLevelRoutPlace;
        int counter = 0;
        if (routePlace.size() != 0) {
            while (counter < index) {
                currentNode = currentNode.getRoutePlace(0);
                counter++;
            }
        }

        return currentNode;
    }

    public RoutePlace getRoutePlace(int index) {
        return this.routePlace.get(index);
    }

    public String getPlaceName() {
        return placeName;
    }

    public int getRoutePlaceSize() {
        return this.routePlace.size();
    }

}
