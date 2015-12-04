package MaximPackage.Database;

import MaximPackage.ConsolePackage.ConsoleOutput;

import MaximPackage.ConsolePackage.EConsoleMessages;
import com.monaco.Database.TagDAOInterface;
import com.monaco.Entities.Tag;
import com.monaco.MVC.SpringConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TagDAOImplementationTest {

    @Autowired
    private TagDAOInterface tagDAO;

    @Test
    public void testGetTagByID() throws Exception {
        // Create new tag that match predefined data from monaco.TAGS_REF
        Tag tagMock = new Tag("Classic",102);
        // Get the same object from Database throughout hibernate
        Tag tag = tagDAO.getTagByID(tagMock.getTagNameID());
        // Check results that mocked object
        assertEquals(tagMock, tag);
    }

    @Test
    public void testGetIDByTagName() throws Exception {
        // Create new tag that match predefined data from monaco.TAGS_REF
        Tag tagMock = new Tag("Classic",102);
        // Get tag id from from DB
        Integer tagID = tagDAO.getIDByTagName(tagMock.getTagName());
        // Compare both ids
        assertEquals(tagMock.getTagNameID(), tagID);
    }

    @Test
    public void testGetAllTags() throws Exception {
        // Get all tags from DB
        List<Tag> allTags = tagDAO.getAllTags();
        ConsoleOutput.printListContent(allTags, EConsoleMessages.WELCOME_MESSAGE);
        // As all of them are predefined, it is ok just to check amount of items in the list
        assertEquals(10, allTags.size());
    }
}