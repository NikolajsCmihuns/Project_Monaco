package MaximPackage.ConsolePackage;

import java.util.List;
import java.util.Map;

public class ConsoleOutput {

    public static void printInfo(EConsoleMessages message) {
        System.out.println(message.toString());
    }

    public static void printInfo(EConsoleMessages message, String usedArgument) {
        System.out.println(usedArgument + message.toString());
    }

    public static void printObject(Object object) {
        System.out.println(object.toString());
    }

    public static void printMapKeyValues(Map list, EConsoleMessages emptyMessage) {
        if (list.entrySet().size() > 0) {
            list
                    .entrySet()
                    .stream()
                    .forEach(System.out::println);
        }
        else {
            ConsoleOutput.printInfo(emptyMessage);
        }
    }

    public static void printListContent(List list, EConsoleMessages emptyMessage) {
        if (list.size() > 0) {
            list
                    .stream()
                    .forEach(System.out::println);
        } else {
            ConsoleOutput.printInfo(emptyMessage);
        }
    }

    public static void printMapContent(Map list, EConsoleMessages emptyMessage) {
        if (list.values().size() > 0) {
            list
                    .values()
                    .stream()
                    .forEach(System.out::println);
        } else {
            ConsoleOutput.printInfo(emptyMessage);
        }
    }
}
