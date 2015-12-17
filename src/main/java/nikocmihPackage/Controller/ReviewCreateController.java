package nikocmihPackage.Controller;

import nikocmihPackage.Controller.MVCControllerR;
import nikocmihPackage.Controller.MVCModelR;
import nikocmihPackage.database.ReviewDAOInterface;
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









        return new MVCModelR("DB data, etc", "/ReviewCreationPage.jsp");
    }

}
