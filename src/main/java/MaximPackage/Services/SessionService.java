package MaximPackage.Services;

import MaximPackage.Database.UserDAOImplementation;
import MaximPackage.User;
import lv.javaguru.java2.database.DBException;

/**
 * Created by maksimspuskels on 29/10/15.
 */
public class SessionService {
    private static SessionService ourInstance = new SessionService();

    public static SessionService getInstance() {
        return ourInstance;
    }

    private Integer userId;

    private SessionService() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        String foundNickName = "";
        if (getUserId() != null) {
            UserDAOImplementation userDao = new UserDAOImplementation();
            try {
                User userFromDB = userDao.getUserByID(getUserId());
                if (userFromDB != null) {
                    foundNickName = userFromDB.getNickname();
                }
            } catch (DBException e) {
                e.printStackTrace();
            }
        }
        return foundNickName;
    }
}
