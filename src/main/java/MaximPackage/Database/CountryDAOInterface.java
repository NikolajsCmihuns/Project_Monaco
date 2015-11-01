package MaximPackage.Database;

import MaximPackage.Country;
import lv.javaguru.java2.database.DBException;

import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

public interface CountryDAOInterface {
    Country getCountryByID(int id) throws DBException;

    int getIDByCountryName(String countryName) throws DBException;

    List<Country> getAllCountries() throws DBException;
}
