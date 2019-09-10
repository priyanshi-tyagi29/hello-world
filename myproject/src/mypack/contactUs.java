package mypack;


import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter; 
import java.sql.*;
 
@WebServlet("/contactUs")
public class contactUs extends HttpServlet { 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{ 
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try
		{ 
		String fname=request.getParameter("firstname");  
		String lname=request.getParameter("lastname");  
		String Country=request.getParameter("country"); 
		String Subject=request.getParameter("subject"); 
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Jobseeker?useSSL=false";
		String password="root";
		String username="root";
		Class.forName(driver);
		Connection com=DriverManager.getConnection(url,username,password);
		Statement s=com.createStatement();
		String query="insert into Contact values('"+fname+"','"+lname+"','"+Country+"','"+Subject+"')";
		int sql=s.executeUpdate(query);
			if(sql>0)
				{response.sendRedirect("feedback.html");
				return;
				}
				response.sendRedirect("error.html");
				return;
				
		}
		catch (Exception e) { 
			out.println(e);
		} 
		out.close();
	} 
}

