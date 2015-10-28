<%@ page import="MaximPackage.Database.UserDAOImplementation" %>
<%@ page import="MaximPackage.User" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
    String nickName = request.getParameter("rNickname");
    String password = request.getParameter("rPassword");
    String email = request.getParameter("rEmail");
    String city = request.getParameter("rCity");
    String country = request.getParameter("rCountry");

    UserDAOImplementation userDAO = new UserDAOImplementation();

    User user = new User(nickName, email, city, country, password);
    userDAO.createUser(user);
%>