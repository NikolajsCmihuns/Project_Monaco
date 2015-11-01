package MaximPackage.Database;

import MaximPackage.ConsolePackage.ConsoleOutput;
import MaximPackage.User;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by maksimspuskels on 24/10/15.
 */

public class UserDAOImplementationTest {
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private UserDAOImplementation userDAO = new UserDAOImplementation();

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        // Create user
        User user = new User("Tourist", "t@email.com", 301, 401,"pass");
        user.setUserTagID(101);
        userDAO.createUser(user);
        User userFromDB = userDAO.getUserByID(user.getUserID());
        // Get user from DB
        assertEquals(user,userFromDB);
        ConsoleOutput.printObject(userFromDB);
    }

    @Test
    public void testCreateFailureTest() throws Exception {
        // Create user
        User user = new User("Tourist", "t@email.com", 301, 401,"pass");
        user.setUserTagID(101);
        userDAO.createUser(user);
        // Get user from DB
        User userFromDB = userDAO.getUserByID(user.getUserID());
        // Modify user
        user.setEmail("wrong_email");
        // Two instances should not be equal
        assertNotEquals(user, userFromDB);
        ConsoleOutput.printObject(userFromDB);
    }
}



