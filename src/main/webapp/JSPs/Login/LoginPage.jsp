<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title> Monaco login </title>
</head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/JSPs/Login/LoginPageCSS.css" />

<body>

    <form id="loginForm" action="login" method="POST">
        <div id="loginDiv">
            <input name="backUrl" value="<%= request.getRequestURI() %>" hidden>
            Nickname:<br>
            <input id="lNickName" type="text" name="lNickName">
            <br>
            Password:<br>
            <input id="lPassword" type="text" name="lPassword">
            <br>
            <br>
            <button type="login" value="Login">Login</button>
        </div>
    </form>

    <form id="registerForm" action="register" method="GET">
        <button type="register" value="Register">Register</button>
    </form>

</body>
</html>