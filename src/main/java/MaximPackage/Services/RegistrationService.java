package MaximPackage.Services;

import MaximPackage.ConsolePackage.ConsoleOutput;
import MaximPackage.Database.UserDAOImplementation;
import MaximPackage.User;
import lv.javaguru.java2.database.DBException;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by maksimspuskels on 29/10/15.
 */

public class RegistrationService {
    private static RegistrationService ourInstance = new RegistrationService();

    public static RegistrationService getInstance() {
        return ourInstance;
    }

    private RegistrationService() {
    }

    public Optional<Integer> tryRegistration(String nickName, String password, String email, Integer cityID, Integer countryID, String name, String surname, Integer age, Integer tagID) {
        Optional<Integer> registeredUserID = Optional.of(User.USER_NOT_FOUND);

        UserDAOImplementation userDAO = new UserDAOImplementation();

        if (    nickName != null && nickName.length() > 0 &&
                password != null && password.length() > 0 &&
                email != null && email.length() > 0 &&
                cityID != null && cityID > 0 &&
                countryID != null && countryID > 0 ) {

            try {
                User user = new User(nickName, email, cityID, countryID, password);

                if (name != null && name.length() > 0) {user.setName(name);}
                if (surname != null && surname.length() > 0) {user.setLastName(surname);}
                if (age != null && age > 0) {user.setAge(age);}
                if (tagID != null && tagID > 0) {user.setUserTagID(tagID);}

                userDAO.createUser(user);

                registeredUserID = user.getUserID();

            } catch (DBException e) {
                e.printStackTrace();
            }
        }

        return registeredUserID;
    }
}
