package janis.monaco.mvc;

import MaximPackage.Servlet.MVC.HelloWorldController;
import MaximPackage.Servlet.MVC.LoginPageController;
import MaximPackage.Servlet.MVC.MVCController;
import MaximPackage.Servlet.MVC.MVCModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by maksimspuskels on 03/11/15.
 */

public class MVCFilter implements Filter {

    private Map<String, MVCController> controllers;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        controllers = new HashMap<>();
        controllers.put("/hello", new HelloWorldController());
        controllers.put("/login", new LoginPageController());
        controllers.put("", new LoginPageController());
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
