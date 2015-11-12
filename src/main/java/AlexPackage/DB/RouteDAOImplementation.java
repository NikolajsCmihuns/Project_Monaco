package AlexPackage.DB;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Aborigens on 07-Nov-15.
 */
public class RouteDAOImplementation implements RouteDAOInterface {

    private final DAO dao;
    private Connection connection;

    public RouteDAOImplementation() {
        this.dao = new DAOImpl();
    }

    private Connection getConnection() throws DBException {
        return dao.getConnection();
    }

    private void closeConnection(Connection connection) throws DBException {
        dao.closeConnection(connection);
    }

    @Override
    public List<Country> getCountryList() throws DBException {

        Map<String, String> countryShortName = new HashMap<>();

        countryShortName.put("Estonia", "EE");
        countryShortName.put("Latvia", "LV");
        countryShortName.put("Lithuania", "LT");
        countryShortName.put("Monaco", "MC");

        List<Country> countryList = new ArrayList<>();
        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNTRY_NAME FROM COUNTRY_REF");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(countryShortName.get(resultSet.getString("COUNTRY_NAME")), resultSet.getString("COUNTRY_NAME"));
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

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT TAG_NAME_ID, TAG_NAME FROM TAGS_REF");
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

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public boolean saveRoute(Route route) throws DBException {

        boolean saved = false;

        try {
            connection = getConnection();

            String saveToRouteTable = "INSERT INTO ROUTE VALUES (default, ?, 0, ?, ?, 1)";
            PreparedStatement preparedStatement = connection.prepareStatement(saveToRouteTable, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, route.getDistance());
            preparedStatement.setString(2, route.getRouteTag());
            preparedStatement.setString(3, getCurrentDate());
            preparedStatement.executeUpdate();

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






















