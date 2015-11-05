package MaximPackage.Servlet.MVC;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maksimspuskels on 03/11/15.
 */
public class HelloWorldController implements MVCController {

    @Override
    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Hello form MVC","/helloWorld.jsp");
    }
}
