package mypack;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter; 
import java.sql.*;
 
@WebServlet("/ProviderSignup")
public class ProviderSignup extends HttpServlet { 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{ 
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try
		{ 
		String n=request.getParameter("Email");  
		String p=request.getParameter("Password");  
		String e=request.getParameter("Repeat_Password"); 
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/JobProvider?useSSL=false";
		String password="root";
		String username="root";
		Class.forName(driver);
		Connection com=DriverManager.getConnection(url,username,password);
		Statement s=com.createStatement();
		String query="insert into JP_Signup values('"+n+"','"+p+"','"+e+"')";
		int sql=s.executeUpdate(query);
			if(sql>0)
				{response.sendRedirect("LoginProvider.html");
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

