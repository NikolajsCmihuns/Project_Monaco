package AlexPackage.DB;

/**
 * Created by Aborigens on 12-Nov-15.
 */
public class Coordinates {

    private String latitude;
    private String longitude;
    private String sequence;

    public Coordinates(String latitude, String longitude, String sequence) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.sequence = sequence;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getSequence() {
        return sequence;
    }
}
