<%@ page import="MaximPackage.Services.LoginService" %>
<%@ page import="MaximPackage.Database.UserDAOImplementation" %>
<%@ page import="lv.javaguru.java2.database.UserDAO" %>
<%@ page import="MaximPackage.User" %>
<%@ page import="nikocmihPackage.Console" %>
<%@ page import="MaximPackage.ConsolePackage.ConsoleOutput" %>
<%@ page import="java.util.Objects" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head><title>Result</title></head>
<body>
<%
    String nickName = request.getParameter("lNickName");
    String password = request.getParameter("lPassword");

    LoginService loginService = new LoginService(new UserDAOImplementation());
    Integer loggedUserID = loginService.tryLogin(nickName,password);

    if (loggedUserID >= 0) {
        session.setAttribute("userID", loggedUserID);

        // Just for test we get user nickname from DB again
        String storedNickname = "";

        ConsoleOutput.printObject("" + loggedUserID);

        UserDAOImplementation userDAO = new UserDAOImplementation();
        User userFromDB = userDAO.getUserByID(loggedUserID);
        storedNickname = userFromDB.getNickname();
%>
<h2>You are logged in as <%= storedNickname %>!</h2>
<%--Insert your relevant path to your landing page here--%>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>View map</h3></a>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>Create route</h3></a>
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
