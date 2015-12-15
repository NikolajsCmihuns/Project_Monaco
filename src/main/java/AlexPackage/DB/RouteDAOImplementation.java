package AlexPackage.DB;

import AlexPackage.DB.Domain.Route;
import AlexPackage.DB.Helper.HelperCoordinates;
import AlexPackage.DB.Helper.HelperCountry;
import AlexPackage.DB.Helper.HelperPlace;
import AlexPackage.DB.Helper.HelperTags;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static AlexPackage.DB.Domain.RouteBuilder.createRoute;

/**
 * Created by Aborigens on 07-Nov-15.
 */
@Component
public class RouteDAOImplementation extends DAOImpl implements RouteDAOInterface {

    private final String SELECT_COUNTRY_NAME = "SELECT COUNTRY_NAME, COUNTRY_SHORT_NAME FROM COUNTRY_REF";
    private final String SELECT_TAG_NAME_ID = "SELECT TAG_NAME_ID, TAG_NAME FROM TAGS_REF";
    private final String SELECT_ROUTES_BY_TAG = "SELECT ROUTEID, DISTANCE FROM ROUTE WHERE routeTagID = ?";
    private final String SELECT_TAG_TEXT_BY_ID = "SELECT TAG_NAME FROM TAGS_REF WHERE TAG_NAME_ID = ?";
    private final String SELECT_PLACEID_SEQUENCE = "SELECT PLACEID, SEQNR FROM PLACES_IN_ROUTE WHERE ROUTEID = ?";
    private final String SELECT_COORDINATES_BY_PLACEID = "SELECT LATITUDE, LONGITUDE FROM PLACE WHERE PLACEID = ?";
    private final String SELECT_ROUTES_FOR_DELETION_BY_USER_ID = "SELECT ROUTEID, DISTANCE, ROUTETAGID FROM ROUTE WHERE CREATORID = ?";

    private final String SAVE_TO_ROUTE_TABLE = "INSERT INTO ROUTE VALUES (default, ?, 0, ?, ?, 1)";
    private final String SAVE_TO_PLACES_IN_ROUTE_TABLE = "INSERT INTO PLACES_IN_ROUTE VALUES (?, ?, ?)";
    private final String SAVE_TO_PLACE_TABLE = "INSERT INTO PLACE VALUES (default, ?, ?, null, 'null', 'null', null)";

    private final String DELETE_ROUTE = "DELETE FROM ROUTE WHERE ROUTEID = ?";
    private final String DELETE_PLACE_IN_ROUTE = "DELETE FROM PLACES_IN_ROUTE WHERE ROUTEID = ?";
    private final String DELETE_PLACE = "DELETE FROM PLACE WHERE PLACEID = ?";

    public RouteDAOImplementation() {

    }

    @Override
    public List<Route> getRoutesIds(String routeTag) throws DBException {
        Connection connection = null;
        List<Route> routeIDs = new ArrayList<>();

        try {

            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROUTES_BY_TAG);
            preparedStatement.setInt(1, Integer.parseInt(routeTag));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Route route = createRoute()
                        .withRouteCountry(null)
                        .withRouteCity(null)
                        .withRouteName(null)
                        .withRouteTag(routeTag)
                        .withRoute(null)
                        .withRouteDistance(resultSet.getString("DISTANCE"))
                        .withRouteId(String.valueOf(resultSet.getInt(1)))
                        .build();
                routeIDs.add(route);
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.getRoutes()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return routeIDs;
    }

    @Override
    public List<HelperCountry> getCountryList() throws DBException {

        Connection connection = null;
        List<HelperCountry> helperCountryList = new ArrayList<>();
        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNTRY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HelperCountry helperCountry = new HelperCountry(resultSet.getString("COUNTRY_SHORT_NAME"), resultSet.getString("COUNTRY_NAME"));
                helperCountryList.add(helperCountry);
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.getCountryList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return helperCountryList;
    }

