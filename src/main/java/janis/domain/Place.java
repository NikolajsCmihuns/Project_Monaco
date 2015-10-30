package janis.domain;

/**
 * Created by janis on 10/30/15.
 */




public class Place {
    int placeID;
    double latitude;
    double longitute;
    int cityID;
    int countryID;
    String imageURL;
    String placeName;
    String placeAddress;
    int placeTypeID;

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitute() {
        return longitute;
    }

    public void setLongitute(double longitute) {
        this.longitute = longitute;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public int getPlaceTypeID() {
        return placeTypeID;
    }

    public void setPlaceTypeID(int placeTypeID) {
        this.placeTypeID = placeTypeID;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeID=" + placeID +
                ", latitude=" + latitude +
                ", longitute=" + longitute +
                ", cityID=" + cityID +
                ", countryID=" + countryID +
                ", imageURL='" + imageURL + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeAddress='" + placeAddress + '\'' +
                ", placeTypeID=" + placeTypeID +
                '}';
    }
}
