package MaximPackage.Database;

import MaximPackage.City;
import MaximPackage.Country;
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
public class CountryDAOImplementation extends DAOImpl implements CountryDAOInterface {

    @Override
    public Country getCountryByID(int id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from COUNTRY_REF where COUNTRY_NAME_ID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Country country = null;
            if (resultSet.next()) {
                country = composeCountryFromResultsSet(resultSet);
            }
            return country;
        } catch (Throwable e) {
            System.out.println("Exception while executing getCountryByID().");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public int getIDByCountryName(String countryName) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from COUNTRY_REF where COUNTRY_NAME LIKE ?");
            preparedStatement.setString(1, countryName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Country country = null;
            if (resultSet.next()) {
                country = composeCountryFromResultsSet(resultSet);
            }
            return country.getCountryNameID();
        } catch (Throwable e) {
            System.out.println("Exception while executing getIDByCountryName().");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Country> getAllCountries() throws DBException {
        Connection connection = null;

        ArrayList<Country> listOfCountries = new ArrayList<>();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from COUNTRY_REF");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Country country = composeCountryFromResultsSet(resultSet);
                listOfCountries.add(country);
            }

            return listOfCountries;
        } catch (Throwable e) {
            System.out.println("Exception while executing getAllCountries().");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    private Country composeCountryFromResultsSet(ResultSet resultsSet) throws DBException {
        Country country;
        try {
            country = new Country(resultsSet.getString("COUNTRY_NAME"), resultsSet.getInt("COUNTRY_NAME_ID"));
        } catch (Throwable e) {
            System.out.println("Exception while composing country from results set!");
            e.printStackTrace();
            throw new DBException(e);
        }

        return country;
    }
}
