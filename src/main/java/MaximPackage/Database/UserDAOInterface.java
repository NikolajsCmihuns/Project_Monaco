package MaximPackage.Database;

import lv.javaguru.java2.database.DBException;

import MaximPackage.User;
import java.util.List;

/**
 * Created by maksimspuskels on 23/10/15.
 */

public interface UserDAOInterface {

    void createUser(User user) throws DBException;

    User getUserByID(int id) throws DBException;

    User getUserByNickname(String nickname) throws DBException;
}
