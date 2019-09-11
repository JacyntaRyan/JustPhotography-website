/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Stephen
 */
@WebServlet(name = "EnterClasses", urlPatterns = {"/EnterClasses"})
public class EnterClasses extends HttpServlet {

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
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(URL + DB,USERNAME,PASSWORD);
        }
        catch(Exception e){
            System.err.println(e);
        }
       
 
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("class_name");
        String startDate = request.getParameter("start_date");
        String endDate = request.getParameter("end_date");
        String desc = request.getParameter("class_desc");
        String price = request.getParameter("price");
        String vID = request.getParameter("v_id");
        try
        {
            String sql = "INSERT INTO classes(Name, startDate, endDate, description, price, venueID) VALUES(?, ?, ?, ?, ?, ?)";
            prepStat = (PreparedStatement) conn.prepareStatement(sql);
            prepStat.setString(1, name);
            prepStat.setString(2, startDate);
            prepStat.setString(3, endDate);
            prepStat.setString(4, desc);
            prepStat.setString(5, price);
            prepStat.setString(6, vID);
            
            prepStat.executeUpdate();
            
            response.sendRedirect("Profile.jsp");
        }
        catch(Exception e)
        {
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
