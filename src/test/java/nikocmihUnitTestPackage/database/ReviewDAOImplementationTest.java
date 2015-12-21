package nikocmihUnitTestPackage.database;

import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import nikocmihPackage.database.ReviewDAOImplementation;
import nikocmihPackage.domain.Review;
import lv.javaguru.java2.database.DBException;

import nikocmihPackage.domain.ReviewBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Created by Nikolajs Cmihuns on 11/5/2015.
 */
public class ReviewDAOImplementationTest {


    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private ReviewDAOImplementation reviewDAOImp = new ReviewDAOImplementation();

    @Before
    public void init() throws DBException {
        //databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreateReview() throws Exception {

        Review review = ReviewBuilder.createReview()
                .withRouteID(1)
                .withTitle("Route_1")
                .withBody("Review text")
                .withCreatorID(1)
                .build();
        reviewDAOImp.createReviewOnRouteDAO(review);
    }




}
