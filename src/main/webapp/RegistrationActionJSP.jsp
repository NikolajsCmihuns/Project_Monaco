<%@ page import="MaximPackage.Services.RegistrationService" %>
<%@ page import="MaximPackage.Services.SessionService" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head><title>Result</title></head>
<body>
<%
    // Mandatory
    String nickName = request.getParameter("rNickName");
    String password = request.getParameter("rPassword");
    String email = request.getParameter("rEmail");
    String city = request.getParameter("rCity");
    String country = request.getParameter("rCountry");
    // Additional
    String name = request.getParameter("rName");
    String surname = request.getParameter("rSurname");
    Integer age = Integer.valueOf(request.getParameter("rAge"));
    String tag = request.getParameter("rTag");

    RegistrationService registrationService = RegistrationService.getInstance();

    boolean success = registrationService.tryRegistration(nickName,password,email,city,country,name,surname,age,tag);

    if (success) {
        SessionService userSession = SessionService.getInstance();
        String sessionUserName = userSession.getUserNickName();
%>
<h2>Now you are registered as <%= sessionUserName %>!</h2>
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