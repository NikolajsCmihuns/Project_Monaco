package MaximPackage.Database;

import com.monaco.Database.CityDAOInterface;
import com.monaco.Database.CountryDAOInterface;
import com.monaco.Entities.City;
import MaximPackage.ConsolePackage.ConsoleOutput;

import MaximPackage.ConsolePackage.EConsoleMessages;
import com.monaco.Database.CityDAOImplementation;
import com.monaco.Entities.Country;
import com.monaco.MVC.SpringConfig;
import lv.javaguru.java2.database.DBException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CityDAOImplementationTest {

    @Autowired
    private CityDAOInterface cityDAO;

    @Autowired
    private CountryDAOInterface countryDao;

    @Test
    public void testGetCityByID() throws Exception {
        City city = cityDAO.getCityByID(301);
        ConsoleOutput.printObject(city);
        assertEquals(401, city.getCountryID());
    }

    @Test
    public void testGetAllCitiesForCountryID() throws Exception {
        Country country = countryDao.getCountryByID(401);
        ConsoleOutput.printListContent(country.getCities(),EConsoleMessages.WELCOME_MESSAGE);
        assertEquals(5, country.getCities().size());
    }

    @Test
    public void testGetIDByCityName() throws Exception {
        int cityID = cityDAO.getIDByCityName("Riga");
        ConsoleOutput.printObject(cityID);
        assertEquals(301, cityID);
    }
}