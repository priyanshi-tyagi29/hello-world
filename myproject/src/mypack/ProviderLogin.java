package mypack;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;

@WebServlet("/ProviderLogin")
public class ProviderLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{ 
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try
		{ 
		String un=request.getParameter("Email");  
		String pw=request.getParameter("Password");  
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/JobProvider?useSSL=false";
		String password="root";
		String username="root";
		Class.forName(driver);
		Connection com=DriverManager.getConnection(url,username,password);
		String query="select Email, Password from JP_Signup where Email='"+un+"' and Password='"+pw+"'";
		Statement s=com.createStatement();
		ResultSet rs=s.executeQuery(query);
		while(rs.next()) {
			response.sendRedirect("SuccessProvider.html");
			return;
		}
		response.sendRedirect("errorProvider.html");
		return;
		}catch (Exception e) { 
			out.println(e);
		} 
		out.close();
	} 
}


