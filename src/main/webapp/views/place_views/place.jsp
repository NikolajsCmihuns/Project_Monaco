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
    <title>OK</title>





</head>
<body>

<table>
  <c:forEach var= "place" items='${model}' >
    <c:forEach var= "properties" items='${place}' >
      <tr>
        <td>${properties}</td>
      </tr>
    </c:forEach>
  </c:forEach>
</table>
</body>
</html>
