<%@ page import="java.util.Optional" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="AlexPackage.DB.Domain.Route" %>
<%@ page import="AlexPackage.DB.Helper.HelperTags" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Aborigens
  Date: 12-Dec-15
  Time: 12:03
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
    <title>Delete Your Own Root</title>
</head>
<body>
<div id="container">
    <div id="menu">
        <form id="fmenu" name="fmenu" action="${pageContext.request.contextPath}/route_delete" method="POST">
            <table id="routesToDelete" name="routesToDelete">
                <tr>
                    <td>Route ID</td>
                    <td>Route Distance</td>
                    <td>Route Tag</td>
                    <td>Delete?</td>
                </tr>
                <%


                    Map<String, List> routeMetaInfo = (Map<String, List>) request.getAttribute("model");
                    List<Route> routesToDelete = routeMetaInfo.get("routesToDelete");
                    List<HelperTags> routesToDeleteTags = routeMetaInfo.get("routesToDeleteTags");

                    if (routesToDelete != null && routesToDeleteTags != null) {
                        Iterator<Route> routeToDelete = routesToDelete.iterator();
                        while (routeToDelete.hasNext()) {
                            Route currentRoute = routeToDelete.next();

                            Iterator<HelperTags> helperTagsIterator = routesToDeleteTags.iterator();
                            String routeTag = "";
                            while ("".equals(routeTag) && helperTagsIterator.hasNext()) {
                                HelperTags helperTags = helperTagsIterator.next();
                                if (String.valueOf(helperTags.getTagId()).equals(currentRoute.getRouteTag())) {
                                    routeTag = helperTags.getTagName();
                                }
                            }
                %>
                <tr>
                    <td><%=currentRoute.getRouteId()%>
                    </td>
                    <td><%=currentRoute.getDistance()%>
                    </td>
                    <td><%=routeTag%>
                    </td>
                    <td><input type="checkbox" name="route[]" value="<%=currentRoute.getRouteId()%>"
                               onchange="addRoute(this);"/></td>
                    <%
                            }
                        }


                    %>
                </tr>
            </table>
            <input type="hidden" value="" name="hiddenRoutesToDelete" id="hiddenRoutesToDelete"/>
            <input type="submit" name="deleteRoutes" id="deleteRoutes" value="Delete"/>
        </form>
    </div>
</div>
<script type="text/javascript">
    var routesToDelete = [];

    function addRoute(route) {

        if (route.checked == true) {
            routesToDelete.push(route.value);
        } else if (route.checked == false) {
            for (i = 0; i < routesToDelete.length; i++) {
                if (routesToDelete[i] == route.value) {
                    routesToDelete.splice(i, 1);
                }
            }
        }

        document.getElementById("hiddenRoutesToDelete").value = routesToDelete;
    }
</script>
</body>
</html>


























