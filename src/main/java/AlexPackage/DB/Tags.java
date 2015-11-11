package AlexPackage.DB;

/**
 * Created by Aborigens on 07-Nov-15.
 */
public class Tags {

    private Integer tagId;
    private String tagName;

    public Tags(Integer tagId, String tagName) {
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
