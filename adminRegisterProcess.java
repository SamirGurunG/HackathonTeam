
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ownerRegisterProcess"})
public class adminRegisterProcess extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //Reciving all the datas send by ownerRegisterPage to store in database
            String eFname = request.getParameter("eFname");
            String eLname = request.getParameter("eLname");
            String ePhoneNumber = request.getParameter("ePhoneNumber");
            String eEmail = request.getParameter("eEmail");
            String ePass = request.getParameter("ePass");
            //Store all the received information to database table owner
            try {
                Class.forName("com.jdbc.mysql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/logdetails", "root", "");
                String loginVerifySql = "INSERT INTO owner "
                        + "(eFname,eLname,ePhoneNumber,eEmail,ePass) "
                        + "VALUES(?,?,?,?,?,?,?);";
                PreparedStatement stm = con.prepareStatement(loginVerifySql);
                stm.setString(1, eFname);
                stm.setString(2, eLname);
                stm.setString(3, ePhoneNumber);
                stm.setString(4, eEmail);
                stm.setString(5, ePass);
                stm.executeUpdate();
                request.setAttribute("successMessage", "Register Successfully!!!");//included success message
                RequestDispatcher rd = request.getRequestDispatcher("adminLoginPage.jsp");//redirected back to login page
                rd.include(request, response);//including success message
                con.close();
            } catch (Exception e) {
                request.setAttribute("errorMessage", "Exception caught:" + e.getMessage());//included error message
                RequestDispatcher rd = request.getRequestDispatcher("adminLoginPage.jsp");//redirected back to login page
                rd.include(request, response);//including error message
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}