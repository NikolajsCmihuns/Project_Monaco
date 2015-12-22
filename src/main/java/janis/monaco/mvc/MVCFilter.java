package janis.monaco.mvc;

import janis.monaco.config.SpringHibernateConfig;
import janis.monaco.controllers.ControllerPlace;
import janis.monaco.controllers.ControllerPlaceForm;
import org.jboss.logging.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by janis on 04/12/15.
 */

public class MVCFilter implements Filter {

    private Map<String, MVCController> controllers;
    private ApplicationContext springContext;
    private static final Logger logger = Logger.getLogger(MVCFilter.class.getName());




    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            springContext = new AnnotationConfigApplicationContext(SpringHibernateConfig.class);
        } catch (BeansException e) {
            logger.log(Logger.Level.INFO, "Spring context failed to start", e);
        }
        controllers = new HashMap<>();

        controllers.put("/place", getBean(ControllerPlace.class));
        controllers.put("/place/form", getBean(ControllerPlaceForm.class));



    }

    private MVCController getBean(Class clazz){

        return (MVCController)springContext.getBean(clazz);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String contextURI = request.getServletPath();
        MVCController controller = controllers.get(contextURI);

        if (controller != null) {
            MVCModel model = controller.execute(request);
            request.setAttribute("model", model.getData());

            ServletContext context = request.getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getViewName());

            requestDispatcher.forward(request,response);
        }
        else filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
