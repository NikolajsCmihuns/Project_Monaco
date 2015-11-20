package nikocmihPackage.servlet.MVC;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikolajs Cmihuns on 11/16/2015.
 */
public class ReviewPageController implements MVCControllerR {

    @Override
    public MVCModelR execute(HttpServletRequest request) {
        return new MVCModelR("Create Review", "/CreateReviewPage.jsp");
    }

}
