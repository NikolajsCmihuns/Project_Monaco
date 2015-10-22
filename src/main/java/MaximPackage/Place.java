package MaximPackage;

/**
 * Created by maksimspuskels on 18/10/15.
 */
public class Place {

    private Integer placeID;

    private double latitude;
    private double longtitude;

    private Object city;
    private Object country;
    private String imageUrl;
    private String placeName;
    private String placeAddress;


    public Place(Integer placeID, double latitude, double longitude, Object city, Object country, String placeName, String placeAddress) {
        this.placeID = placeID;
        this.latitude = latitude;
        this.longtitude = longitude;
        this.city = city;
        this.country = country;
        this.placeName = placeName;
        this.placeAddress = placeAddress;
    }

    @Override
    public String toString() {
        return "-== PLACE ==-" + "\n" +placeID + "\n" + latitude + "\n" + longtitude + "\n" + city + "\n" + country + "\n" + placeName + "\n" +  placeAddress + "\n" + "-========-";
    }

}
