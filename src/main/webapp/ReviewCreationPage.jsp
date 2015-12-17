<%--
  Created by IntelliJ IDEA.
  User: Nikolajs
  Date: 11/3/2015
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <title>Monaco Review Creaation page</title>
</head>
<body>

<!DOCTYPE html>
<html>
<head>
  <style>
    #header {
      background-color:black;
      color:white;
      text-align:center;
      padding:5px;
    }
    #nav {
      line-height:30px;
      background-color:#eeeeee;
      height:300px;
      width:100px;
      float:left;
      padding:5px;
    }
    #section {
      width:350px;
      float:left;
      padding:10px;
    }
    #footer {
      background-color:black;
      color:white;
      clear:both;
      text-align:center;
      padding:5px;
    }
  </style>
</head>
<body>

<h1><%= request.getAttribute("model") %></h1>

<div id="header">
  <h1>Create Review</h1>
</div>

<div id="nav">
  xxxxxx<br>
  xxxxxx<br>
  xxxxxx<br>
</div>

<div id="section">
  <h2>Route name - xxxxx </h2>
  <p>Type in Review text below</p>
  <form action="xxxxxxxxxxxxxx.jsp" method="post">
    Creator ID:<br>
    <input type="text" name="creatorID">
    <br>
    Title:<br>
    <input type="text" name="title" size="40">
    <br>
    Route ID:<br>
    <input type="text" name="routeID">
    <br>
    Image URL:<br>
    <input type="text" name="imageURL" size="60">
    <br><br>
  <textarea name="body" rows="10" cols="30">
  </textarea>
    <br><br>
    <input type="submit" value="Save Review">
    <input type="reset" value="Clear form">
  </form>

</div>

<div id="footer">
  Copyright © monacoAPP
</div>

</body>
</html>

<a href="<%= request.getRequestURI() %>"><h3>Refresh page</h3></a>

</body>
</html>
