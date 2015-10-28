<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Project Monaco</title>
</head>
<link href="<c:url value="/LoginPageCSS.css" />" rel="stylesheet">
<body>
    <form id="loginForm">
        <div id="loginDiv">
            Nickname:<br>
            <input id="lNickName" type="text" name="lNickName">
            <br>
            Password:<br>
            <input id="lPassword" type="text" name="lPassword">
            <br>
            <br>
            <button id="loginButton" onclick="">Login</button>
        </div>
    </form>

    <form id="registrationForm">
        <div id="registerDiv">
            Name:<br>
            <input id="rName" type="text" name="rName">
            <br>
            Surname:<br>
            <input id="rSurname" type="text" name="rSurname">
            <br>
            Nickname:*<br>
            <input id="rNickname" type="text" name="rNickname">
            <br>
            Password:*<br>
            <input id="rPassword" type="text" name="rPassword">
            <br>
            Email:*<br>
            <input id="rEmail" type="text" name="rEmail">
            <br>
            Age:<br>
            <input id="rAge" type="text" name="rAge">
            <br>
            City:*<br>
            <input id="rCity" type="text" name="rCity">
            <br>
            Country:*<br>
            <input id="rCountry" type="text" name="rCountry">
            <br>
            Tag:<br>
            <input id="rTag" type="text" name="rTag">
            <br>
            <br>
            <button id="registerButton" onclick="">Register</button>
        </div>
    </form>
</body>
</html>