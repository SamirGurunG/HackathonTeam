/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aayus
 */
@WebServlet(urlPatterns = {"/ownerRegisterProcess"})
public class ownerRegisterProcess extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //Reciving all the datas send by ownerRegisterPage to store in database
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            String companyName = request.getParameter("companyName");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String pan = request.getParameter("pan");
            String pass = request.getParameter("fname");
            //Store all the received information to database table owner
            try {
                Class.forName("com.jdbc.mysql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/logdetails", "root", "");
                String loginVerifySql = "INSERT INTO owner "
                        + "(fname,lname,phoneNumber,email,companyName,street,city,state,pan,pass) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement stm = con.prepareStatement(loginVerifySql);
                stm.setString(1, fname);
                stm.setString(2, lname);
                stm.setString(3, phoneNumber);
                stm.setString(4, email);
                stm.setString(5, companyName);
                stm.setString(6, street);
                stm.setString(7, city);
                stm.setString(8, state);
                stm.setString(9, pan);
                stm.setString(10, pass);
                stm.executeUpdate();
                request.setAttribute("successMessage", "Register Successfully!!!");//included success message
                RequestDispatcher rd = request.getRequestDispatcher("ownerLoginPage.jsp");//redirected back to login page
                rd.include(request, response);//including success message
                con.close();
            } catch (Exception e) {
                request.setAttribute("errorMessage", "Exception caught:" + e.getMessage());//included error message
                RequestDispatcher rd = request.getRequestDispatcher("ownerLoginPage.jsp");//redirected back to login page
                rd.include(request, response);//including error message
            }
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
