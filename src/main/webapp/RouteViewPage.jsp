<%@ page import="java.util.Optional" %>
<%--
  Created by IntelliJ IDEA.
  User: Aborigens
  Date: 15-Nov-15
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Optional<Integer> userId = (Optional<Integer>) session.getAttribute("userID");
    if (userId == null) {
        String redirectURL = request.getContextPath() + "/route_auth";
        response.sendRedirect(redirectURL);
    }
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="RouteCreationStyle.css">
    <title>View route</title>
</head>
<body>
<div id="container">
    <div id="menu">
        <form id="fmenu" name="fmenu">
            <select required id="tag" name="tag" class="select_width">
                <option value=""></option>
            </select>
        </form>
    </div>
</div>
</body>
</html>