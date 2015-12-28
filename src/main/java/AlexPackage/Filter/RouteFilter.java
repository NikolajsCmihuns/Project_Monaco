package AlexPackage.Filter;

import AlexPackage.Controller.*;
import AlexPackage.Model.RouteModel;
import AlexPackage.Spring.SpringConfig;
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
 * Created by Aborigens on 06-Nov-15.
 */
public class RouteFilter implements Filter {

    private Map<String, RouteController> controllers;

    private ApplicationContext springContext;

    private static final Logger logger = Logger.getLogger(RouteFilter.class.getName());

    private RouteController getBean(Class clazz) {
        return (RouteController) springContext.getBean(clazz);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        // raise up Spring configuration
        try {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class); // get application context
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e); // enable logging
        }

        controllers = new HashMap<>();
        controllers.put("/route", getBean(RouteCreationController.class));
        controllers.put("/route_save", getBean(RouteSaveController.class));
        controllers.put("/route_view", getBean(RouteViewController.class));
        controllers.put("/route_auth", getBean(RouteAuthorizationController.class));
        controllers.put("/route_delete", getBean(RouteDeleteController.class));
        controllers.put("/route_update", getBean(RouteUpdateController.class));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // cast to HTTP request / response as they can be of any type
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // get the path, e.g., /RouteCreationPage
        String contextURI = req.getServletPath();

        RouteController controller = controllers.get(contextURI);
        if (controller != null) {
            RouteModel model = controller.execute(req);
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
