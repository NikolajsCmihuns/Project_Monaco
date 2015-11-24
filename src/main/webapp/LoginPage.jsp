<%@ page import="MaximPackage.City" %>
<%@ page import="java.util.List" %>
<%@ page import="MaximPackage.Country" %>
<%@ page import="MaximPackage.Tag" %>
<%@ page import="MaximPackage.Servlet.MVC.DataSources.LoginDataSource" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Project Monaco</title>
</head>
<link href="<c:url value="/LoginPageCSS.css" />" rel="stylesheet">
<body>
<%
    LoginDataSource dataSource = (LoginDataSource)request.getAttribute("model");
    List<City> allCities = dataSource.getAllCities();
    List<Country> allCountries = dataSource.getAllCountries();
    List<Tag> allTags = dataSource.getAllTags();
%>
    <form id="loginForm" action="LoginPageServlet" method="POST">
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

    <form id="registrationForm" action="RegistrationActionJSP.jsp" method="POST">
        <div id="registerDiv">
            <input name="backUrl" value="<%= request.getRequestURI() %>" hidden>
            Name:<br>
            <input id="rName" type="text" name="rName">
            <br>
            Surname:<br>
            <input id="rSurname" type="text" name="rSurname">
            <br>
            Nickname:*<br>
            <input id="rNickName" type="text" name="rNickName">
            <br>
            Password:*<br>
            <input id="rPassword" type="text" name="rPassword">
            <br>
            Email:*<br>
            <input id="rEmail" type="text" name="rEmail">
            <br>
            Age:<br>
            <input id="rAge" type="number" name="rAge">
            <br>
            City:*
            <br>
                <select name="rCity">
                    <option value="">-- City--</option>
                    <%
                        int i = 0;
                        while(i < allCities.size()) {
                            City city = allCities.get(i);
                            String name = city.getCityName();
                            int cityID = city.getCityNameID();
                            i++;
                    %>
                        <option value="<%= cityID %>"><%=name%></option>
                    <% } %>

                </select>
            <br>
            Country:*<br>
            <select name="rCountry">
                <option value="">-- Country--</option>
                <%
                    int j = 0;
                    while(j < allCountries.size()) {
                        Country country = allCountries.get(j);
                        String countryName = country.getCountryName();
                        int countryID = country.getCountryNameID();
                        j++;
                %>
                    <option value="<%= countryID %>"><%= countryName %></option>
                <% } %>

            </select>
            <br>
            Tag:
            <br>
            <select name="rTag"><option value="">-- Tag --</option>
                <%
                    int k = 0;
                    while(k < allTags.size()) {
                        Tag tag = allTags.get(k);
                        String countryName = tag.getTagName();
                        int countryID = tag.getTagNameID();
                        k++;
                %>
                    <option value="<%= countryID %>"><%=countryName%></option>
                <% } %>

            </select>
            <br>
            <br>
            <button type="register" value="Register">Register</button>
        </div>
    </form>
</body>
</html>