package nikocmihPackage;
import java.util.Scanner;

/**
 * Created by Nikolajs Cmihuns on 19/10/2015.
 */
public class Main {

    public static void main(String[] args){

        int consoleInput;
        Scanner userInputAction = new Scanner(System.in);
        Scanner userInputParameters = new Scanner(System.in);

        Console.printConsoleUsage();

        while(true){

            System.out.print("--> ");
            consoleInput = userInputAction.nextInt();

            switch( consoleInput ){
                case 1:
                    Console.printUserCreateInfo();

                    System.out.println("  Please enter USER_ID as integer");
                    int inputUserId = userInputParameters.nextInt();
                    System.out.println("  Please enter NICKNAME as string");
                    String inputNickname = userInputParameters.nextLine();
                    System.out.println("  Please enter PASSWORD as string");
                    String inputPassword = userInputParameters.nextLine();
                    System.out.println("  Please enter EMAIL as string");
                    String inputEmail = userInputParameters.nextLine();
                    System.out.println("  Please enter CITY as string");
                    String inputCity = userInputParameters.nextLine();
                    System.out.println("  Please enter COUNTRY as string");
                    String inputCountry = userInputParameters.nextLine();
                    User user = new User(inputPassword, inputUserId,inputNickname, inputEmail, inputCity, inputCountry);

                    break;
                case 2:
                    Console.printUserShowInfo();
                    user.toString();
                    break;
                case 3:
                    Console.printExitInfo();
                    return;
                default:
                    Console.printConsoleUsage();

            }


        }



    } // end of main
}
