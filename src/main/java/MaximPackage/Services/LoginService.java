package MaximPackage.Services;

import MaximPackage.Database.UserDAOInterface;
import MaximPackage.Entities.User;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by maksimspuskels on 29/10/15.
 */

@Component
public class LoginService extends DAOImpl {

    @Autowired
    UserDAOInterface userDao;

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
