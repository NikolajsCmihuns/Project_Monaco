package MaximPackage;

/**
 * Created by maksimspuskels on 01/11/15.
 */

public class Country {

    String countryName;
    int countryNameID;


    public Country(String countryName, int countryNameID) {
        this.countryName = countryName;
        this.countryNameID = countryNameID;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getCountryNameID() {
        return countryNameID;
    }
}