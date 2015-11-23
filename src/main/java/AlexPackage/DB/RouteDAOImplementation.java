package AlexPackage.DB;

import AlexPackage.DB.Domain.Route;
import AlexPackage.DB.Helper.Coordinates;
import AlexPackage.DB.Helper.Country;
import AlexPackage.DB.Helper.Tags;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Aborigens on 07-Nov-15.
 */
@Component
public class RouteDAOImplementation extends DAOImpl implements RouteDAOInterface {

    private final String SELECT_COUNTRY_NAME = "SELECT COUNTRY_NAME, COUNTRY_SHORT_NAME FROM COUNTRY_REF";
    private final String SELECT_TAG_NAME_ID = "SELECT TAG_NAME_ID, TAG_NAME FROM TAGS_REF";

    private final String SAVE_TO_ROUTE_TABLE = "INSERT INTO ROUTE VALUES (default, ?, 0, ?, ?, 1)";
    private final String SAVE_TO_PLACES_IN_ROUTE_TABLE = "INSERT INTO PLACES_IN_ROUTE VALUES (?, ?, ?)";
    private final String SAVE_TO_PLACE_TABLE = "INSERT INTO PLACE VALUES (default, ?, ?, null, 'null', 'null', null)";

    public RouteDAOImplementation() {

    }

    @Override
    public List<Country> getCountryList() throws DBException {

        Connection connection = null;
        List<Country> countryList = new ArrayList<>();
        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNTRY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(resultSet.getString("COUNTRY_SHORT_NAME"), resultSet.getString("COUNTRY_NAME"));
                countryList.add(country);
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.getCountryList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return countryList;
    }

    @Override
    public List<Tags> getTagsList() throws DBException {

        List<Tags> tags = new ArrayList<>();
        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAG_NAME_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tags tag = new Tags(Integer.parseInt(resultSet.getString("TAG_NAME_ID")), resultSet.getString("TAG_NAME"));
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

    private ArrayList<Coordinates> processCoordinates(String route) {

        ArrayList<Coordinates> routeCoordinates = new ArrayList<>();

        String[] routeCoordinateCortege = route.split(",");
        for (int i = 0; i < routeCoordinateCortege.length; i++) {
            String[] coordinateCortege = routeCoordinateCortege[i].split("\\|");
            Coordinates coordinates = new Coordinates(coordinateCortege[0], coordinateCortege[1], String.valueOf(i));
            routeCoordinates.add(coordinates);
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

    private ResultSet saveRouteDetails(Coordinates cortege, Connection connection) {

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
                ArrayList<Coordinates> routeCoordinates = processCoordinates(route.getRoute());
                Iterator<Coordinates> iterator = routeCoordinates.iterator();
                while (iterator.hasNext()) {
                    Coordinates cortege = iterator.next();
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
}






















