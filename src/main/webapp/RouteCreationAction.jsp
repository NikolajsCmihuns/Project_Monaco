<%@ page import="AlexPackage.DB.Domain.Route" %>
<%@ page import="AlexPackage.DB.RouteDAOImplementation" %>
<%@ page import="java.util.Optional" %>
<%--
  Created by IntelliJ IDEA.
  User: Aborigens
  Date: 07-Nov-15
  Time: 22:26
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
                                    window.location = "./route_view";
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

<div id="dialog" title="Route Saved">
    <%=request.getAttribute("model")%>
</div>
</body>
</html>
