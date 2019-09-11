/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author k00231373
 */
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

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
         //set the response content type

        //PreparedStatement selectSQL = null;
        try {
            /* Execute SQL query */
            stmt = (Statement) conn.createStatement();
            String sql;
            String username = request.getParameter("user_name");
            String password = request.getParameter("password");
            boolean found = false;
            sql = "SELECT username, password FROM users WHERE username = ? AND password = ?";
            prepStat = (PreparedStatement) conn.prepareStatement(sql);
            prepStat.setString(1, username);
            prepStat.setString(2, password);

            ResultSet rs = prepStat.executeQuery();

            //Extract data from result set
            while (rs.next()) {
                found = true;
            }
            if (found == true) {
                sql = "SELECT User_Type, username, First_Name, Last_Name, Email FROM users WHERE username = ? AND password = ?";
                prepStat = (PreparedStatement) conn.prepareStatement(sql);
                prepStat.setString(1, username);
                prepStat.setString(2, password);
                ResultSet result = prepStat.executeQuery();
                String userType = "";
                
                while (result.next()) {
                    userType = result.getString(1);
                  
                }
                if (userType.equals("admin")) {
                    Cookie user = new Cookie("admin", username);
                    user.setMaxAge(60 * 60 * 24);
                    // Add both the cookies in the response header.
                    response.addCookie(user);
                   response.sendRedirect("Profile.jsp");
                } else {
                    Cookie user = new Cookie("user", username);
                    user.setMaxAge(60 * 60 * 24);
                    // Add both the cookies in the response header.
                    response.addCookie(user);
                    response.sendRedirect("userProfile.jsp");
                }

            } else {
                out.println("alert('log in failed')");
                response.sendRedirect("login.html");
            }

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String title = "404 ERROR";
            String docType = "<!doctype html>";
            out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
                    + "<h1 align=\"center\">" + title + "</h1>\n");
            out.println("<br><br><br><a href=\"index.html\">HOME</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }//end Try

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
