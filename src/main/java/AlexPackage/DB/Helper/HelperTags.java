package AlexPackage.DB.Helper;

/**
 * Created by Aborigens on 07-Nov-15.
 */
public class HelperTags {

    private Integer tagId;
    private String tagName;

    public HelperTags(Integer tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

    public Integer getTagId() {
        return tagId;
    }

}
