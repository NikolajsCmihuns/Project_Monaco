package AlexPackage;

import java.util.List;

/**
 * Created by Aborigens on 24-Oct-15.
 */
public class CreateRoute implements Execute {

    @Override
    public void execute() {

        List<Place> places = new HelperFile().getPlaces(SystemMessages.FILE_PLACE.getString());
        RoutePlace route = new RoutePlace(0, null, null, null, null);

        int depthLevel = 1;
        for (Place place : places) {
            if (route.getRoutePlaceSize() == 0) {
                route.addRoutePlace(new RoutePlace(place.getId(),
                        "Testing Route",
                        place.getPlaceCountry(),
                        place.getPlaceCity(),
                        place.getPlaceName()));
            } else {
                RoutePlace routePlace = route.getRoutePlace(depthLevel, route);
                routePlace.addRoutePlace(new RoutePlace(place.getId(),
                        "Testing Route",
                        place.getPlaceCountry(),
                        place.getPlaceCity(),
                        place.getPlaceName()));
                depthLevel++;
            }

        }

        new Output().output(SystemMessages.SUCCESS.getString());

    }
}
