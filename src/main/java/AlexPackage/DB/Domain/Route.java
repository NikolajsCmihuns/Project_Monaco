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

    public Route() {

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

    public String getRouteCountry() {
        return routeCountry;
    }

    public String getRouteCity() {
        return routeCity;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Route ID: = " + routeId + "\n" +
                "Route Distance: = " + distance + "\n" +
                "Route Tag: = " + routeTag + "\n" +
                "Places Coordintaes: = " + route;
    }

    public void setRouteCountry(String routeCountry) {
        this.routeCountry = routeCountry;
    }

    public void setRouteCity(String routeCity) {
        this.routeCity = routeCity;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public void setRouteTag(String routeTag) {
        this.routeTag = routeTag;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
