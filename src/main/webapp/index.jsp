<%-- //[START all]--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%-- //[START imports]--%>

<%-- //[END imports]--%>

<%@ page import="java.util.List" %>
<%@ page import="com.asegroup52.aat.model.Student" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.asegroup52.aat.OrganizingService" %>
<%@ page import="com.asegroup52.aat.model.Group" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
</head>

<body>
<h1>Automated Attendance Tracking System</h1>
<%
    Cookie[] cookies = request.getCookies();
    System.out.println(cookies.length);
    boolean isAuthenticated = false;
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("token") && cookie.getValue() != null) {
            isAuthenticated = true;
            break;
        }
    }
    if (!isAuthenticated) {
%>
        <form action="/register" method="post">
            <input type="submit" value="Register"/>
            <input type="hidden" name="email" value="asd@asd.com"/>
            <input type="hidden" name="password" value="123456"/>
        </form>
<%
    } else {
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " " + cookie.getValue());
        }
    }
%>

</body>
</html>
<%-- //[END all]--%>
