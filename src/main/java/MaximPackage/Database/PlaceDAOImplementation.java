package MaximPackage.Database;

import MaximPackage.Place;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by maksimspuskels on 25/10/15.
 */

@Component
public class PlaceDAOImplementation extends DAOImpl implements PlaceDAOInterface {

    public void createPlace(Place place) throws DBException {
        if (place == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into PLACES values (default, ?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setDouble(1, place.getLatitude());    /* Latitude char */
            preparedStatement.setDouble(2, place.getLongitude());   /* Longitude char */
            preparedStatement.setObject(3, place.getCity());        /* City char */
            preparedStatement.setObject(4, place.getCountry());     /* Country char */
            preparedStatement.setString(5, place.getImageUrl());    /* ImageURL char */
            preparedStatement.setString(6, place.getPlaceName());   /* PlaceName INT */
            preparedStatement.setString(7, place.getPlaceAddress());/* PlaceAddress char */

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                place.setPlaceID(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing PlaceDAOImplementation.createPlace()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Place getPlaceById(int id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from PLACES where PlaceID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Place place = null;
            if (resultSet.next()) {
                place = new Place(resultSet.getDouble("Latitude"), resultSet.getDouble("Longitude"), resultSet.getString("City"), resultSet.getString("Country"), resultSet.getString("PlaceName"), resultSet.getString("PlaceAddress"));
                place.setPlaceID(resultSet.getInt("PlaceID"));
                place.setImageUrl(resultSet.getString("ImageURL"));
            }
            return place;
        } catch (Throwable e) {
            System.out.println("Exception while executing PlaceDAOImplementation.getPlaceById()");
                    e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
}
