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

            <div id="routePlaceholder" name="routePlaceholder"
                 style="float:left;margin-top: 50px;width: 570px;
                height: 400px;margin-top: 50px;"></div>
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
                                   onclick="viewRouteOnMap('<%=route.getRoute().toString()%>')"></td>
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

    var markers = [];
    var MARKER_PATH = 'https://maps.gstatic.com/intl/en_us/mapfiles/marker_green';

    function dropMarker(marker) {
        return function () {
            marker.setMap(map);
        };
    }

    function showInfoWindow(marker, address) {
        var infoWindow = new google.maps.InfoWindow;
        infoWindow.setContent(address.formatted_address);
        infoWindow.open(map, marker);
    }

    function takeItEasyToShowRoot(currentCoordinates, i) {
        return function () {
            var geocoder = new google.maps.Geocoder;
            var coordinates = currentCoordinates.split(",");
            var positionLatLng = {lat: parseFloat(coordinates[0]), lng: parseFloat(coordinates[1])};

            geocoder.geocode({'location': positionLatLng}, function (results, status) {
                if (status === google.maps.GeocoderStatus.OK) {
                    if (results[1]) {
                        map.setZoom(15);
                        var markerLetter = String.fromCharCode('A'.charCodeAt(0) + i);
                        var markerIcon = MARKER_PATH + markerLetter + '.png';

                        markers[i] = new google.maps.Marker({
                            position: positionLatLng,
                            animation: google.maps.Animation.DROP,
                            icon: markerIcon
                        });
                        setTimeout(dropMarker(markers[i]), i * 1000);
                        google.maps.event.addListener(markers[i], 'click', function () {
                            showInfoWindow(markers[i], results[1]);
                        });

                    }
                }
            });
        }
    }

    function viewRouteOnMap(routeCoordinates) {

        var latLng = routeCoordinates.split("|");
        var startCoordinates = latLng[0].split(",");

        map = new google.maps.Map(document.getElementById('routePlaceholder'), {
            zoom: 15,
            center: {lat: parseFloat(startCoordinates[0]), lng: parseFloat(startCoordinates[1])},
            mapTypeControl: false,
            panControl: false,
            zoomControl: false,
            streetViewControl: false
        });

        var routeNodes = [];
        for (i = 0; i < latLng.length; i++) {
            var coordinates = latLng[i].split(",");
            routeNodes.push(new google.maps.LatLng(parseFloat(coordinates[0]), parseFloat(coordinates[1])));
            setTimeout(takeItEasyToShowRoot(latLng[i], i), 1000);
        }

        var routePath = new google.maps.Polyline({
            path: routeNodes,
            strokeColor: "#0000FF",
            strokeOpacity: 0.8,
            strokeWeight: 2
        });
        routePath.setMap(map);

    }

</script>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCBtK0VA1Yy5i-vDXEcXq9XHo6vZ4Ke-jc&signed_in=true&libraries=places,geometry">
</script>
</body>
</html>
























