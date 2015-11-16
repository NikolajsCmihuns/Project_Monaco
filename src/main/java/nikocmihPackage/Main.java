package nikocmihPackage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Nikolajs Cmihuns on 19/10/2015.
 */
public class Main {

    public static void main(String[] args){

        int consoleInput;
        ArrayList<User> usersArray = new ArrayList<User>();
        Scanner userInputAction = new Scanner(System.in);
        Scanner userInputParameters = new Scanner(System.in);

        boolean executeApplication = true;

        while(executeApplication){

            Console.printConsoleUsage();

            //consoleInput = userInputAction.nextInt();

            switch( userInputAction.nextInt() ){
                case 1:
                    Console.printUserCreateInfo();

                    System.out.println(" Enter PASSWORD as string");
                    String inputPassword = userInputParameters.next();
                    userInputParameters.reset();

                    System.out.println("  Enter NICKNAME as string");
                    String inputNickname = userInputParameters.next();
                    userInputParameters.reset();

                    System.out.println("  Enter USER_ID as integer");
                    int inputUserId = userInputParameters.nextInt();
                    userInputParameters.reset();

                    System.out.println(" Enter EMAIL as string");
                    String inputEmail = userInputParameters.next();
                    userInputParameters.reset();





                    usersArray.add(new User(inputPassword, inputUserId,inputNickname, inputEmail));

                    break;
                case 2:
                    if(usersArray.isEmpty()){
                        Console.printNoUsersExistInfo();
                        break;
                    }
                    Console.printUserShowInfo(usersArray.size());
                    System.out.println(usersArray.get(userInputParameters.nextInt()-1));
                    break;
                case 3:
                    Console.printAppTerminationInfo();
                    executeApplication = false;
                    userInputParameters.close();
                    userInputAction.close();

                default:
                    // DO Nothing

            }


        } // end of while


    } // end of main
}
