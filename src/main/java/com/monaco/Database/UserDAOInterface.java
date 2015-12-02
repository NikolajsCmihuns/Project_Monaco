package com.monaco.Database;

import com.monaco.Entities.User;
import lv.javaguru.java2.database.DBException;

import java.util.Optional;

/**
 * Created by maksimspuskels on 23/10/15.
 */

public interface UserDAOInterface {

    void createUser(User user) throws DBException;

    User getUserByID(int id) throws DBException;

    Optional<User> getUserByNickname(String nickname) throws DBException;
}
