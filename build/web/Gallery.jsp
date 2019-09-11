<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Just Photography</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="styles/main.css">
        <script>
	function swap(imgnum)
	{
	    if (imgnum == 1)
            {
                document.getElementById("gallery").src="images/gallery.jpeg";
                document.getElementById("caption").innerHTML = "Placeholder 1";
            }
            else if (imgnum == 2)
            {
                document.getElementById("gallery").src="images/gallery1.jpg";
                document.getElementById("caption").innerHTML = "Placeholder 2";
            }
            else if (imgnum == 3)
            {
                document.getElementById("gallery").src="images/gallery2.jpg";
                document.getElementById("caption").innerHTML = "Placeholder 3";
            }
            else if (imgnum == 4)
            {
                document.getElementById("gallery").src="images/gallery3.jpeg";
                document.getElementById("caption").innerHTML = "Placeholder 4";
            }
            else if (imgnum == 5)
            {
                document.getElementById("gallery").src="images/gallery5.jpeg";
                document.getElementById("caption").innerHTML = "Placeholder 5";
            }
            else if (imgnum == 6)
            {
                document.getElementById("gallery").src="images/gallery6.jpeg";
                document.getElementById("caption").innerHTML = "Placeholder 6";
            }
            else if (imgnum == 7)
            {
                document.getElementById("gallery").src="images/gallery7.jpeg";
                document.getElementById("caption").innerHTML = "Placeholder 7";
            }
            else if (imgnum == 8)
            {
                document.getElementById("gallery").src="images/gallery8.jpeg";
                document.getElementById("caption").innerHTML = "Placeholder 8";
            }
        }
        imgnum=1;
	function next()
	{
            if(imgnum == 8)
            {
		imgnum=1;
            }
            else
            {
                imgnum++;
            }
            swap(imgnum);
        }
		
	function previous()
	{
            if (imgnum==1)
            {
		imgnum=8;
            }
            else
            {
                imgnum--;
            }
            swap(imgnum);
	}
	</script>
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
        <main>
	    <h1>Photo Gallery</h1>
		
		<figure>
		    <img src="images/gallery.jpeg" alt="gallery" id="gallery">
                    <figcaption id="caption">Placeholder 1</figcaption>
                </figure>
		
            <p><a href="javascript:next();">Next</a> | <a href="javascript:swap(1);">Picture 1</a> | <a href="javascript:swap(2);">Picture 2</a> | <a href="javascript:swap(3);">Picture 3</a> | 
		<a href="javascript:swap(4);">Picture 4</a> | <a href="javascript:swap(5);">Picture 5</a> | <a href="javascript:swap(6);">Picture 6</a> | 
                <a href="javascript:swap(7);">Picture 7</a> | <a href="javascript:swap(8);">Picture 8</a> | <a href="javascript:previous();">Previous</a></p>	
	</main>
    </body>
</html>
