package AlexPackage.DB;

import AlexPackage.DB.Domain.Route;
import AlexPackage.DB.Helper.HelperCountry;
import AlexPackage.DB.Helper.HelperPlace;
import AlexPackage.DB.Helper.HelperTags;
import lv.javaguru.java2.database.DBException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Aborigens on 07-Nov-15.
 */
public interface RouteDAOInterface {

    List<HelperCountry> getCountryList() throws DBException;

    List<HelperTags> getTagsList() throws DBException;

    List<Route> getRoutesIds(String routeTag) throws DBException;

    List<Route> getUserRoutes(Optional<Integer> userId) throws DBException;

    Map<String, List> getPlaceIdsSequence(List<Route> routesIdsDistance) throws DBException;

    List<Route> gerRouteIdCoordinates(Map<String, List> helperPlaces, List<Route> routesIdsDistance) throws DBException;

    String getTagById(String chosenTag) throws DBException;

    boolean saveRoute(Route route) throws DBException;

    void deleteRoutesMass(String[] routesToDeleteIds) throws DBException;

}
