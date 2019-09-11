<%-- 
    Document   : Profile
    Created on : 08-Apr-2019, 19:07:00
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
  <body>
        <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost/justphotography"
                           user = "root"  password = ""/>
        <%
            Cookie cookie = null;
            Cookie[] cookies = null;
            // Get an array of Cookies associated with the this domain
            cookies = request.getCookies();
            String userCookie = "";
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equals("username")) {
                        userCookie = cookie.getValue();
                    }
                }
            } else {
                out.println("<h2>No cookies founds</h2>");
            }
        
            Connection conn;
            Statement stmt;
            PreparedStatement prepStat;

            String URL = "jdbc:mysql://localhost:3306/";
            String DB = "justphotography";
            String USERNAME = "root";
            String PASSWORD = "";
            conn = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection(URL + DB, USERNAME, PASSWORD);
            } catch (Exception e) {
                System.err.println(e);
            }
            stmt = (Statement) conn.createStatement();
            String sql;
            
            sql = "SELECT * from users WHERE username = ?";
            prepStat = (PreparedStatement) conn.prepareStatement(sql);
            prepStat.setString(1, userCookie);
            ResultSet rs = prepStat.executeQuery();
            String username = new String();
            out.println(userCookie);


        %>

        <h1 id="heading">Just Photography</h1>
        <nav id="nav_menu">
            <ul>
                 <li><a href="Index.jsp">Home</a></li>
                <li><a href="Classes">Classes</a></li>
                <li><a href="Events">Events</a></li>
                <li><a href="Gallery.jsp">Gallery</a></li>
                <li><a href="Competitions">Competitions</a></li>
                <li><a href="About.jsp">About</a></li>  
                <li><a href="userProfile.jsp">Profile</a></li>
                
            </ul>
        </nav>
        <main id="profile">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-5">
                                <div class="profile">
                                    <img src="images//profile_default.png" /><br><br>
                                    <% while(rs.next()){ %>
                                    <h3><%= rs.getString("First_Name") %> <%= rs.getString("Last_Name") %></h3><br>
                                    <h3>Username: <%= rs.getString("username") %></h3><br>
                                    <h3>Email: <%= rs.getString("email") %></h3><br>
                                    <% } %>
                                </div>
                            </div>
                            <div class="col-sm-7">
                                <div class="profile">                                   
                                    <h3><a href="Competitions">view competitions</a></h3><br><br><br<br>
                                     <form action = "logout" method="POST" id="form">
                                        
                                            <input id="logout_button" type="submit" value="Log Out" name="log out">
                                            </form>
                                </div>

                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
