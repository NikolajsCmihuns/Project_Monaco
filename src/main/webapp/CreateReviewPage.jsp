<%--
  Created by IntelliJ IDEA.
  User: Nikolajs
  Date: 11/3/2015
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Review</title>
</head>
<body>
<h1> Create your own review !!! </h1>
<%
  double num = Math.random();
  if (num > 0.95) {
%>
<h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
<%
} else {
%>
<h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
<%
  }
%>
<a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>

</body>
</html>
