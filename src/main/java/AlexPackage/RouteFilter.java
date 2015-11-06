package AlexPackage;

import MaximPackage.Servlet.MVC.MVCModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aborigens on 06-Nov-15.
 */
public class RouteFilter implements Filter {

    private Map<String, RouteController> controllers;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        controllers = new HashMap<>();
        controllers.put("/route", new RouteCreationController());
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
