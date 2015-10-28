<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Project Monaco</title>
</head>
<link href="<c:url value="/LoginPageCSS.css" />" rel="stylesheet">
<body>
    <h1> Here we will have login dialog! </h1>

    <form>
        Login:<br>
        <input id="nickname" type="text" name="nickname">
        <br>
        Password:<br>
        <input id="password" type="text" name="password">
    </form>

</body>
</html>
