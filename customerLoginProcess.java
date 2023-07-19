

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


@WebServlet(urlPatterns = {"/customerLoginProcess"})
public class customerLoginProcess extends HttpServlet {

    
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
