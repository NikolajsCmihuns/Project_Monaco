package nikocmihPackage.Controller;

import lv.javaguru.java2.database.DBException;
import nikocmihPackage.database.ReviewDAOInterface;
import nikocmihPackage.domain.Review;
import nikocmihPackage.domain.ReviewBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikolajs Cmihuns on 12/21/2015.
 */
@Component
public class ReviewDeleteController implements MVCControllerR {

    @Autowired
    private ReviewDAOInterface reviewDaoInterface;

    @Override
    public MVCModelR execute(HttpServletRequest request) {

        //get review if from request
        Integer reviewID = new Integer(3);

        try {
            reviewDaoInterface.deleteReviewOnRouteDAO(reviewID);
        } catch (DBException e) {
            System.out.println("Error in ReviewDeleteController while executing " +
                    "deleteReviewOnRouteDAO(reviewID), reviewID ->  " + reviewID);
            e.printStackTrace();
        }


        return new MVCModelR("DB data, etc", "/ReviewCreationPage.jsp");
    }

}
