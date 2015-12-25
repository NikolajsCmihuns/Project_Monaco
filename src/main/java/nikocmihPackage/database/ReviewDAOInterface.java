package nikocmihPackage.database;
import lv.javaguru.java2.database.DBException;

import nikocmihPackage.domain.Review;

import java.util.List;

/**
 * Created by Nikolajs Cmihuns on 11/2/2015.
 */
public interface ReviewDAOInterface {

    void createReviewOnRouteDAO (Review review) throws DBException;

    void deleteReviewOnRouteDAO(Integer reviewID) throws DBException;

    List<Review> getReviewsOnRoute(Integer routeID) throws DBException;

    List<Review> getReviewsOnRouteByUCreator(Integer userID) throws DBException;

    //Review getReviewOnRoute(Integer reviewID) throws DBException;

//    void createReviewOnPlace(Review review) throws DBException;
//
//    Review[] getReviewsOnPlace(Integer placeID) throws DBException;
//
//    Review[] getReviewsOnRoute(Integer routeID) throws DBException;
//
//    void updateReviewOnPlace(Integer reviewID) throws DBException;
//
//    Review[] getUserReviews(Integer creatorID) throws DBException;

}
