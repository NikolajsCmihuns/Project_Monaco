package com.monaco.Services;

import com.monaco.Database.UserDAOInterface;
import com.monaco.Entities.User;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by maksimspuskels on 29/10/15.
 */

@Component
public class RegistrationService extends DAOImpl {

    @Autowired
    UserDAOInterface userDao;

    public Optional<User> tryRegistration(String nickName, String password, String email, Integer cityID, Integer countryID, String name, String surname, Integer age, Integer tagID) {
        Optional<User> registeredUser = Optional.empty();
        // Check mandatory field existence
        if (    nickName != null && nickName.length() > 0 &&
                password != null && password.length() > 0 &&
                email != null && email.length() > 0 &&
                cityID != null && cityID > 0 &&
                countryID != null && countryID > 0 ) {

            try {

                User user = new User(nickName, email, cityID, countryID, password);

                Optional<User> optionalUser = Optional.of(user);

                if (name != null && name.length() > 0) {user.setName(name);}
                if (surname != null && surname.length() > 0) {user.setLastName(surname);}
                if (age != null && age > 0) {user.setAge(age);}
                if (tagID != null && tagID > 0) {user.setUserTagID(tagID);}

                userDao.createUser(user);

                registeredUser = optionalUser;

            } catch (DBException e) {
                e.printStackTrace();
            }
        }

        return registeredUser;
    }
}
