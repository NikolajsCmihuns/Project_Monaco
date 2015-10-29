package MaximPackage.Services;

import MaximPackage.ConsolePackage.ConsoleOutput;
import MaximPackage.Database.UserDAOImplementation;
import MaximPackage.User;
import lv.javaguru.java2.database.DBException;

/**
 * Created by maksimspuskels on 29/10/15.
 */

public class LoginService {
    private static LoginService ourInstance = new LoginService();

    public static LoginService getInstance() {
        return ourInstance;
    }

    private LoginService() {

    }

    public boolean tryLogin(String nickName, String password) {
        boolean loginSuccessful = false;

        UserDAOImplementation userDAO = new UserDAOImplementation();

        if (nickName != null && nickName.length() > 0) {
            User userFromDB = null;
            try {
                userFromDB = userDAO.getUserByNickname(nickName);
                if (userFromDB != null) {
                    String userPassword = userFromDB.getPassword();

                    if (userPassword != null && password != null && password.equalsIgnoreCase(userPassword)) {
                        loginSuccessful = true;
//                        ConsoleOutput.printObject(userPassword);
//                        ConsoleOutput.printObject(password);
//                        ConsoleOutput.printObject(userFromDB);
                        SessionService session = SessionService.getInstance();
                        session.setUserId(userFromDB.getUserID());
                    }
                }
            } catch (DBException e) {
                e.printStackTrace();
            }
        }

        return loginSuccessful;
    }
}
