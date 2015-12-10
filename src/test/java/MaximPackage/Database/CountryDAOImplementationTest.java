package MaximPackage.Database;

import MaximPackage.ConsolePackage.ConsoleOutput;
import MaximPackage.ConsolePackage.EConsoleMessages;
import com.monaco.Entities.Country;

import com.monaco.Database.CountryDAOInterface;
import com.monaco.MVC.SpringConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CountryDAOImplementationTest {

    @Autowired
    private CountryDAOInterface countryDAO;

    @Test
    public void testGetCountryByID() throws Exception {
        Country country = countryDAO.getCountryByID(401);
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