package MaximPackage.Database;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by maksimspuskels on 25/10/15.
 */

public class PlaceDAOImplementationTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private PlaceDAOImplementation placeDAO = new PlaceDAOImplementation();

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreatePlace() throws Exception {
//        Place place = new Place(5.4432, 5.123, "Riga" , "Latvia", "Doma baznica", "Doma laukums");
//        // Create place
//        placeDAO.createPlace(place);
//        Place placeFromDB = placeDAO.getPlaceById(place.getPlaceID());
//        // Get from DB
//        assertEquals(place, placeFromDB);
//        ConsoleOutput.printObject(placeFromDB);
    }
}