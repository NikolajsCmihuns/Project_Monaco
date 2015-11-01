package MaximPackage.Database;

import MaximPackage.City;
import MaximPackage.ConsolePackage.ConsoleOutput;

import MaximPackage.ConsolePackage.EConsoleMessages;
import lv.javaguru.java2.database.DBException;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.easymock.EasyMock.mock;
import static org.junit.Assert.assertEquals;

/**
 * Created by maksimspuskels on 01/11/15.
 */
public class CityDAOImplementationTest {

    CityDAOImplementation cityDAO = new CityDAOImplementation();

    @Before
    public void setUp() throws DBException {

    }

    @Test
    public void testGetCityByID() throws Exception {
        City city = cityDAO.getCityByID(301);
        ConsoleOutput.printObject(city);
        assertEquals(401, city.getCountryID());
    }

    @Test
    public void testGetAllCitiesForCountryID() throws Exception {
        List<City> allCities = cityDAO.getAllCitiesForCountryID(401);
        ConsoleOutput.printListContent(allCities,EConsoleMessages.WELCOME_MESSAGE);
        assertEquals(5, allCities.size());
    }

    @Test
    public void testGetIDByCityName() throws Exception {
        int cityID = cityDAO.getIDByCityName("Riga");
        ConsoleOutput.printObject(cityID);
        assertEquals(301, cityID);
    }
}