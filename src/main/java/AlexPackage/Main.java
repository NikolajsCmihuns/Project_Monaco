package AlexPackage;

import java.util.List;

/**
 * Created by Aborigens on 21-Oct-15.
 */
public class Main {

    public static void main(String[] args) {

        User user;
        Input input = new Input();
        Output output = new Output();

        Boolean authentication = false;
        while (authentication == false) {
            output.output(SystemMessages.WELCOME.getString());
            switch (input.getInputString()) {
                case "r":
                    output.output(SystemMessages.NAME.getString());
                    String name = input.getInputString();

                    output.output(SystemMessages.EMAIL.getString());
                    String email = input.getInputString();

                    output.output(SystemMessages.PASSWORD.getString());
                    String password = input.getInputString();

                    user = new User((int) (Math.random() * ((10 - 1) + 1) + 1), name, email, password);
                    new HelperFile().save(user, SystemMessages.FILE_USER.getString());

                    authentication = true;

                    break;
                case "l":
                    output.output(SystemMessages.NAME.getString());
                    name = input.getInputString();

                    output.output(SystemMessages.PASSWORD.getString());
                    password = input.getInputString();

                    List<User> users = new HelperFile().getUsers(SystemMessages.FILE_USER.getString());

                    if (new HelperValidator().validateUser(name, password, users)) {
                        authentication = true;
                    }
                    break;
                case "e":
                    System.exit(0);
                    break;
                default:
                    output.output(SystemMessages.ERROR_NO_SUCH_OPTION.getString());
            }

        }

        output.output(SystemMessages.SUCCESS.getString());

        Menu menu = new Menu();
        Action action = new Action();
        while (true) {
            output.output(menu);
            try {
                action.setExecute(menu.getMenuActions().get(input.getInputInt()));
                action.runAction();
            } catch (Exception e) {
                output.output(SystemMessages.ERROR_NO_SUCH_OPTION.getString());
            }

        }

    }
}


