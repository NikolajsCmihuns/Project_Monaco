package MaximPackage;

import MaximPackage.ConsolePackage.ConsoleOutput;

import java.util.ArrayList;

/**
 * Created by maksimspuskels on 19/10/15.
 */

public class Main {
    public static void main(String[] args){

        // Create user
        User user = new User(001, "Tourist", "t@email.com", "Riga", "Latvia","pass");
        // Print user
        ConsoleOutput.printObject(user);
        // Create Place
        Place firstPlace = new Place(100, 5.4432, 5.123, new Object() , new Object(), "Doma baznica", "Doma laukums");
        // Print Place
        ConsoleOutput.printObject(firstPlace);
        Place secondPlace = new Place(101, 6.123, 6.423, new Object() , new Object(), "Strelnieku laukums", "Kalku iela 1");
        // Print Place
        ConsoleOutput.printObject(secondPlace);
        // Create Route
        Route route = new Route(202, "Gop", new ArrayList<Place>(){{add(firstPlace);add(secondPlace);}});
        // Print Route
        ConsoleOutput.printObject(route);

        // Create Review
        Review review = new Review(301,"Here was good", "If you feel like visiting, I suggest!", user.getUserID(), "http://www.leningrad.ru");

        // Print Review
        ConsoleOutput.printObject(review);
    }
}
