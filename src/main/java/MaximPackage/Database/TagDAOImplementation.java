package MaximPackage.Database;

import MaximPackage.Tag;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */
public class TagDAOImplementation implements TagDAOInterface{

    private final DAO dao = new DAOImpl();

    @Override
    public Tag getTagByID(int id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from TAGS_REF where TAG_NAME_ID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Tag tag = null;
            if (resultSet.next()) {
                tag = composeTagFromResultsSet(resultSet);
            }
            return tag;
        } catch (Throwable e) {
            System.out.println("Exception while executing getTagByID().");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public int getIDByTagName(String tagName) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from TAGS_REF where TAG_NAME LIKE ?");
            preparedStatement.setString(1, tagName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Tag tag = null;
            if (resultSet.next()) {
                tag = composeTagFromResultsSet(resultSet);
            }
            return tag.getTagNameID();
        } catch (Throwable e) {
            System.out.println("Exception while executing getIDByTagName().");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Tag> getAllTags() throws DBException {
        Connection connection = null;

        ArrayList<Tag> listOfTags = new ArrayList<>();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from TAGS_REF");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Tag tag = composeTagFromResultsSet(resultSet);
                listOfTags.add(tag);
            }

            return listOfTags;
        } catch (Throwable e) {
            System.out.println("Exception while executing getAllTags().");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    private Tag composeTagFromResultsSet(ResultSet resultsSet) throws DBException {
        Tag tag;
        try {
            tag = new Tag(resultsSet.getString("TAG_NAME"), resultsSet.getInt("TAG_NAME_ID"));
        } catch (Throwable e) {
            System.out.println("Exception while composing tag from results set!");
            e.printStackTrace();
            throw new DBException(e);
        }

        return tag;
    }

    protected Connection getConnection() throws DBException {
        return dao.getConnection();
    }

    protected void closeConnection(Connection connection) throws DBException {
        dao.closeConnection(connection);
    }
}
