package MaximPackage.Servlet.MVC;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maksimspuskels on 03/11/15.
 */

public interface MVCController {
    MVCModel execute(HttpServletRequest request);
}
