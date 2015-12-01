package AlexPackage.DB.Domain;

/**
 * Created by Aborigens on 12-Nov-15.
 */
public class Route {

    private String routeCountry;
    private String routeCity;
    private String routeName;
    private String routeTag;
    private String route;
    private String distance;
    private String routeId;

    public Route(String routeCountry, String routeCity, String routeName, String routeTag, String route, String distance) {
        this.routeCountry = routeCountry;
        this.routeCity = routeCity;
        this.routeName = routeName;
        this.routeTag = routeTag;
        this.route = route;
        this.distance = distance;
    }

    public String getRouteCountry() {
        return routeCountry;
    }

    public String getRouteCity() {
        return routeCity;
    }

    public String getRouteName() {
        return routeName;
    }

    public String getRouteTag() {
        return routeTag;
    }

    public String getRoute() {
        return route;
    }

    public String getDistance() {
        return distance;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
