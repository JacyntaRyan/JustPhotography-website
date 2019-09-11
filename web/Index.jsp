<%-- 
    Document   : Index
    Created on : 14-Aug-2019, 15:23:15
    Author     : Jacynta

<%@include file = "includes/header.jsp"%> (create nav menu in this file)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<!--Stephen & Jacynta -->
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
        <main id="home">
            <div class="container">

                <div class="row">
                    <div class="col-sm-12">
                        <div class="item">
                            <img src="images/classes.jpeg" height=200 width=200 alt="classes" />
                            <div class="item_text">
                                <h2>Classes</h2>
                                <h3>Click the link below to find a list of exciting photography classes</h3>
                                <a href ="Classes ">Classes >>>></a>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="item">
                            <img src="images/event3.jpg" height=200 width=200 alt="event" />
                            <div class="item_text">
                                <h2>Events</h2>
                                <h3>Click the link below to find a list of exciting upcoming Events</h3>
                                <a href ="Events ">Events >>>></a>

                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="item">
                            <img src="images/gallery.jpeg" height=200 width=200 alt="gallery"/>
                            <div class="item_text">
                                <h2>Gallery</h2>
                                <h3>Click the link below to view some of our clubs amazing Photography</h3>
                                <a href ="Gallery.html ">Gallery >>>></a>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="item">
                            <img src="images/competition.jpg" height=200 width=200 alt="competitions" />
                            <div class="item_text">
                                <h2>Competitions</h2>
                                <h3>Want to show off your talent?Click the link to see our list of competitions</h3>
                                <a href ="Competitions ">Competitions >>>></a>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="item">
                            <img src="images/about.jpeg" height=200 width=200 alt="about us"/>
                            <div class="item_text">
                                <h2>About Us!</h2>
                                <h3>To find out more about this club click the link below.</h3>
                                <a href ="AboutUs.html ">About Us >>>></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer>
            
            </footer>
        </main>
    </body>
</html>