package MaximPackage.Services;

import MaximPackage.Database.UserDAOInterface;
import MaximPackage.Entities.User;
import lv.javaguru.java2.database.DBException;

import java.util.Optional;

/**
 * Created by maksimspuskels on 29/10/15.
 */

public class LoginService {
    private final UserDAOInterface userDao;

    public LoginService(UserDAOInterface userDao) {
        this.userDao = userDao;
    }

    // On success should return logged user ID
    public Optional<Integer> tryLogin(String nickName, String password) {
        Optional<Integer> loggedUserID = Optional.of(User.USER_NOT_FOUND);

        if (nickName != null && nickName.length() > 0) {
            User userFromDB = null;
            try {
                userFromDB = userDao.getUserByNickname(nickName);
                if (userFromDB != null) {
                    String userPassword = userFromDB.getPassword();

                    if (userPassword != null && password != null && password.equalsIgnoreCase(userPassword)) {
                        loggedUserID = userFromDB.getUserID();
                    }
                }
            } catch (DBException e) {
                e.printStackTrace();
            }
        }

        return loggedUserID;
    }
}
