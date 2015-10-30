package MaximPackage.Services;

import MaximPackage.Database.UserDAOInterface;
import MaximPackage.User;
import lv.javaguru.java2.database.DBException;

import javax.servlet.http.HttpSession;

/**
 * Created by maksimspuskels on 29/10/15.
 */

public class LoginService {
    private final UserDAOInterface userDao;

    public LoginService(UserDAOInterface userDao) {
        this.userDao = userDao;
    }

    public boolean tryLogin(String nickName, String password, HttpSession session) {
        boolean loginSuccessful = false;

        if (nickName != null && nickName.length() > 0) {
            User userFromDB = null;
            try {
                userFromDB = userDao.getUserByNickname(nickName);
                if (userFromDB != null) {
                    String userPassword = userFromDB.getPassword();

                    if (userPassword != null && password != null && password.equalsIgnoreCase(userPassword)) {
                        loginSuccessful = true;
                        session.setAttribute("userID", userFromDB.getUserID());
                    }
                }
            } catch (DBException e) {
                e.printStackTrace();
            }
        }

        return loginSuccessful;
    }
}
