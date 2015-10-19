package MaximPackage.ConsolePackage;

/**
 * Created by maximpuskels on 8/11/15.
 */

public enum EConsoleMessages {
    WELCOME_MESSAGE("This is Monaco console application. "),
    WRONG_MENU_MESSAGE("Wrong input value!"),
    EXIT_MESSAGE_MESSAGE("Good buy!"),
    ENTER_NEW_CHOICE_MESSAGE("Enter your choice: "),
    WRONG_CHOICE_MESSAGE("wrong choice, here are available choices:"),
    WRONG_CHOICE_MESSAGE_YES_NO("wrong choice, only YES / NO are available");

    private String message;

    EConsoleMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}