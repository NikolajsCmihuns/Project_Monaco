package MaximPackage.Database;

import com.monaco.Database.TagDAOInterface;
import com.monaco.Database.UserDAOInterface;
import com.monaco.Entities.Tag;
import com.monaco.Entities.User;
import com.monaco.MVC.SpringConfig;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by maksimspuskels on 24/10/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserDAOImplementationTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    @Autowired
    private UserDAOInterface userDAO;

    @Autowired
    private TagDAOInterface tagDao;

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        // Create user
        User user = new User("Tourist", "t@email.com", 301, 401,"pass");
        user.setUserTagID(102);
        // Save user to DB
        userDAO.createUser(user);
        // Get user from DB
        Optional<User> userFromDB = userDAO.getUserByID(user.getUserID().get());
        // If user was successfully saved we should get it back
        if (userFromDB.isPresent()) {
            // user id is auto-generated so we must set assigned user id to original User entity
            user.setUserID(userFromDB.get().getUserID());
        }
        // We expect two users to be equal
        assertEquals(Optional.of(user), userFromDB);
    }

    @Test
    public void testCreateFailureTest() throws Exception {
        // Create user
        User user = new User("Tourist", "t@email.com", 301, 401,"pass");
        user.setUserTagID(101);
        userDAO.createUser(user);
        // Get user from DB
        Optional<User> userFromDB = userDAO.getUserByID(user.getUserID().get());
        // Two instances should not be equal as original does not have auto-gen userID
        assertNotEquals(user, userFromDB);
    }

    @Test
    public void testUserTagRelation() throws Exception {
        // Create user
        User user = new User("Tourist", "t@email.com", 301, 401,"pass");
        // assign tag to user
        user.setUserTagID(102);
        // Save user to DB
        userDAO.createUser(user);
        // Get user from DB so tag gets fetched together
        Optional<User> userFromDB = userDAO.getUserByID(user.getUserID().get());
        // If user was successfully saved we should get it back
        if (userFromDB.isPresent()) {
            // user id is auto-generated so we must set assigned user id to original User entity
            user.setUserID(userFromDB.get().getUserID());
        }
        // Get the same tag from reference table
        Tag assignedTag = tagDao.getTagByID(102);
        // We expect two tags to be equal
        assertEquals(assignedTag, userFromDB.get().getTag());
    }
}



