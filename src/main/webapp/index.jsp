<%-- //[START all]--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%-- //[START imports]--%>

<%-- //[END imports]--%>

<%@ page import="java.util.List" %>
<%@ page import="com.asegroup52.aat.Student" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.asegroup52.aat.OrganizingService" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
</head>

<body>
<h1>Automated Attendance Tracking System</h1>
<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
        pageContext.setAttribute("user", user);

        Student student = OrganizingService.getStudentFromUser(user);

        if(student.group == null){
            
        }
        else{
            System.out.println("group "+student.group);
        }

%>


<p>Hello, ${fn:escapeXml(user.nickname)}!</p>
<p>(You can
    <a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">sign out</a>.)</p>
<%
    } else {
%>
<p>Welcome to the AAT!</p>
<p><a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
    to register to groups and verify your attendance.</p>
<%
    }
%>

<%-- //[START datastore]--%>

</body>
</html>
<%-- //[END all]--%>
