<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janis
  Date: 12/22/15
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>New Place</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Place input form</h2>
  <form role="form" action="/java2/place/form/rezult">
    <div class="form-group">
      <label for="placeName">Place name:</label>
      <input type="text" class="form-control" id="placeName" name="placeName" placeholder="Place name">
    </div>
    <div class="form-group">
      <label for="latitude">Latitude:</label>
      <input type="text" class="form-control" id="latitude" name="latitude" placeholder="Latitude">
    </div>
    <div class="form-group">
      <label for="longitude">Longitude:</label>
      <input type="text" class="form-control" id="longitude" name="longitude" placeholder="Longitude">
    </div>
    <div class="checkbox">
      <div class="form-group">
        <label for="address">Address:</label>
        <input type="text" class="form-control" id="address" name="address" placeholder="Address">
      </div>
      <div class="form-group">
        <label for="imageURL">ImageURL:</label>
        <input type="text" class="form-control" id="imageURL" name="imageURL" placeholder="URL">
      </div>
      <div class="form-group">
        <label for="placeTypeId">PlaceTypeId:</label>
        <select datatype="text" id="placeTypeId" name="placeTypeId">
          <c:forEach items="${model}" var="type">
            <option value="${type}">${type}</option>
          </c:forEach>
        </select>
      </div>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>
