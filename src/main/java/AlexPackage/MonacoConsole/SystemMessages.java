package AlexPackage.MonacoConsole;

import java.io.File;

/**
 * Created by Aborigens on 21-Oct-15.
 */
public enum SystemMessages {

    WELCOME("Welcome. Do you want to register or login? (r / l): "),
    BYE("Logout"),
    ERROR_NO_SUCH_OPTION("No such option"),

    NAME("Name: "),
    EMAIL("Email: "),
    PASSWORD("Password: "),

    ERROR_FILE_WRITE("File Write Error"),
    ERROR_FILE_READ("File Read Error"),
    SUCCESS("Success"),

    FILE_USER("User.txt"),
    FILE_PLACE("Place.txt"),

    FILE_PATH(new File(".").getAbsolutePath() + "/src/main/java/AlexPackage/");

    private String string;

    SystemMessages(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
