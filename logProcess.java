//This code compares the user input with database data to verify the user
//For processing owners details
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = {"/logProcess"})
public class logProcess extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //Receving data from requested webpage to compare with database information
            String email = request.getParameter("mail");
            String ePass = request.getParameter("pass");
            try {
                Class.forName("com.jdbc.mysql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/logdetails", "root", "");
                String loginVerifySql = "SELECT * FROM owner;";
                PreparedStatement stm = con.prepareStatement(loginVerifySql);
                ResultSet rs = stm.executeQuery();
                int flag = 0;
                while (rs.next()) {
                    if (email.equals(rs.getString("email")) && ePass.equals(rs.getString("pass"))) {
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                }
                if(flag==1){
                    out.write("Sucess");
                }
                else{
                    out.write("failed");
                }
            } catch (ClassNotFoundException | SQLException e) {
                out.write("Exception caught:"+e.getMessage());
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
