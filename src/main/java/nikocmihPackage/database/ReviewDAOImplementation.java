package nikocmihPackage.database;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import nikocmihPackage.domain.Review;
import nikocmihPackage.domain.ReviewBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolajs Cmihuns on 11/3/2015.
 */
public class ReviewDAOImplementation implements ReviewDAOInterface {



    // SQL queries
    private final String INSERT_INTO_REVIEW = "insert into REVIEW (creatorID," +
            "routeID," +
            "title," +
            "body," +
            "imageURL) " +
            "values (?,?,?,?,?)";

    private final String DELETE_SINGLE_REVIEW = "DELETE FROM REVIEW " +
                                                      "WHERE reviewID = ?";

    private final String GET_REVIEWS_BY_ROUTE_ID = "SELECT reviewID," +
                                                         "creatorID," +
                                                           "routeID," +
                                                             "title," +
                                                              "body," +
                                                      "creationDate," +
                                                          "imageURL " +
                                                     "FROM review " +
                                                    "WHERE routeID = ?;";

    private final String GET_REVIEWS_BY_CREATOR_ID = "SELECT reviewID," +
            "creatorID," +
            "routeID," +
            "title," +
            "body," +
            "creationDate," +
            "imageURL " +
            "FROM review " +
            "WHERE creatorID = ?;";


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
                    connection.prepareStatement(INSERT_INTO_REVIEW, PreparedStatement.RETURN_GENERATED_KEYS);

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



    @Override
    public void deleteReviewOnRouteDAO(Integer reviewID) throws DBException {

        if (reviewID == null) {
            return;
        }
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement deleteFromReviewSqlStmt =
                    connection.prepareStatement(DELETE_SINGLE_REVIEW);

            deleteFromReviewSqlStmt.setInt(1, reviewID);
            deleteFromReviewSqlStmt.executeUpdate();


        } catch (Throwable e) {
            System.out.println("Exception while execute ReviewDAOImplementation.deleteReviewOnRoute()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public List<Review> getReviewsOnRoute(Integer routeID) throws DBException {
        List<Review> reviewsFromDB = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement getReviewsByRouteSqlStmt =
                    connection.prepareStatement(GET_REVIEWS_BY_ROUTE_ID);
            getReviewsByRouteSqlStmt.setInt(1, routeID);
            ResultSet rs = getReviewsByRouteSqlStmt.executeQuery();
            while (rs.next()) {
                Review review = ReviewBuilder.createReview()
                        .withReviewID(rs.getInt(1))
                        .withCreatorID(rs.getInt(2))
                        .withRouteID(rs.getInt(3))
                        .withTitle(rs.getString(4))
                        .withBody(rs.getString(5))
                        .withCreationDate(rs.getString(6))
                        .withImageURL(rs.getString(7))
                        .build();
                reviewsFromDB.add(review);
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.getReviewsOnRoute()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return reviewsFromDB;
    }




    @Override
    public List<Review> getReviewsOnRouteByUCreator(Integer userID) throws DBException{
        List<Review> reviewsFromDBbyUser = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement getReviewsByRouteSqlStmt =
                    connection.prepareStatement(GET_REVIEWS_BY_CREATOR_ID);
            getReviewsByRouteSqlStmt.setInt(1, userID);
            ResultSet rs = getReviewsByRouteSqlStmt.executeQuery();
            while (rs.next()) {
                Review review = ReviewBuilder.createReview()
                        .withReviewID(rs.getInt(1))
                        .withCreatorID(rs.getInt(2))
                        .withRouteID(rs.getInt(3))
                        .withTitle(rs.getString(4))
                        .withBody(rs.getString(5))
                        .withCreationDate(rs.getString(6))
                        .withImageURL(rs.getString(7))
                        .build();
                reviewsFromDBbyUser.add(review);
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing RouteDAOImplementation.getReviewsOnRouteByUCreator()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return reviewsFromDBbyUser;
    }

    public Connection getConnection() throws DBException {
        return dao.getConnection();
    }

    public void closeConnection(Connection connection) throws DBException {
        dao.closeConnection(connection);
    }


}
