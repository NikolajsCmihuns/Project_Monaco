package MaximPackage;

/**
 * Created by maksimspuskels on 18/10/15.
 */
public class Place {

    private Integer placeID;

    private double latitude;
    private double longitude;

    private String city;
    private String country;
    private String imageUrl;
    private String placeName;
    private String placeAddress;


    public Place(double latitude, double longitude, String city, String country, String placeName, String placeAddress) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.country = country;
        this.placeName = placeName;
        this.placeAddress = placeAddress;
    }

    // Getters
    public Integer getPlaceID() {
        return placeID;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Object getCity() {
        return city;
    }

    public Object getCountry() {
        return country;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    // Setters
    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(double longtitude) {
        this.longitude = longtitude;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    @Override
    public String toString() {
        return "-== PLACE ==-" + "\n" + placeID + "\n" + latitude + "\n" + longitude + "\n" + city + "\n" + country + "\n" + placeName + "\n" + placeAddress + "\n" + "-========-";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (Double.compare(place.getLatitude(), getLatitude()) != 0) return false;
        if (Double.compare(place.getLongitude(), getLongitude()) != 0) return false;
        if (!getPlaceID().equals(place.getPlaceID())) return false;
        if (!getCity().equals(place.getCity())) return false;
        if (!getCountry().equals(place.getCountry())) return false;
        if (getImageUrl() != null ? !getImageUrl().equals(place.getImageUrl()) : place.getImageUrl() != null)
            return false;
        if (!getPlaceName().equals(place.getPlaceName())) return false;
        return getPlaceAddress().equals(place.getPlaceAddress());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getPlaceID().hashCode();
        temp = Double.doubleToLongBits(getLatitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLongitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + (getImageUrl() != null ? getImageUrl().hashCode() : 0);
        result = 31 * result + getPlaceName().hashCode();
        result = 31 * result + getPlaceAddress().hashCode();
        return result;
    }
}
