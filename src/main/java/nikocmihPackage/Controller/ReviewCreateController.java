package nikocmihPackage.Controller;


import lv.javaguru.java2.database.DBException;
import nikocmihPackage.database.ReviewDAOInterface;
import nikocmihPackage.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikolajs Cmihuns on 11/16/2015.
 */
@Component
public class ReviewCreateController implements MVCControllerR {

    @Autowired
    private ReviewDAOInterface reviewDaoInterface;

    @Override
    public MVCModelR execute(HttpServletRequest request) {

        //should be create based on HttpServletRequest request data later !!!

        /*String routeCountry = request.getParameter("country");
        String routeCity = request.getParameter("city");
        String routeName = request.getParameter("routeName");
        String routeTag = request.getParameter("tag"); // table route
        String route = request.getParameter("route"); // table place & places_in_route
        String distance = request.getParameter("routeDistance"); // table route*/

        Review review = ReviewBuilder.createReview()
                .withRouteID(1)
                .withTitle("Route_1")
                .withBody("Review text")
                .withCreatorID(1)
                .build();

        try {
            reviewDaoInterface.createReviewOnRouteDAO(review);
        } catch (DBException e) {
            System.out.println("Error in ReviewCreateController while executing " +
                               "createReviewOnRouteDAO(review), review ->  " + review);
            e.printStackTrace();
        }


        return new MVCModelR("DB data, etc", "/ReviewCreationPage.jsp");
    }

}
