package nikocmihUnitTestPackage.domain;

import lv.javaguru.java2.database.DBException;
import nikocmihPackage.domain.Review;
import nikocmihPackage.domain.ReviewBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Nikolajs Cmihuns on 12/16/2015.
 */
public class ReviewBuilderTest {

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
        System.out.println("review) -> " + review);

        ReviewBuilder obj = ReviewBuilder.createReview();
        System.out.println("obj -> " + obj);
        System.out.println("obj.withRouteID(3) -> " + obj.withCreatorID(1));
    }



}
