<%@ page import="MaximPackage.Services.LoginService" %>
<%@ page import="MaximPackage.Database.UserDAOImplementation" %>
<%@ page import="MaximPackage.User" %>
<%@ page import="MaximPackage.ConsolePackage.ConsoleOutput" %>
<%@ page import="java.util.Optional" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>
<head><title>Result</title></head>
<body>
<%
    String nickName = request.getParameter("lNickName");
    String password = request.getParameter("lPassword");

    LoginService loginService = new LoginService(new UserDAOImplementation());
    Optional<Integer> loggedUserID = loginService.tryLogin(nickName, password);

    if (loggedUserID.get() != User.USER_NOT_FOUND) {
        session.setAttribute("userID", loggedUserID);

        // Just for test we get user nickname from DB again
        String storedNickname = "";

        ConsoleOutput.printObject("" + loggedUserID.get());

        UserDAOImplementation userDAO = new UserDAOImplementation();
        User userFromDB = userDAO.getUserByID(loggedUserID.get());
        storedNickname = userFromDB.getNickname();
%>
<h2>You are logged in as <%= storedNickname %>!</h2>
<%--Insert your relevant path to your landing page here--%>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>View map</h3></a>
<a href="<%=    "/java/route" %>"><h3>Create route</h3></a>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>Create place</h3></a>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>Create event</h3></a>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>Create review</h3></a>
<%
} else {
%>
<h2>Failed to log in... Try again </h2>
<a href="<%= request.getParameter("backUrl") %>"><h3>Try Again</h3></a>
<%
    }
%>
</body>
</html>
