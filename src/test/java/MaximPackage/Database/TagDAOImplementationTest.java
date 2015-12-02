package MaximPackage.Database;

import MaximPackage.ConsolePackage.ConsoleOutput;
import MaximPackage.ConsolePackage.EConsoleMessages;

import com.monaco.Database.TagDAOImplementation;
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
    private TagDAOImplementation tagDAO;

    @Test
    public void testGetTagByID() throws Exception {
        Tag tag = tagDAO.getTagByID(Integer.valueOf(101));
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