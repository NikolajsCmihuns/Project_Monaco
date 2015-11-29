package MaximPackage.Entities;

/**
 * Created by maksimspuskels on 01/11/15.
 */

public class Tag {
    String  tagName;
    Integer tagNameID;

    public Tag(String tagName, Integer tagNameID) {
        this.tagName = tagName;
        this.tagNameID = tagNameID;
    }

    public String getTagName() {
        return tagName;
    }

    public int getTagNameID() {
        return tagNameID;
    }

    @Override
    public String toString() {
        return "-== Tag ==-" + "\n" + tagName + "\n" + tagNameID + "\n" + "-========-";
    }
}
