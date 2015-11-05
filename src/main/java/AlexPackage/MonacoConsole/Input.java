package AlexPackage.MonacoConsole;

import java.util.Scanner;

/**
 * Created by Aborigens on 21-Oct-15.
 */
public class Input {

    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getInputString() {
        return scanner.next();
    }

    public int getInputInt(){
        return scanner.nextInt();
    }

}
