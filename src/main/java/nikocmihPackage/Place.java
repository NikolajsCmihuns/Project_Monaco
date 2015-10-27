package nikocmihPackage;

/**
 * Created by Nikolajs Cmihuns on 19/10/2015.
 */
public class Place {

    // class variables
    private Integer placeID;
    private PlaceNames placeName;
    private Double latitude;
    private Double longitute;
    private Cities city;
    private Countries country;
    private String imageUrl;
    private String placeAddress;


    // Constructor
    public Place(Double longitute, Double latitude, Cities city, Countries country, PlaceNames placeName) {
        this.longitute = longitute;
        this.latitude = latitude;
        this.city = city;
        this.country = country;
        this.placeName = placeName;
    }

    // Getters and Setters
    public Integer getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    public PlaceNames getPlaceName() {
        return placeName;
    }

    public void setPlaceName(PlaceNames placeName) {
        this.placeName = placeName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitute() {
        return longitute;
    }

    public void setLongitute(Double longitute) {
        this.longitute = longitute;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
