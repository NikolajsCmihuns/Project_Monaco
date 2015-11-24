package MaximPackage.Database;

import MaximPackage.City;

import MaximPackage.User;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@Component
public class CityDAOImplementation extends DAOImpl implements CityDAOInterface {

    @Override
    public City getCityByID(int id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from CITY_REF where CITY_NAME_ID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            City city = null;
            if (resultSet.next()) {
                city = composeCityFromResultsSet(resultSet);
            }
            return city;
        } catch (Throwable e) {
            System.out.println("Exception while executing getCityByID().");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<City> getAllCitiesForCountryID(int countryID) throws DBException {
        Connection connection = null;

        ArrayList<City> listOfCities = new ArrayList<>();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from CITY_REF where CITY_COUNTRY_ID LIKE ?");
            preparedStatement.setInt(1, countryID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                City city = composeCityFromResultsSet(resultSet);
                listOfCities.add(city);
            }

            return listOfCities;
        } catch (Throwable e) {
            System.out.println("Exception while executing getIDByCityName().");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public int getIDByCityName(String cityName) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from CITY_REF where CITY_NAME LIKE ?");
            preparedStatement.setString(1, cityName);
            ResultSet resultSet = preparedStatement.executeQuery();
            City city = null;
            if (resultSet.next()) {
                city = composeCityFromResultsSet(resultSet);
            }
            return city.getCityNameID();
        } catch (Throwable e) {
            System.out.println("Exception while executing getIDByCityName().");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    private City composeCityFromResultsSet(ResultSet resultsSet) throws DBException {
        City city;
        try {
            city = new City(resultsSet.getString("CITY_NAME"), resultsSet.getInt("CITY_NAME_ID"), resultsSet.getInt("CITY_COUNTRY_ID"));
        } catch (Throwable e) {
            System.out.println("Exception while composing city from results set!");
            e.printStackTrace();
            throw new DBException(e);
        }

        return city;
    }
}
