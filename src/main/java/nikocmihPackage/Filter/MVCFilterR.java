package nikocmihPackage.Filter;


import nikocmihPackage.Controller.MVCControllerR;
import nikocmihPackage.Controller.MVCModelR;
import nikocmihPackage.Controller.ReviewCreateController;


import nikocmihPackage.Spring.SpringConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Nikolajs Cmihuns on 11/5/2015.
 */
public class MVCFilterR implements Filter {

    private Map<String, MVCControllerR> controllers;
    private ApplicationContext springContext;

    private static final Logger logger = Logger.getLogger(MVCFilterR.class.getName());

    private MVCControllerR getBean(Class clazz) {
        return (MVCControllerR) springContext.getBean(clazz);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        // raise up Spring configuration
        try {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class); // get application context
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e); // enable logging
        }

        controllers = new HashMap<String, MVCControllerR>();

        // register all url localhost:xxxx/hello and according controllers

        controllers.put("/review_create", getBean(ReviewCreateController.class));

        System.out.println("debug--nikocmih controllers HashMap " + controllers);

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // cast to HTTP request / response as they can be of any type
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // get the path, e.g., /RouteCreationPage
        String contextURI = req.getServletPath();

        MVCControllerR controller = controllers.get(contextURI);
        if (controller != null) {
            MVCModelR model = controller.execute(req);
            req.setAttribute("model", model.getData());

            // page context, that knows about all elements on the page
            ServletContext context = req.getServletContext();

            // get view name you want to be forwarded to
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getViewName());

            // get the party started
            requestDispatcher.forward(req, resp);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
