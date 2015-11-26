package MaximPackage.Servlet.MVC;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maksimspuskels on 03/11/15.
 */

public interface MVCController {
    MVCModel executePost(HttpServletRequest request);
    MVCModel executeGet(HttpServletRequest request);
}
