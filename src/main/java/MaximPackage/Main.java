package MaximPackage;

import MaximPackage.ConsolePackage.ConsoleOutput;

/**
 * Created by maksimspuskels on 19/10/15.
 */
public class Main {
    public static void main(String[] args){

        // Create user
        User user = new User(1, "Tourist", "t@email.com", "Riga", "Latvia");
        // Print user
        ConsoleOutput.printObject(user);
        // Create Place
        Place place = new Place();
        // Print Place
        ConsoleOutput.printObject(place);
        // Create Route
        Route route = new Route();
        // Print Route
        ConsoleOutput.printObject(route);
        // Create Review
        Review review = new Review();
        // Print Review
        ConsoleOutput.printObject(review);
    }
}
