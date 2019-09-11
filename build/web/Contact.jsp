<%-- 
    Document   : Contact
    Created on : 14-Aug-2019, 17:17:24
    Author     : Jacynta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Just Photography</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="styles/main.css">

    </head>
    <body>
        <h1 id="heading">Just Photography</h1>
        <nav id="nav_menu">
            <ul>
                <li><a href="Index.jsp">Home</a></li>
                <li><a href="Classes">Classes</a></li>
                <li><a href="Events">Events</a></li>
                <li><a href="Gallery.jsp">Gallery</a></li>
                <li><a href="Competitions">Competitions</a></li>
                <li><a href="About.jsp">About</a></li>
                    <%
                        Cookie cookie = null;
                        Cookie[] cookies = null;
                        boolean userLoggedIn = false;
                        boolean adminLoggedIn = false;
                        // Get an array of Cookies associated with the this domain
                        cookies = request.getCookies();

                        for (int i = 0; i < cookies.length; i++) {
                            cookie = cookies[i];
                            if (cookie.getName().equals("user")) {
                                userLoggedIn = true;
                            } else if (cookie.getName().equals("admin")) {
                                adminLoggedIn = true;
                            }
                        }
                        if (userLoggedIn) {
                    %> 
                <li><a href="userProfile.jsp">Profile</a></li><%} else if (adminLoggedIn) {%>
                <li><a href="Profile.jsp">Profile</a></li><%} else {%>
                <li><a href="login.html">Log In</a></li><%}
                %>
            </ul>
        </nav>
        <main id="about">
            <div class="container">

                <div class="row">
                    <div class="col-sm-12">
                        <div class="about_right_img">
                            <img src="images/classes.jpeg" height=200 width=200 alt="classes" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        
                            <div class="about_text">
                                <h2>Contact Us!</h2>
                                <p>Phone: (0504) 273535</p>
                                <p>Email: justphotography@gmail.com<p>
                                <p>If you have any questions we'd be happy to get back to you ASAP!</p>
                                
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="about_left_img">
                            <img src="images/gallery.jpeg" height=200 width=200 alt="gallery"/>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>