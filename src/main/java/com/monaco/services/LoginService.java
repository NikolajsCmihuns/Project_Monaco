package com.monaco.services;

import com.monaco.database.UserDAOInterface;
import com.monaco.entities.User;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by maksimspuskels on 29/10/15.
 */

@Component
public class LoginService extends DAOImpl implements LoginServiceInterface {

    @Autowired
    UserDAOInterface userDao;

    @Override
    // On success should return logged user entity
    public Optional<User> tryLogin(String nickName, String password) throws DBException {
        Optional<User> loggedUser = Optional.empty();

        if (nickName != null && nickName.length() > 0) {
            try {
                Optional<User> userFromDB = userDao.getUserByNickname(nickName);

                if (userFromDB.isPresent()) {
                    String userPassword = userFromDB.get().getPassword();

                    if (userPassword != null && password != null && password.equalsIgnoreCase(userPassword)) {
                        loggedUser = userFromDB;
                    }
                }
            } catch (DBException e) {
                e.printStackTrace();
                throw new DBException("Something went wrong on getting data from DB!");
            }
        }

        return loggedUser;
    }
}
