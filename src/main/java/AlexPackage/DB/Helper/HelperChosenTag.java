package AlexPackage.DB.Helper;

/**
 * Created by Aborigens on 02-Dec-15.
 */
public class HelperChosenTag {

    private String chosenTagId;
    private String chosenTagText;

    public HelperChosenTag(String chosenTagId, String chosenTagText) {
        this.chosenTagId = chosenTagId;
        this.chosenTagText = chosenTagText;
    }

    public String getChosenTagId() {
        return chosenTagId;
    }

    public String getChosenTagText() {
        return chosenTagText;
    }
}
