package mypack;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter; 
import java.sql.*;
 
@WebServlet("/profileEdit")
public class profileEdit extends HttpServlet { 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{ 
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try
		{ 
		String Email=request.getParameter("Email");  
		String Name=request.getParameter("Name");  
		String Address=request.getParameter("Address"); 
		String Phone=request.getParameter("Phone"); 
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Jobseeker?useSSL=false";
		String password="root";
		String username="root";
		Class.forName(driver);
		Connection com=DriverManager.getConnection(url,username,password);
		Statement s=com.createStatement();
		String query="insert into Profile values('"+Email+"','"+Name+"','"+Address+"','"+Phone+"')";
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

