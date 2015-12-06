<%@ page import="java.util.Optional" %>
<%@ page import="AlexPackage.DB.Helper.HelperTags" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="AlexPackage.DB.Helper.HelperChosenTag" %>
<%@ page import="AlexPackage.DB.Domain.Route" %>
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
        <form id="fmenu" name="fmenu" action="${pageContext.request.contextPath}/route_view" method="POST">
            <select required id="tag" name="tag" class="select_width">
                <%
                    Map<String, List> routeMetaInfo = (Map<String, List>) request.getAttribute("model");

                    // check if there is a selected tag
                    List<HelperChosenTag> chosenTag = routeMetaInfo.get("chosenTag");
                    if (chosenTag != null) {
                %>
                <option value="<%=chosenTag.get(0).getChosenTagId()%>"><%=chosenTag.get(0).getChosenTagText()%>
                </option>
                <%
                } else {
                %>
                <option value="">Choose Tag</option>
                <%
                    }
                    List<HelperTags> helperTagsList = routeMetaInfo.get("tags");
                    Iterator<HelperTags> iteratorTags = helperTagsList.iterator();
                    while (iteratorTags.hasNext()) {
                        HelperTags tag = iteratorTags.next();
                %>
                <option value="<%=tag.getTagId()%>"><%=tag.getTagName()%>
                </option>
                <%
                    }
                %>
            </select>
            <input type="submit" id="tagPick" name="tagPick" value="Search"/>

            <div id="routePlaceholder" name="routePlaceholder" style="float:left;margin-top: 50px;"></div>
            <div style="float:right;margin-top: 50px;">
                <table id="routeIds" name="routeIds">
                    <%
                        List<Route> routes = routeMetaInfo.get("routeIds");
                        if (routes != null) {
                            Iterator<Route> iteratorRoute = routes.iterator();
                            int i = 0;
                            while (iteratorRoute.hasNext()) {
                                Route route = iteratorRoute.next();
                                if (i % 2 == 0) {
                    %>
                    <tr style="background-color: #F0F0F0">
                            <%
                            } else {
                        %>
                    <tr>
                        <%
                            }
                        %>
                        <td>Route ID:&nbsp;</td>
                        <td><%=route.getRouteId()%>
                        </td>
                        <td>Route Distance:&nbsp;</td>
                        <td><%=route.getDistance()%>
                        </td>
                        <td><input type="button" id="chosenRoot" name="chosenRoot" value="View"
                                   onclick="viewRouteOnMap(<%=route.getRouteId()%>)"></td>
                    </tr>
                    <%
                                i++;
                            }
                        }
                    %>
                </table>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
    function viewRouteOnMap(routeId) {
        window.alert(routeId);
    }
</script>

</body>
</html>
