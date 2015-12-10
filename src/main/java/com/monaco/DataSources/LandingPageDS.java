package com.monaco.DataSources;

import com.monaco.Database.UserDAOInterface;
import com.monaco.Entities.User;
import lv.javaguru.java2.database.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by maksimspuskels on 26/11/15.
 */

@Component
public class LandingPageDS {

    @Autowired
    private UserDAOInterface userDAO;

    public LandingPageDS() { }

    private String userNickname;

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void updateUserNicknameFromUserID(Integer userID) {
        try {
            Optional<User> userFromDB = userDAO.getUserByID(userID);
            userNickname = userFromDB.get().getNickname();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
