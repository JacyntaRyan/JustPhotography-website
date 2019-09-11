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
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author k00231373
 */
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String username;
    String firstName;
    String lastName;
    String phone;
    String address;
    String email;
    String password;
    String confirmPassword;

    Connection conn;
    PreparedStatement prepStat;
    Statement stat;

    @Override
    public void init() throws ServletException {
        String URL = "jdbc:mysql://localhost:3306/";
        String DB = "justphotography";
        String USERNAME = "root";
        String PASSWORD = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(URL + DB, USERNAME, PASSWORD);
            stat = (Statement) conn.createStatement();
            stat.execute("CREATE TABLE IF NOT EXISTS Users (username VARCHAR(40),first_name VARCHAR (40), last_name VARCHAR(40),phone INT(10),address VARCHAR(255),email Varchar(40), password VARCHAR(40),confirm-password VARCHAR(40,User_Type ENUM ('admin', 'user') default 'user' ");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        username = request.getParameter("user_name");
        firstName = request.getParameter("first_name");
        lastName = request.getParameter("last_name");
        phone = request.getParameter("phone");
        email = request.getParameter("email");
        password = request.getParameter("password");
        confirmPassword = request.getParameter("confirm_password");
        address = request.getParameter("address");
        try {
            String query = "INSERT INTO Users (username,First_Name,Last_Name,Phone,Address,Email,password,Confirm_Password) VALUES (?,?,?,?,?,?,?,?)";
            prepStat = (PreparedStatement) conn.prepareStatement(query);
            prepStat.setString(1, username);
            prepStat.setString(2, firstName);
            prepStat.setString(3, lastName);
            prepStat.setString(4, phone);
            prepStat.setString(5, address);
            prepStat.setString(6, email);
            prepStat.setString(7, password);
            prepStat.setString(8, confirmPassword);
            prepStat.executeUpdate();
            response.sendRedirect("login.html");
        } catch (Exception e) {
            System.err.println(e);
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
