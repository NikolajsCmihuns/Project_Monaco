package MaximPackage.Servlet;

import MaximPackage.ConsolePackage.ConsoleOutput;
import MaximPackage.Database.UserDAOImplementation;
import MaximPackage.Services.LoginService;
import MaximPackage.Servlet.MVC.DataSources.LoginActionDataSource;
import MaximPackage.Servlet.MVC.MVCController;
import MaximPackage.Servlet.MVC.MVCModel;
import MaximPackage.User;
import lv.javaguru.java2.database.DBException;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Component
public class LoginPageServlet implements MVCController {

    @Override
    public MVCModel execute(HttpServletRequest request) {

        String nickName = request.getParameter("lNickName");
        String password = request.getParameter("lPassword");

        LoginService loginService = new LoginService(new UserDAOImplementation());
        Optional<Integer> loggedUserID = loginService.tryLogin(nickName, password);

        MVCModel returnModel;

        if (loggedUserID.get() != User.USER_NOT_FOUND) {
            HttpSession session = request.getSession();
            session.setAttribute("userID", loggedUserID);

            // Just for test we get user nickname from DB again
            String storedNickname = "";

            ConsoleOutput.printObject("" + loggedUserID.get());

            UserDAOImplementation userDAO = new UserDAOImplementation();
            try {
                User userFromDB = userDAO.getUserByID(loggedUserID.get());
                storedNickname = userFromDB.getNickname();

                LoginActionDataSource dataSource = new LoginActionDataSource(storedNickname);

                returnModel = new MVCModel(dataSource, "/LoginActionJSP.jsp");
            }
            catch (DBException e) {
                returnModel = new MVCModel("", "");
            }
        }
        else {
            // Implement failure page
            returnModel = new MVCModel("", "");
        }

        return returnModel;
    }
}
