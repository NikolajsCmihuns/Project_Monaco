package nikocmihPackage.servlet.MVC;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikolajs Cmihuns on 11/5/2015.
 */
public interface MVCControllerR {
    MVCModelR execute(HttpServletRequest request);
}
