package MaximPackage.Database;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;

import java.sql.*;
import java.util.List;

import MaximPackage.User;

/**
 * Created by maksimspuskels on 23/10/15.
 */

public class UserDAOImplementation extends DAOImpl implements UserDAOInterface {

    @Override
    public void create(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into USERS values (default, ?, ?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,  user.getPassword());     /* Password char */
            preparedStatement.setString(2,  user.getName());         /* Name char */
            preparedStatement.setString(3,  user.getLastName());     /* LastName char */
            preparedStatement.setString(4,  user.getNickname());     /* NickName char */
            preparedStatement.setString(5,  user.getEmail());        /* Email char */
            preparedStatement.setInt(6,     user.getAge());          /* Age INT */
            preparedStatement.setString(7,  user.getCity());         /* City char */
            preparedStatement.setString(8,  user.getCountry());      /* Country char */
            preparedStatement.setString(9,  user.getUserTag());      /* UserTag char */
            preparedStatement.setObject(10, user.getReviews());      /* Reviews char */
            preparedStatement.setObject(11, user.getRoutes());       /* Routes char */

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                user.setUserID(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

//    public User getById(Long id) throws DBException {
//
//    }
//
//    public List<User> getAll() throws DBException {
//
//    }
}
