package MaximPackage.ConsolePackage;

import java.util.Scanner;

import static MaximPackage.ConsolePackage.EConsoleMessages.*;

/**
 * Created by maximpuskels on 8/14/15.
 */

public class ConsoleInput {

    Scanner scanner = new Scanner(System.in);

    // Function will repeat until user will enter YES/NO in console
    public boolean getYesOrNoString() {
        boolean returnValue = false;
        boolean shouldContinue = true;

        String inputString = scanner.nextLine();

        do {
            if (inputString.equalsIgnoreCase("YES") || inputString.equalsIgnoreCase("NO")) {
                if (inputString.equalsIgnoreCase("YES")) {
                    returnValue = true;
                } else {
                    returnValue = false;
                }
                shouldContinue = false;
            } else {
                ConsoleOutput.printInfo(WRONG_CHOICE_MESSAGE_YES_NO);
                inputString = scanner.nextLine();
            }
        }
        while (shouldContinue);

        return returnValue;
    }

    // Function will repeat until user will enter integer in console
    public Integer getIntegerInput(EConsoleMessages errorMessage) {
        while (!scanner.hasNextInt()) {
            ConsoleOutput.printInfo(errorMessage);
            ConsoleOutput.printInfo(ENTER_NEW_CHOICE_MESSAGE);
            scanner.nextLine();
        }

        int inputInt = Integer.valueOf(scanner.nextLine());

        return inputInt;
    }

    // Function will repeat until user will enter Double in console
    public Double getDoubleInput(EConsoleMessages errorMessage) {
        while (!scanner.hasNextDouble()) {
            ConsoleOutput.printInfo(errorMessage);
            ConsoleOutput.printInfo(ENTER_NEW_CHOICE_MESSAGE);
            scanner.nextLine();
        }

        Double inputInt = Double.valueOf(scanner.nextLine());

        return inputInt;
    }

    public String getNextLineInput() {
        String inputString = scanner.nextLine();
        return inputString;
    }
}
