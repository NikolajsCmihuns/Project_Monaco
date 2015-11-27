<%@ page import="MaximPackage.Servlet.MVC.DataSources.LandingPageDS" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>
<head><title>Result</title></head>
<body>
<%
  LandingPageDS dataSource = (LandingPageDS) request.getAttribute("model");
  String storedNickname = dataSource.getUserNickname();
  if (storedNickname != null) {
%>
<h2>You are logged in as <%= storedNickname %>!</h2>
<%--Insert your relevant path to your landing page here--%>
<a href="<%=    "/java2/" %>"><h3>View map</h3></a>
<a href="<%=    "/java2/route" %>"><h3>Create route</h3></a>
<a href="<%=    "/java2/" %>"><h3>Create place</h3></a>
<a href="<%=    "/java2/" %>"><h3>Create event</h3></a>
<a href="<%=    "/java2/" %>"><h3>Create review</h3></a>
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
