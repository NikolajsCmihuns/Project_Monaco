package nikocmihPackage.servlet.MVC;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikolajs Cmihuns on 11/5/2015.
 */
public class MVCFilterR implements Filter {

    private Map<String, MVCControllerR> controllers;


    public void init(FilterConfig filterConfig) throws ServletException {

        controllers = new HashMap<String, MVCControllerR>();

        // register all url localhost:xxxx/hello and according controllers

        // controllers.put("/helloo", new HelloWorldController());
        controllers.put("/review", new ReviewPageController());
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

    public void destroy() {

    }
}
