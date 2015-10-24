package MaximPackage.Database;

import lv.javaguru.java2.database.DBException;

import MaximPackage.User;
import java.util.List;

/**
 * Created by maksimspuskels on 23/10/15.
 */

public interface UserDAOInterface {

    void create(User user) throws DBException;

//    User getById(Long id) throws DBException;
//
//    List<User> getAll() throws DBException;
}
