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

    public Optional<User> tryRegistration( Optional<String> nickName,
                                           Optional<String> password,
                                           Optional<String> email,
                                           Optional<Integer> cityID,
                                           Optional<Integer> countryID,
                                           Optional<String> name,
                                           Optional<String> surname,
                                           Optional<Integer> age,
                                           Optional<Integer> tagID) {

        Optional<User> registeredUser = Optional.empty();

        // Check mandatory field existence
        if (    nickName.isPresent() &&
                password.isPresent() &&
                email.isPresent() &&
                cityID.isPresent() &&
                countryID.isPresent() ) {

            try {

                User user = new User(nickName.get(), email.get(), cityID.get(), countryID.get(), password.get());

                Optional<User> optionalUser = Optional.of(user);

                if (name.isPresent()) {user.setName(name.get());}
                if (surname.isPresent()) {user.setLastName(surname.get());}
                if (age.isPresent()) {user.setAge(age.get());}
                if (tagID.isPresent()) {user.setUserTagID(tagID.get());}

                userDao.createUser(user);

                registeredUser = optionalUser;

            } catch (DBException e) {
                e.printStackTrace();
            }
        }

        return registeredUser;
    }
}
