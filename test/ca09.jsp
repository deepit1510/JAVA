import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ca5
 */
@WebServlet("/ca9")
public class ca9 extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ca9() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
String n = request.getParameter("name");
String un = request.getParameter("USERNAME");
String pa = request.getParameter("password");
String ad = request.getParameter("address");
String ag = request.getParameter("age");
String qu = request.getParameter("qualification");
String pe = request.getParameter("percentage");
String yr = request.getParameter("year");
try {
// loading drivers for mysql

Class.forName("com.mysql.jdbc.Drivers");
//creating connection with the database
Connection con =DriverManager.getConnection("jdbc:mysql://localhost/ca8studentregistration","root"," ");
Statement st = con.createStatement();
st.executeUpdate("insert into ca8studentregistration(name, username, password, address, age,qualification, percentage, year)values('"+n+"','"+un+"','"+pa+"','"+ad+"','"+ag+"','"+qu+"','"+pe+"','"+yr+"')");
out.println("You are sucessfully registered");
doGet(request, response);
}
catch(Exception e)
{
out.println(e);
}
}
}