package MaximPackage.Database;

import MaximPackage.ConsolePackage.ConsoleOutput;
import MaximPackage.ConsolePackage.EConsoleMessages;
import MaximPackage.Entities.Tag;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by maksimspuskels on 01/11/15.
 */
public class TagDAOImplementationTest {

    TagDAOImplementation tagDAO = new TagDAOImplementation();

    @Test
    public void testGetTagByID() throws Exception {
        Tag tag = tagDAO.getTagByID(101);
        ConsoleOutput.printObject(tag);
        assertEquals("Hipster", tag.getTagName());
    }

    @Test
    public void testGetIDByTagName() throws Exception {
        int tagID = tagDAO.getIDByTagName("Hipster");
        ConsoleOutput.printObject(tagID);
        assertEquals(101, tagID);
    }

    @Test
    public void testGetAllTags() throws Exception {
        List<Tag> allTags = tagDAO.getAllTags();
        ConsoleOutput.printListContent(allTags, EConsoleMessages.WELCOME_MESSAGE);
        assertEquals(10, allTags.size());
    }
}