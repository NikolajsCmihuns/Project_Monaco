package AlexPackage.MonacoConsole;

/**
 * Created by Aborigens on 23-Oct-15.
 */
public class Place {

    private int id;
    private String placeCountry;
    private String placeCity;
    private String placeName;

    public Place(int id, String placeCountry, String placeCity, String placeName) {
        this.id = id;
        this.placeCountry = placeCountry;
        this.placeCity = placeCity;
        this.placeName = placeName;
    }

    public int getId() {
        return id;
    }

    public String getPlaceCountry() {
        return placeCountry;
    }

    public String getPlaceCity() {
        return placeCity;
    }

    public String getPlaceName() {
        return placeName;
    }
}
