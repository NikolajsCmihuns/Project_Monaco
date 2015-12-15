package AlexPackage.DB.Domain;

import janis.monaco.domain.*;

/**
 * Created by Aborigens on 15-Dec-15.
 */
public class RouteBuilder {

    private String routeCountry;
    private String routeCity;
    private String routeName;
    private String routeTag;
    private String route;
    private String distance;
    private String routeId;

    private RouteBuilder() {

    }

    public static RouteBuilder createRoute() {
        return new RouteBuilder();
    }

    public RouteBuilder withRouteCountry(String routeCountry) {
        this.routeCountry = routeCountry;
        return this;
    }

    public RouteBuilder withRouteCity(String routeCity) {
        this.routeCity = routeCity;
        return this;
    }

    public RouteBuilder withRouteName(String routeName) {
        this.routeName = routeName;
        return this;
    }

    public RouteBuilder withRouteTag(String routeTag) {
        this.routeTag = routeTag;
        return this;
    }

    public RouteBuilder withRoute(String route) {
        this.route = route;
        return this;
    }

    public RouteBuilder withRouteDistance(String routeDistance) {
        this.distance = routeDistance;
        return this;
    }

    public RouteBuilder withRouteId(String routeId) {
        this.routeId = routeId;
        return this;
    }

    public Route build() {
        Route routeToWalk = new Route();
        routeToWalk.setRouteCountry(routeCountry);
        routeToWalk.setRouteCity(routeCity);
        routeToWalk.setRouteName(routeName);
        routeToWalk.setRouteTag(routeTag);
        routeToWalk.setRoute(route);
        routeToWalk.setDistance(distance);
        routeToWalk.setRouteId(routeId);

        return routeToWalk;
    }

}
