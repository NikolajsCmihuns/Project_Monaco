package MaximPackage.Database;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;

import java.sql.*;

import MaximPackage.User;

/**
 * Created by maksimspuskels on 23/10/15.
 */

public class UserDAOImplementation implements UserDAOInterface {

    private final DAO dao = new DAOImpl();

    @Override
    public void createUser(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into USER values (default, ?, ?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getNickname());     /* NickName char */
            preparedStatement.setString(2, user.getName());         /* Name char */
            preparedStatement.setString(3, user.getLastName());     /* LastName char */
            preparedStatement.setString(4, user.getEmail());        /* Email char */
            preparedStatement.setInt(5, user.getAge());          /* Age INT */

            preparedStatement.setInt(6, user.getCityID());          /* City char */
            preparedStatement.setInt(7, user.getCountryID());       /* Country char */
            preparedStatement.setInt(8, user.getUserTagID());       /* UserTag char */

            preparedStatement.setString(9, user.getPassword());     /* Password char */

            preparedStatement.setDate(10, new Date(System.currentTimeMillis()));

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                user.setUserID(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.createUser()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public User getUserByID(int id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USER where UserID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = composeUserFromResultsSet(resultSet);
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getUserByID()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public User getUserByNickname(String nickname) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USER where NickName Like ?");
            preparedStatement.setString(1, nickname);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = composeUserFromResultsSet(resultSet);
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getUserByID()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    private User composeUserFromResultsSet(ResultSet resultsSet) throws DBException {
        User user;
        try {
            user = new User(resultsSet.getString("nickname"), resultsSet.getString("email"), resultsSet.getInt("cityID"), resultsSet.getInt("countryID"), resultsSet.getString("userPass"));

            user.setUserID(resultsSet.getInt("userID"));
            user.setName(resultsSet.getString("firstName"));
            user.setLastName(resultsSet.getString("lastName"));
            user.setAge(resultsSet.getInt("age"));
            user.setUserTagID(resultsSet.getInt("userTagID"));
        } catch (Throwable e) {
            System.out.println("Exception while composing user from results set!");
            e.printStackTrace();
            throw new DBException(e);
        }

        return user;
    }

    protected Connection getConnection() throws DBException {
        return dao.getConnection();
    }

    protected void closeConnection(Connection connection) throws DBException {
        dao.closeConnection(connection);
    }
}
