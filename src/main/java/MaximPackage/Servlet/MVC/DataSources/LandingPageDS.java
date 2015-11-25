package MaximPackage.Servlet.MVC.DataSources;

import MaximPackage.Database.UserDAOImplementation;
import MaximPackage.Entities.User;
import lv.javaguru.java2.database.DBException;

import java.util.Optional;

/**
 * Created by maksimspuskels on 26/11/15.
 */

public class LandingPageDS {
    private String userNickname;

    public LandingPageDS(Optional<Integer> userID) {
        UserDAOImplementation userDAO = new UserDAOImplementation();
        try {
            User userFromDB = userDAO.getUserByID(userID.get());
            userNickname = userFromDB.getNickname();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public String getUserNickname() {
        return userNickname;
    }
}
