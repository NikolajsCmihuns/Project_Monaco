package MaximPackage.Database;

import MaximPackage.Tag;
import lv.javaguru.java2.database.DBException;

import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

public interface TagDAOInterface {
    Tag getTagByID(int id) throws DBException;

    int getIDByTagName(String TagName) throws DBException;

    List<Tag> getAllTags() throws DBException;
}
