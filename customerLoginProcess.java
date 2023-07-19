/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
@WebServlet(urlPatterns = {"/customerLoginProcess"})
public class customerLoginProcess extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("");//getting email and password in the form of strig from form
        String password = request.getParameter("");
        try ( PrintWriter out = response.getWriter()) {
            Class.forName("com.jdbc.mysql.Driver");//connecting Database
            Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/logdetails","root","");
           String Verification = "SELECT * FROM Customer";//getting data from Database
            PreparedStatement statement = con.prepareStatement(Verification);
            ResultSet rs = statement.executeQuery();
            int flag = 0;
            while(rs.next()){
                
           
            if (email.equals("") && password.equals("")) {
                flag = 1;
            } else {
                flag = 0;
            }
            }
            if(flag==1){
                RequestDispatcher rd = request.getRequestDispatcher("");
                
            }else{
                request.setAttribute("Error Message", "Email or Password is Incorrect");
                RequestDispatcher rd = request.getRequestDispatcher("");
                rd.include(request, response);
            }
            con.close();
        } catch (Exception e) {
            out.print(e);

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
