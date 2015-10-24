package MaximPackage.Database;

import MaximPackage.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by maksimspuskels on 24/10/15.
 */
public class UserDAOImplementationTest {

    private UserDAOImplementation userDAO = new UserDAOImplementation();

    @Test
    public void testCreate() throws Exception {
        // Create user
        User user = new User("Tourist", "t@email.com", "Riga", "Latvia","pass");
        userDAO.create(user);
    }
}



