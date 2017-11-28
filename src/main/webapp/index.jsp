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
<%@ page import="com.asegroup52.aat.Group" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
</head>

<body>
<h1>Automated Attendance Tracking System</h1>
<%
    List<Group> groups = ObjectifyService.ofy().load().type(Group.class).list();
    if(groups.isEmpty()){
        groups = OrganizingService.loadDefaultGroups();
    }


    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
        pageContext.setAttribute("user", user);
%>


<p>Hello, ${fn:escapeXml(user.nickname)}!</p>
<p>(You can
    <a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">sign out</a>.)</p>
<%

        Student student = OrganizingService.getStudentFromUser(user);

        if(student.group == null){
%>
<h2>Please register to a group.</h2>
<ul>
<%
    pageContext.setAttribute("student", student.id);
            // Look at all of our greetings
            for (Group group : groups) {
                pageContext.setAttribute("group", group.name);

%>
<li>${fn:escapeXml(group)}
    <form action="/sign" method="post">
        <input type="submit" value="Register"/>
        <input type="hidden" name="group" value="${fn:escapeXml(group)}"/>
        <input type="hidden" name="student" value="${fn:escapeXml(student)}"/>
    </form>
</li>

<%
            }
%>
</ul>
<%
        }
        else{
            System.out.println("group "+student.group);
            Group group = ObjectifyService.ofy().load().key(student.group).now();
            pageContext.setAttribute("group", group.name);
%>
<p>You are enroled in group ${fn:escapeXml(group)}.</p>
<%

        }


    } else {
%>
<p>Welcome to the AAT!</p>
<p>Please <a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
    to register to groups and verify your attendance.</p>
<%
    }
%>

<%-- //[START datastore]--%>

</body>
</html>
<%-- //[END all]--%>
