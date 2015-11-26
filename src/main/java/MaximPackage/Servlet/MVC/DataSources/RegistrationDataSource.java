package MaximPackage.Servlet.MVC.DataSources;

import MaximPackage.Database.CityDAOImplementation;
import MaximPackage.Database.CountryDAOImplementation;
import MaximPackage.Database.TagDAOImplementation;
import MaximPackage.Entities.City;
import MaximPackage.Entities.Country;
import MaximPackage.Entities.Tag;
import lv.javaguru.java2.database.DBException;

import java.util.List;

/**
 * Created by maksimspuskels on 26/11/15.
 */
public class RegistrationDataSource {
    private List<City> allCities;
    private List<Country> allCountries;
    private List<Tag> allTags;

    public RegistrationDataSource() {
        initialize();
    }

    private void initialize() {
        try {
            CityDAOImplementation cityDAO = new CityDAOImplementation();
            allCities = cityDAO.getAllCitiesForCountryID(401);

            CountryDAOImplementation countryDAO = new CountryDAOImplementation();
            allCountries = countryDAO.getAllCountries();

            TagDAOImplementation tagDAO = new TagDAOImplementation();
            allTags = tagDAO.getAllTags();
        }
        catch (DBException e) {
            e.printStackTrace();
        }
    }
    public List<City> getAllCities() {
        return allCities;
    }

    public List<Tag> getAllTags() {
        return allTags;
    }

    public List<Country> getAllCountries() {
        return allCountries;
    }
}
