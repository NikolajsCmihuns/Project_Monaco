package nikocmihPackage.servlet.MVCSpring;

import nikocmihPackage.servlet.MVC.MVCControllerR;
import nikocmihPackage.servlet.MVC.MVCModelR;
import nikocmihPackage.servlet.MVC.ReviewPageController;
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
 * Created by Nikolajs Cmihuns on 11/19/2015.
 */
public class MVCFilterSpring implements Filter {


    private Map<String, MVCControllerR> controllers;

    private ApplicationContext springContext;

    private static final Logger logger = Logger.getLogger(MVCFilterSpring.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }


        controllers = new HashMap<>();
        controllers.put("/review", getBean(ReviewPageController.class));


    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();
        MVCControllerR controller = controllers.get(contextURI);

        if (controller != null) {
            MVCModelR model = controller.execute(req);
            req.setAttribute("model", model.getData());

            ServletContext context = req.getServletContext();

            RequestDispatcher requestDispacher = context.getRequestDispatcher(model.getViewName());
            requestDispacher.forward(req, resp);
        }
        else filterChain.doFilter(request,response);
    }


    private MVCControllerR getBean(Class clazz){
        return (MVCControllerR) springContext.getBean(clazz);
    }



    public void destroy() {

    }



}
