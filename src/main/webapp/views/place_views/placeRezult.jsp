<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janis
  Date: 12/22/15
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
