/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stephen
 */
@WebServlet(name = "Competitions", urlPatterns = {"/Competitions"})
public class Competitions extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Connection conn;
    Statement stmt;
    PreparedStatement prepStat;

    public void init() throws ServletException {

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

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
            String sql = "SELECT * FROM Competitions";
            stmt = (Statement) conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Just Photography</title>");
            out.println("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                    + "<link rel=\"stylesheet\" href=\"styles/main.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 id=\"heading\">Just Photography</h1>\n"
                    + "        <nav id=\"nav_menu\">\n"
                    + "            <ul>\n"
                    + "                <li><a href=\"Index.jsp\">Home</a></li>\n"
                    + "                <li><a href=\"Classes\">Classes</a></li>\n"
                    + "                <li><a href=\"Events\">Events</a></li>\n"
                    + "                <li><a href=\"Gallery.jsp\">Gallery</a></li>\n"
                    + "                <li><a href=\"Competitions\">Competitions</a></li>\n"
                    + "                <li><a href=\"About.jsp\">About</a></li>\n");

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
                out.println("<li><a href=\"userProfile.jsp\">Profile</a></li>");
            } else if (adminLoggedIn) {
                out.println("<li><a href=\"Profile.jsp\">Profile</a></li>");
            } else {
                out.println("<li><a href=\"login.html\">Log In</a></li>");
            }

            out.println("</ul>\n"
                    + "        </nav>");
            out.println("<main id=\"home\">");
            out.println("<div class=\"container\">");

            while (result.next() != false) {
                String name = result.getString("Name");
                String date = result.getString("Date");
                String winner = result.getString("Winner");
                String prize = result.getString("Prize");
                String desc = result.getString("Description");

                out.println("\n"
                        + "<div class=\"row\">\n"
                        + "<div class=\"col-sm-12\">\n"
                        + "<div class=\"item\">\n"
                        + "<img src=\"images/classes.jpeg\" height=200 width=200 alt=\"classes\" />\n"
                        + "<div class=\"item_text\">\n"
                        + "<h2>" + name + "</h2>\n"
                        + "<h3>Date: " + date + "     Prize: " + prize + "</h3>\n"
                        + "<p>" + desc + "</p>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "</div>");
            }
            out.println("</div>");
            out.println("</main>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
