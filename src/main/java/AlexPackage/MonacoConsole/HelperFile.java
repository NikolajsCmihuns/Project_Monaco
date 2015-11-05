package AlexPackage.MonacoConsole;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aborigens on 21-Oct-15.
 */
public class HelperFile {

    public void save(User user, String tableName) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(tableName, true));
            writer.println(user.toString());
            writer.close();
            new Output().output(SystemMessages.SUCCESS.getString());
        } catch (IOException e) {
            new Output().output(SystemMessages.ERROR_FILE_WRITE.getString());
        }

    }

    public List<User> getUsers(String tableName) {
        List<User> users = new ArrayList<>();

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(SystemMessages.FILE_PATH.getString() + tableName));
            String user = null;
            while ((user = bufferedReader.readLine()) != null) {
                String[] row = user.split(";");
                users.add(new User(Integer.parseInt(row[0]), row[1], row[2], row[3]));
            }
        } catch (Exception e) {
            new Output().output(SystemMessages.ERROR_FILE_READ.getString());
        }

        return users;
    }

    public List<Place> getPlaces(String tableName) {
        List<Place> places = new ArrayList<>();

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(SystemMessages.FILE_PATH.getString() + tableName));
            String place = null;
            while ((place = bufferedReader.readLine()) != null) {
                String[] row = place.split(";");
                places.add(new Place(Integer.parseInt(row[0]), row[1], row[2], row[3]));
            }
        } catch (Exception e) {
            new Output().output(SystemMessages.ERROR_FILE_READ.getString());
        }

        return places;
    }

}































