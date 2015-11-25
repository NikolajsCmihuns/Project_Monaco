package MaximPackage.Database;

import MaximPackage.Entities.City;
import lv.javaguru.java2.database.DBException;

import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

public interface CityDAOInterface {

    City getCityByID(int id) throws DBException;

    int getIDByCityName(String cityName) throws DBException;

    List<City> getAllCitiesForCountryID(int countryID) throws DBException;
}