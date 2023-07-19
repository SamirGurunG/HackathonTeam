
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
public class customerRegisterProcess extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //Reciving all the datas send by ownerRegisterPage to store in database
            String cFname = request.getParameter("cFname");
            String cLname = request.getParameter("cLname");
            String cPhoneNumber = request.getParameter("cPhoneNumber");
            String cEmail = request.getParameter("cEmail");
            String cCity = request.getParameter("cCity");
            String cState = request.getParameter("cState");
            String cPass = request.getParameter("cPass");
            String confirmPass = request.getParameter("confirmPass");
            if (confirmPass.equals(cPass)) {
                //Store all the received information to database table owner
                try {
                    Class.forName("com.jdbc.mysql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/logdetails", "root", "");
                    String loginVerifySql = "INSERT INTO owner "
                            + "(cFname,cLname,cPhoneNumber,cEmail,cCity,cState,cPass) "
                            + "VALUES(?,?,?,?,?,?,?);";
                    PreparedStatement stm = con.prepareStatement(loginVerifySql);
                    stm.setString(1, cFname);
                    stm.setString(2, cLname);
                    stm.setString(3, cPhoneNumber);
                    stm.setString(4, cEmail);
                    stm.setString(5, cCity);
                    stm.setString(6, cState);
                    stm.setString(7, cPass);
                    stm.executeUpdate();
                    request.setAttribute("successMessage", "Register Successfully!!!");//included success message
                    RequestDispatcher rd = request.getRequestDispatcher("customerLoginPage.jsp");//redirected back to login page
                    rd.include(request, response);//including success message
                    con.close();
                } catch (Exception e) {
                    request.setAttribute("errorMessage", "Exception caught:" + e.getMessage());//included error message
                    RequestDispatcher rd = request.getRequestDispatcher("customerLoginPage.jsp");//redirected back to login page
                    rd.include(request, response);//including error message
                }
            } else {
                request.setAttribute("errorMessage", "Password didn't match with each other");//included error message
                RequestDispatcher rd = request.getRequestDispatcher("customerLoginPage.jsp");//redirected back to login page
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
