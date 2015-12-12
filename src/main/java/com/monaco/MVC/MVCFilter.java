package com.monaco.MVC;

import com.monaco.Controllers.LoginController;
import com.monaco.Controllers.RegistrationController;
import com.monaco.Controllers.SessionCheckController;
import com.monaco.Controllers.UserRestController;
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
 * Created by maksimspuskels on 03/11/15.
 */

public class MVCFilter implements Filter {

    private static final Logger logger = Logger.getLogger(MVCFilter.class.getName());

    private Map<String, MVCController> controllers;

    private ApplicationContext springContext;

    private MVCController getBean (Class clazz) {
            return (MVCController) springContext.getBean(clazz);
        }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }

        controllers = new HashMap<>();
        // Root path
        controllers.put("/", getBean(SessionCheckController.class));
        // Login page
        controllers.put("/login", getBean(LoginController.class));
        // Registration action
        controllers.put("/register",getBean(RegistrationController.class));
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String contextURI = request.getServletPath();
        MVCController controller = controllers.get(contextURI);

        if (controller != null) {
            MVCModel model;
            if (request.getMethod().equals("POST")) {
                model = controller.executePost(request);
                request.setAttribute("model", model.getData());
            }
            else {
                model = controller.executeGet(request);
                request.setAttribute("model", model.getData());
            }

            ServletContext context = request.getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getViewName());

            requestDispatcher.forward(request, response);
        }
        else filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
