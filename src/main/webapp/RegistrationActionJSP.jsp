<%@ page import="MaximPackage.Services.RegistrationService" %>
<%@ page import="MaximPackage.Database.UserDAOImplementation" %>
<%@ page import="MaximPackage.User" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head><title>Result</title></head>
<body>
<%
    // Mandatory
    String nickName = request.getParameter("rNickName");
    String password = request.getParameter("rPassword");
    String email = request.getParameter("rEmail");
    Integer cityID = Integer.valueOf(request.getParameter("rCity"));
    Integer countryID = Integer.valueOf(request.getParameter("rCountry"));
    // Additional
    String name = request.getParameter("rName");
    String surname = request.getParameter("rSurname");
    Integer age = Integer.valueOf(request.getParameter("rAge"));
    Integer tagID = Integer.valueOf(request.getParameter("rTag"));

    RegistrationService registrationService = RegistrationService.getInstance();

    Integer registeredUserID = registrationService.tryRegistration(nickName,password,email,cityID,countryID,name,surname,age,tagID);

    if (registeredUserID >= 0) {
        session.setAttribute("userID",registeredUserID);

        String storedNickname = "";

        UserDAOImplementation userDAO = new UserDAOImplementation();
        User userFromDB = userDAO.getUserByID(registeredUserID);
        storedNickname = userFromDB.getNickname();

%>
<h2>Now you are registered as <%= storedNickname %>!</h2>
<%--Insert your relevant path to your landing page here--%>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>View map</h3></a>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>Create route</h3></a>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>Create place</h3></a>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>Create event</h3></a>
<a href="<%=    "/java2/LoginPage.jsp" %>"><h3>Create review</h3></a>
<%
} else {
%>
<h2>Failed to register... Make sure you have entered all mandatory fields!</h2>
<a href="<%= request.getParameter("backUrl") %>"><h3>Try Again</h3></a>
<%
    }
%>
</body>
</html>