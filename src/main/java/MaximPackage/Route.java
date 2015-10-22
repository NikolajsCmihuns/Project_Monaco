package MaximPackage;

import java.util.ArrayList;

/**
 * Created by maksimspuskels on 18/10/15.
 */

public class Route {

    private Integer routeID;

    // Non mandatory fields that should be calculated
    // depending on the places initialized
    private double distance;
    private double completionTime;

    private String routeTag;

    private ArrayList<Place> places;

    public Route(Integer routeID, String routeTag, ArrayList<Place> places) {
        this.routeID = routeID;
        this.routeTag = routeTag;
        this.places = places;

        calculateRouteMetricsFromArrayList(places);
    }

    private void calculateRouteMetricsFromArrayList(ArrayList<Place> places) {
        // loop thought places
        // get coordinates
        // using API try to gather distance and length
    }

    @Override
    public String toString() {
        return "-== ROUTE ==-" + "\n"  + routeID + "\n" +  routeTag + "" + "\n" + places + "\n" + "-========-";
    }
}
