<%@ page import="AlexPackage.DB.Route" %>
<%@ page import="AlexPackage.DB.RouteDAOImplementation" %>
<%--
  Created by IntelliJ IDEA.
  User: Aborigens
  Date: 07-Nov-15
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="RouteCreationStyle.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#dialog").dialog(
                    {
                        dialogClass: "no-close",
                        buttons: [
                            {
                                text: "OK",
                                class: "okButton",
                                click: function () {
                                    $(this).dialog("close");
                                    window.location = "./";
                                }
                            }
                        ]
                    }
            );
        });
    </script>
    <title>Route Saved</title>
</head>
<body>
<%
    String routeCountry = request.getParameter("country");
    String routeCity = request.getParameter("city");
    String routeName = request.getParameter("routeName");
    String routeTag = request.getParameter("tag"); // table route
    String route = request.getParameter("route"); // table place & places_in_route
    String distance = request.getParameter("routeDistance"); // table route

    Route itinerary = new Route(routeCountry, routeCity, routeName, routeTag, route, distance);
    RouteDAOImplementation routeDAOImplementation = new RouteDAOImplementation();
    if (routeDAOImplementation.saveRoute(itinerary)) {
%>
<div id="dialog" title="Route Saved">
    You route <%=routeName%> is saved
</div>
<%
    }

%>

</body>
</html>
