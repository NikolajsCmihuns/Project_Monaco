package com.monaco.Services;

import com.monaco.Entities.User;
import lv.javaguru.java2.database.DBException;

import java.util.Optional;

/**
 * Created by maksimspuskels on 06/12/15.
 */
public interface LoginServiceInterface {
    Optional<User> tryLogin(String nickName, String password) throws DBException;
}
