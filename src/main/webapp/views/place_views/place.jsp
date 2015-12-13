<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
  Created by IntelliJ IDEA.
  User: janis
  Date: 11/19/15
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <title>Places Data</title>

  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>




</head>
<body>



<table class="table table-hover" style="width:90%">
  <tr>
    <th>PlaceID</th>
    <th>PlaceLatitude</th>
    <th>PlaceLongitude</th>
    <th>PlaceImgURL</th>
    <th>PlaceName</th>
    <th>PlaceAddress</th>
    <th>PlaceTypeID</th>
  </tr>

  <c:forEach var= "place" items='${model}' >
    <tr>
      <c:forEach var= "properties" items='${place}' varStatus="count">

        <td>${properties}</td>

      </c:forEach>
    </tr>
  </c:forEach>

</table>

</body>
</html>
