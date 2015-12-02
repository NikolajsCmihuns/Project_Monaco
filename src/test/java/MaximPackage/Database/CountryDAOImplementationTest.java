package MaximPackage.Database;

import MaximPackage.ConsolePackage.ConsoleOutput;
import MaximPackage.ConsolePackage.EConsoleMessages;
import MaximPackage.Entities.Country;
import com.monaco.Database.CountryDAOImplementation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by maksimspuskels on 01/11/15.
 */


public class CountryDAOImplementationTest {

    @Autowired
    CountryDAOImplementation countryDAO;
//    CountryDAOImplementation countryDAO = new CountryDAOImplementation();

    @Test
    public void testGetCountryByID() throws Exception {
        Country country = countryDAO.getCountryByID(401);
        ConsoleOutput.printObject(country);
        assertEquals("Latvia", country.getCountryName());
    }

    @Test
    public void testGetIDByCountryName() throws Exception {
        int countryID = countryDAO.getIDByCountryName("Latvia");
        ConsoleOutput.printObject(Integer.valueOf(countryID));
        assertEquals(401, countryID);
    }

    @Test
    public void testGetAllCountries() throws Exception {
        List<Country> countries = countryDAO.getAllCountries();
        ConsoleOutput.printListContent(countries, EConsoleMessages.WELCOME_MESSAGE);
        assertEquals(4, countries.size());
    }
}