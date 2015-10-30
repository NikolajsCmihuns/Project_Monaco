package MaximPackage.Services;

import MaximPackage.ConsolePackage.ConsoleOutput;
import MaximPackage.Database.UserDAOImplementation;
import MaximPackage.User;
import lv.javaguru.java2.database.DBException;

import javax.servlet.http.HttpSession;

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

    public boolean tryRegistration(String nickName, String password, String email, String city, String country, String name, String surname, Integer age, String tag, HttpSession session) {
        boolean registrationSuccessful = false;

        UserDAOImplementation userDAO = new UserDAOImplementation();

        if (    nickName != null && nickName.length() > 0 &&
                password != null && password.length() > 0 &&
                email != null && email.length() > 0 &&
                city != null && city.length() > 0 &&
                country != null && country.length() > 0 ) {

            try {
                User user = new User(nickName, email, city, country, password);

                if (name != null && name.length() > 0) {user.setName(name);}
                if (surname != null && surname.length() > 0) {user.setLastName(surname);}
                if (age != null && age > 0) {user.setAge(age);}
                if (tag != null && tag.length() > 0) {user.setUserTag(tag);}

                userDAO.createUser(user);

                session.setAttribute("userID", user.getUserID());

                registrationSuccessful = true;

            } catch (DBException e) {
                e.printStackTrace();
            }
        }

        return registrationSuccessful;
    }

}
