package MaximPackage;

/**
 * Created by maksimspuskels on 01/11/15.
 */

public class City {

    String cityName;
    int cityNameID;
    int countryID;

    public City(String cityName, int cityNameID, int countryID) {
        this.cityName = cityName;
        this.cityNameID = cityNameID;
        this.countryID = countryID;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCityNameID() {
        return cityNameID;
    }

    public int getCountryID() {
        return countryID;
    }

    @Override
    public String toString() {
        return "-== City ==-" + "\n" + cityName + "\n" + cityNameID + "\n" + countryID + "\n" + "-========-";
    }
}
