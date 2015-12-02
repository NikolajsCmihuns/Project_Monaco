<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="MaximPackage.Entities.City" %>
<%@ page import="MaximPackage.Entities.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="com.monaco.DataSources.RegistrationPageDS" %>
<%@ page import="com.monaco.Entities.Tag" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

  <title> Monaco registration </title>

  <%
    RegistrationPageDS dataSource = (RegistrationPageDS)request.getAttribute("model");
    List<City> allCities = dataSource.getCities();
    List<Country> allCountries = dataSource.getCountries();
    List<Tag> allTags = dataSource.getTags();
  %>

  <form id="registrationForm" action="register" method="POST">
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
        <option value="">-- City --</option>
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
        <option value="">-- Country --</option>
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

</head>
<body>

</body>
</html>
