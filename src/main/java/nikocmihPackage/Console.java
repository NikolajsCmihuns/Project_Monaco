package nikocmihPackage;
import java.util.Scanner;

/**
 * Created by Nikolajs Cmihuns on 10/26/2015.
 */


public class Console {

    // Messages for USER
    public static void printConsoleUsage(){

        System.out.println("");
        System.out.println("WELCOME to MoNaCO app.");
        System.out.println(" Choose available actions:");
        System.out.println("    Type '1' to Create User");
        System.out.println("    Type '2' to Show User INFO");
        System.out.println("    Type '3' to EXIT MONACO application");
        System.out.print("--> ");

    }

    public static void printUserCreateInfo(){

        System.out.println("Creating new user");

    }


    public static void printUserShowInfo(int createdUsersCount){

        System.out.println("  User from 1 to "+ createdUsersCount +" are available to show");
        System.out.println("  Enter user which user you want to get info about");
        System.out.print("--> ");

    }


    public static void printAppTerminationInfo() {

        System.out.println("Exiting Monaco application ... ");

    }

    public static void printNoUsersExistInfo() {

        System.out.println("No one user has been created so far");

    }
}
