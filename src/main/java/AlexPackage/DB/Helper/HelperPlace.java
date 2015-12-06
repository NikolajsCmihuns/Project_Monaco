package AlexPackage.DB.Helper;

/**
 * Created by Aborigens on 04-Dec-15.
 */
public class HelperPlace {

    private int placeId;
    private int sequence;

    public HelperPlace(int placeId, int sequence) {
        this.placeId = placeId;
        this.sequence = sequence;
    }

    public int getSequence() {
        return sequence;
    }

    public int getPlaceId() {
        return placeId;
    }
}
