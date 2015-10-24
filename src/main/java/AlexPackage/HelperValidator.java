package AlexPackage;

import java.util.List;

/**
 * Created by Aborigens on 21-Oct-15.
 */
public class HelperValidator {

    public HelperValidator() {

    }

    public boolean validateUser(String name, String password, List<User> users) {
        Boolean result = false;

        int i = 0;
        while (i < users.size() && result == false) {
            if (name.equals(users.get(i).getName()) && password.equals(users.get(i).getPassword())) {
                result = true;
            }
            i++;
        }

        return result;
    }

}
