<%@ page import="java.util.Optional" %>
<%@ page import="AlexPackage.DB.Helper.Tags" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
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
                <option value="">Choose Tag</option>
                <%
                    Map<String, List> routeMetaInfo = (Map<String, List>) request.getAttribute("model");
                    List<Tags> tagsList = routeMetaInfo.get("tags");
                    Iterator<Tags> iteratorTags = tagsList.iterator();
                    while (iteratorTags.hasNext()) {
                        Tags tag = iteratorTags.next();
                %>
                <option value="<%=tag.getTagId()%>"><%=tag.getTagName()%>
                </option>
                <%
                    }
                %>
            </select>
        </form>
    </div>
</div>
</body>
</html>