    @Override
    public List<HelperTags> getTagsList() throws DBException {

        List<HelperTags> tags = new ArrayList<>();
        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAG_NAME_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HelperTags tag = new HelperTags(Integer.parseInt(resultSet.getString("TAG_NAME_ID")), resultSet.getString("TAG_NAME"));
                tags.add(tag);
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.getTagList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return tags;
    }

    private String getCurrentDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private ArrayList<HelperCoordinates> processCoordinates(String route) {

        ArrayList<HelperCoordinates> routeCoordinates = new ArrayList<>();

        String[] routeCoordinateCortege = route.split(",");
        for (int i = 0; i < routeCoordinateCortege.length; i++) {
            String[] coordinateCortege = routeCoordinateCortege[i].split("\\|");
            HelperCoordinates helperCoordinates = new HelperCoordinates(coordinateCortege[0], coordinateCortege[1], String.valueOf(i));
            routeCoordinates.add(helperCoordinates);
        }

        return routeCoordinates;
    }

    private ResultSet saveRouteDetails(Route route, Connection connection) {

        ResultSet resultSet = null;

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_TO_ROUTE_TABLE, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, route.getDistance());
            preparedStatement.setString(2, route.getRouteTag());
            preparedStatement.setString(3, getCurrentDateAndTime());

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.saveRouteDetails()");
            e.printStackTrace();
        }

        return resultSet;
    }

    private ResultSet saveRouteDetails(HelperCoordinates cortege, Connection connection) {

        ResultSet resultSet = null;

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_TO_PLACE_TABLE, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cortege.getLatitude());
            preparedStatement.setString(2, cortege.getLongitude());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.savePlaceDetails()");
            e.printStackTrace();
        }

        return resultSet;
    }

    private ResultSet saveRouteDetails(String routeId, String sequence, String placeId, Connection connection) {

        ResultSet resultSet = null;

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_TO_PLACES_IN_ROUTE_TABLE, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, routeId);
            preparedStatement.setString(2, sequence);
            preparedStatement.setString(3, placeId);

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.savePlacesInRouteDetails()");
            e.printStackTrace();
        }

        return resultSet;
    }

    @Override
    public boolean saveRoute(Route route) throws DBException {

        boolean saved = false;
        Connection connection = null;

        try {
            connection = getConnection();

            // save to route table
            ResultSet resultSet = saveRouteDetails(route, connection);
            if (resultSet.next()) {
                String routeId = String.valueOf(resultSet.getLong(1));

                // save to place & places_in_route
                ArrayList<HelperCoordinates> routeCoordinates = processCoordinates(route.getRoute());
                Iterator<HelperCoordinates> iterator = routeCoordinates.iterator();
                while (iterator.hasNext()) {
                    HelperCoordinates cortege = iterator.next();
                    resultSet = saveRouteDetails(cortege, connection);
                    if (resultSet.next()) {
                        saveRouteDetails(routeId, cortege.getSequence(), String.valueOf(resultSet.getLong(1)), connection);
                    }
                }
            }

            saved = true;

        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.saveRoute()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return saved;
    }

    @Override
    public String getTagById(String chosenTag) throws DBException {

        String chosenTagText = "";

        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAG_TEXT_BY_ID);
            preparedStatement.setInt(1, Integer.parseInt(chosenTag));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                chosenTagText = resultSet.getString("TAG_NAME");
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.getTagById(String chosenTag)");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return chosenTagText;
    }

    @Override
    public Map<String, List> getPlaceIdsSequence(List<Route> routesIdsDistance) throws DBException {

        Map<String, List> routePlaces = new HashMap<>();

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PLACEID_SEQUENCE);
            Iterator<Route> routeId = routesIdsDistance.iterator();
            while (routeId.hasNext()) {
                Route route = routeId.next();
                preparedStatement.setInt(1, Integer.parseInt(route.getRouteId()));
                ResultSet resultSet = preparedStatement.executeQuery();
                List<HelperPlace> helperPlaces = new ArrayList<>();
                while (resultSet.next()) {
                    helperPlaces.add(new HelperPlace(Integer.parseInt(resultSet.getString("PLACEID")),
                            Integer.parseInt(resultSet.getString("SEQNR"))));
                }
                routePlaces.put(route.getRouteId(), helperPlaces);
            }


        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.getPlaceIdsSequence(List<Route> routesIdsDistance)");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return routePlaces;
    }

    @Override
    public List<Route> gerRouteIdCoordinates(Map<String, List> helperPlaces, List<Route> routesIdsDistance) throws DBException {

        Connection connection = null;

        try {

            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COORDINATES_BY_PLACEID);

            Iterator<Map.Entry<String, List>> iterator = helperPlaces.entrySet().iterator();
            while (iterator.hasNext()) {

                Map.Entry currentEntry = (Map.Entry) iterator.next();

                List<HelperPlace> helperPlace = (List<HelperPlace>) currentEntry.getValue();
                Iterator<HelperPlace> helperPlaceIterator = helperPlace.iterator();
                String coordinates = "";
                while (helperPlaceIterator.hasNext()) {
                    HelperPlace sequentialPlace = helperPlaceIterator.next();

                    preparedStatement.setInt(1, sequentialPlace.getPlaceId());
                    ResultSet resultSet = preparedStatement.executeQuery();

                    String latitude = "";
                    String longitude = "";

                    while (resultSet.next()) {
                        latitude = resultSet.getString("LATITUDE");
                        longitude = resultSet.getString("LONGITUDE");
                    }

                    if ("".equals(coordinates)) {
                        coordinates = latitude + "," + longitude;
                    } else {
                        coordinates = coordinates + "|" + latitude + "," + longitude;
                    }

                }

                // assign coordinates to a route
                Iterator<Route> routesIterator = routesIdsDistance.iterator();
                while (routesIterator.hasNext()) {
                    Route route = routesIterator.next();
                    if (route.getRouteId().equals(currentEntry.getKey())) {
                        route.setRoute(coordinates);
                    }
                }

            }

        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.gerRouteIdCoordinates(Map<String, List> helperPlaces)");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return routesIdsDistance;

    }

    @Override
    public List<Route> getUserRoutes(Optional<Integer> userId) throws DBException {

        Connection connection = null;
        List<Route> userRoutes = new ArrayList<>();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROUTES_FOR_DELETION_BY_USER_ID);
            preparedStatement.setInt(1, userId.get());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Route route = createRoute()
                        .withRouteCountry(null)
                        .withRouteCity(null)
                        .withRouteName(null)
                        .withRouteTag(resultSet.getString("ROUTETAGID"))
                        .withRoute(null)
                        .withRouteDistance(resultSet.getString("DISTANCE"))
                        .withRouteId(String.valueOf(resultSet.getInt("ROUTEID")))
                        .build();
                userRoutes.add(route);
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.gerUserRoutes(Optional<Integer> userId)");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return userRoutes;
    }

    @Override
    public void deleteRoutesMass(String[] routesToDeleteIds) throws DBException {

        Connection connection = null;

        try {
            connection = getConnection();

            for (int i = 0; i < routesToDeleteIds.length; i++) {

                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PLACEID_SEQUENCE);
                preparedStatement.setInt(1, Integer.parseInt(routesToDeleteIds[i]));
                ResultSet resultSet = preparedStatement.executeQuery();

                PreparedStatement deletePlaceInRoute = connection.prepareStatement(DELETE_PLACE_IN_ROUTE);
                deletePlaceInRoute.setInt(1, Integer.parseInt(routesToDeleteIds[i]));
                deletePlaceInRoute.executeUpdate();

                PreparedStatement deleteRoute = connection.prepareStatement(DELETE_ROUTE);
                deleteRoute.setInt(1, Integer.parseInt(routesToDeleteIds[i]));
                deleteRoute.executeUpdate();

                while (resultSet.next()) {
                    PreparedStatement deletePlace = connection.prepareStatement(DELETE_PLACE);
                    deletePlace.setInt(1, Integer.parseInt(resultSet.getString("PLACEID")));
                    deletePlace.executeUpdate();
                }

            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.gerUserRoutes(Optional<Integer> userId)");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
}


















