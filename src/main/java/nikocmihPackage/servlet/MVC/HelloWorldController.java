package nikocmihPackage.servlet.MVC;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikolajs Cmihuns on 11/5/2015.
 */
public class HelloWorldController implements MVCControllerR {

        @Override
        public MVCModelR execute(HttpServletRequest request) {

            // Can return any data, as MVCModelR class has private Object data variable

            return new MVCModelR("Hello from MVC", "/helloWorld.jsp");
        }

}
