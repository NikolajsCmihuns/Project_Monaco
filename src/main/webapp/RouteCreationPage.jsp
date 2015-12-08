<%@ page import="AlexPackage.DB.Helper.HelperCountry" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="AlexPackage.DB.Helper.HelperTags" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.Map" %>
<%
    Optional<Integer> userId = (Optional<Integer>) session.getAttribute("userID");
    if (userId == null) {
        String redirectURL = request.getContextPath() + "/route_auth";
        response.sendRedirect(redirectURL);
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="RouteCreationStyle.css">
    <title>Route</title>
</head>
<body>
<div id="container">
    <div id="menu">
        <form id="fmenu" name="fmenu" action="${pageContext.request.contextPath}/route_save" method="POST">
            <label for="helperCountry">Country:</label>
            <select id="helperCountry" name="helperCountry" class="select_width" onchange="getCoordinates()">
                <option value=""></option>
                <%
                    Map<String, List> routeMetaInfo = (Map<String, List>) request.getAttribute("model");
                    List<HelperCountry> allCountries = routeMetaInfo.get("countries");
                    Iterator<HelperCountry> iteratorCountries = allCountries.iterator();
                    while (iteratorCountries.hasNext()) {
                        HelperCountry helperCountry = iteratorCountries.next();
                %>
                <option value="<%=helperCountry.getShortName()%>"><%=helperCountry.getLongName()%>
                </option>
                <%
                    }
                %>
            </select>
            <input type="text" id="city" name="city" value="" class="tag_width" required/>
            <input type="text" id="routeName" name="routeName" class="tag_width"
                   placeholder="Enter route name" required/>
            <select required id="tag" name="tag" class="select_width">
                <option value="">Choose Tag</option>
                <%
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
            <input type="text" value="" readonly class="distance" id="routeDistance" name="routeDistance"/>&nbsp;km
            <input type="submit" value="Save">
            <input type="hidden" id="route" name="route" value=""/>
        </form>
    </div>
    <div id="map"></div>
    <div id="pois">
        <table id="poisTable">
            <tbody id="poisResults"></tbody>
        </table>
    </div>
</div>

<script type="text/javascript">
    var lat, lng;
    var map;
    var cities;
    var currentCountry;
    var places;
    var MARKER_PATH = 'https://maps.gstatic.com/intl/en_us/mapfiles/marker_green';
    var markers = [];
    var infoWindow;
    var icon;
    var routeNodes = [];
    var routePath;

    function getCoordinates() {
        clearResults();
        clearMarkers();
        document.getElementById("city").value = "";
        currentCountry = document.getElementById("helperCountry").value;
        if (currentCountry != "") {
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({'address': currentCountry}, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    lat = results[0].geometry.location.lat();
                    lng = results[0].geometry.location.lng();
                    initMap();
                }
            });
        } else {
            currentLocation();
        }
    }

    function currentLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);
        } else {
            window.alert("Geolocation is not supported by this browser.");
        }
    }

    function showPosition(position) {
        lat = position.coords.latitude;
        lng = position.coords.longitude;
        initMap();
    }

    function dropMarker(i) {
        return function () {
            markers[i].setMap(map);
        };
    }

    function showInfoWindow() {
        var marker = this;
        places.getDetails({placeId: marker.placeResult.place_id},
                function (place, status) {
                    if (status !== google.maps.places.PlacesServiceStatus.OK) {
                        return;
                    }

                    if (infoWindow != undefined) {
                        infoWindow.close();
                    }

                    var table = document.createElement("table");

                    var trWeb = document.createElement("tr");
                    var tdWeb = document.createElement("td");
                    var a = document.createElement("a");
                    a.setAttribute("href", place.url);
                    var name = document.createTextNode(place.name);
                    a.appendChild(name);


                    tdWeb.appendChild(a);
                    trWeb.appendChild(tdWeb);

                    var trAddress = document.createElement("tr");
                    var tdAddress = document.createElement("td");
                    var address = document.createTextNode(place.vicinity);
                    tdAddress.appendChild(address);
                    trAddress.appendChild(tdAddress);

                    table.appendChild(trWeb);
                    table.appendChild(trAddress);

                    infoWindow = new google.maps.InfoWindow({
                        content: table
                    });
                    infoWindow.open(map, marker);

                });
    }

    function addResult(result, i) {
        var results = document.getElementById("poisResults");
        var markerLetter = String.fromCharCode('A'.charCodeAt(0) + i);
        var markerIcon = MARKER_PATH + markerLetter + '.png';

        var tr = document.createElement('tr');
        tr.style.backgroundColor = (i % 2 === 0 ? '#F0F0F0' : '#FFFFFF');

        var iconTd = document.createElement('td');
        var nameTd = document.createElement('td');
        nameTd.onclick = function () {
            google.maps.event.trigger(markers[i], 'click');
        };

        var icon = document.createElement('img');
        icon.src = markerIcon;

        var name = document.createTextNode(result.name);
        iconTd.appendChild(icon);
        nameTd.appendChild(name);
        tr.appendChild(iconTd);
        tr.appendChild(nameTd);

        var btnTd = document.createElement("td");
        var button = document.createElement("input");
        button.type = "button";
        button.value = "+";
        button.addEventListener('click', function () {
                    addRouteNode(result, tr);
                }, false
        );

        var btnTdRemove = document.createElement("td");
        var btnRemove = document.createElement("input");
        btnRemove.type = "button";
        btnRemove.value = "-";
        btnRemove.addEventListener('click', function () {
                    removeRouteNode(result, tr, i);
                }, false
        );


        btnTd.appendChild(button);
        tr.appendChild(btnTd);

        btnTdRemove.appendChild(btnRemove);
        tr.appendChild(btnTdRemove);

        results.appendChild(tr);
    }

    function calculateDistance() {

        var from = "";
        var to = "";
        var distance = 0;

        for (i = 0; i < routeNodes.length; i++) {
            var latLng = routeNodes[i].split("|");
            if (from == "") {
                from = new google.maps.LatLng(latLng[0], latLng[1]);
            } else if (to == "") {
                to = new google.maps.LatLng(latLng[0], latLng[1]);
            }
            if (from != "" && to != "") {
                // get kilometers
                distance = distance + parseFloat((google.maps.geometry.spherical.computeDistanceBetween(from, to) / 1000));
                distance = +distance.toFixed(2);
                from = to;
                to = "";
            }
        }
        document.getElementById("routeDistance").value = distance;
    }

    function removeRouteNode(result, tr, i) {

        if (routePath != undefined) {
            routePath.setMap(null);
        }
        tr.style.backgroundColor = (i % 2 === 0 ? '#F0F0F0' : '#FFFFFF');

        var placeCoordinates = result.geometry.location.lat() + "|" + result.geometry.location.lng();
        for (i = 0; i < routeNodes.length; i++) {
            if (routeNodes[i] == placeCoordinates) {
                routeNodes.splice(i, 1);
            }
        }
        if (routeNodes.length > 1) {
            drawRoute();
        }
        document.getElementById("route").value = routeNodes;
        calculateDistance();

    }

    function drawRoute() {
        var routeCoordinates = [];
        for (i = 0; i < routeNodes.length; i++) {
            var latLng = routeNodes[i].split("|");
            routeCoordinates.push(new google.maps.LatLng(latLng[0], latLng[1]));
        }

        routePath = new google.maps.Polyline({
            path: routeCoordinates,
            strokeColor: "#0000FF",
            strokeOpacity: 0.8,
            strokeWeight: 2
        });
        routePath.setMap(map);
    }

    function addRouteNode(result, tr) {

        tr.style.backgroundColor = '#00FF00';

        var placeCoordinates = result.geometry.location.lat() + "|" + result.geometry.location.lng();
        var exists = false;
        var i = 0;
        while (i < routeNodes.length && exists == false) {
            if (placeCoordinates == routeNodes[i]) {
                exists = true;
            }
            i++;
        }

        if (exists == false) {
            routeNodes.push(placeCoordinates);
        }

        document.getElementById("route").value = routeNodes;
        if (routeNodes.length > 1) {
            if (routePath != undefined) {
                routePath.setMap(null);
            }
            drawRoute();
        }
        calculateDistance();
    }

    function clearMarkers() {
        for (var i = 0; i < markers.length; i++) {
            if (markers[i]) {
                markers[i].setMap(null);
            }
        }
        markers = [];
    }

    function clearResults() {
        var results = document.getElementById('poisResults');
        while (results.childNodes[0]) {
            results.removeChild(results.childNodes[0]);
        }
    }

    function search() {
        var search = {
            bounds: map.getBounds(),
            types: ['establishment']
        };

        places.nearbySearch(search, function (results, status) {
            if (status === google.maps.places.PlacesServiceStatus.OK) {
                clearResults();
                clearMarkers();
                for (var i = 0; i < results.length; i++) {
                    var markerLetter = String.fromCharCode('A'.charCodeAt(0) + i);
                    var markerIcon = MARKER_PATH + markerLetter + '.png';
                    markers[i] = new google.maps.Marker({
                        position: results[i].geometry.location,
                        animation: google.maps.Animation.DROP,
                        icon: markerIcon
                    });
                    markers[i].placeResult = results[i];
                    google.maps.event.addListener(markers[i], 'click', showInfoWindow);
                    setTimeout(dropMarker(i), i * 100);
                    addResult(results[i], i);
                }
            }
        });
    }

    function onPlaceChanged() {
        var place = cities.getPlace();
        if (place.geometry) {
            map.panTo(place.geometry.location);
            map.setZoom(15);
            search();
        }
    }

    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 7,
            center: {lat: lat, lng: lng},
            mapTypeControl: false,
            panControl: false,
            zoomControl: false,
            streetViewControl: false
        });

//        cheat to populate hidden route - if none of the options selected
//        put the current location - too lazy to validate :D
        var iAmHere = lat + "|" + lng;
        document.getElementById("route").value = iAmHere;

        if (currentCountry == "") {
            currentCountry = "LV";
        }

        cities = new google.maps.places.Autocomplete(
                (
                        document.getElementById("city")),
                {
                    types: ['(cities)'],
                    componentRestrictions: {'country': currentCountry}
                }
        );
        document.getElementById("helperCountry").value = currentCountry;
        places = new google.maps.places.PlacesService(map);
        cities.addListener('place_changed', onPlaceChanged);

    }

</script>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCBtK0VA1Yy5i-vDXEcXq9XHo6vZ4Ke-jc&signed_in=true&libraries=places,geometry&callback=getCoordinates">
</script>
</body>
</html>