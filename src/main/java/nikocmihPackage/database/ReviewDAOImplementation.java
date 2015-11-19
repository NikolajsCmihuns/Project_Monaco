package nikocmihPackage.database;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import nikocmihPackage.domain.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolajs Cmihuns on 11/3/2015.
 */
public class ReviewDAOImplementation implements ReviewDAOInterface {

    private final DAO dao = new DAOImpl();

    @Override
    public void createReviewOnRouteDAO(Review review) throws DBException {
        if (review == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement insertIntoReviewSqlStmt =
                    connection.prepareStatement("insert into REVIEW (creatorID, routeID, title, body, imageURL)" +
                                                            "values (?        ,?       ,     ?,    ?,              ?)",
                                                PreparedStatement.RETURN_GENERATED_KEYS);

            // Finally CreatorID should be obtained from  Route object
            insertIntoReviewSqlStmt.setInt(1, review.getCreatorID());

            // Finally getRouteID should be obtained from  Route object
            insertIntoReviewSqlStmt.setInt(2, review.getRouteID());

            insertIntoReviewSqlStmt.setString(3, review.getTitle());
            insertIntoReviewSqlStmt.setString(4, review.getBody());
            insertIntoReviewSqlStmt.setString(5, review.getImageURL());

            insertIntoReviewSqlStmt.executeUpdate();

            ResultSet rs = insertIntoReviewSqlStmt.getGeneratedKeys();
            if (rs.next()) {
                review.setReviewID(rs.getInt(1));
                System.out.println("Get Review ID after executing SQL query: " + review.getReviewID());
            }



        } catch (Throwable e) {
            System.out.println("Exception while execute ReviewDAOImplementation.createReviewOnRoute()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }


    public Connection getConnection() throws DBException {
        return dao.getConnection();
    }

    public void closeConnection(Connection connection) throws DBException {
        dao.closeConnection(connection);
    }


}
