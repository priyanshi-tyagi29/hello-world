package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/projectTask")
public class projectTask extends HttpServlet { 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{ 
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try
		{ 
		String ptitle=request.getParameter("title");  
		String subject=request.getParameter("subject");  
		String Category=request.getParameter("category"); 
		String date=request.getParameter("date"); 
		String location=request.getParameter("location"); 
		String budget=request.getParameter("budget"); 
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/JobProvider?useSSL=false";
		String password="root";
		String username="root";
		Class.forName(driver);
		Connection com=DriverManager.getConnection(url,username,password);
		Statement s=com.createStatement();
		String query="insert into project values('"+ptitle+"','"+subject+"','"+Category+"','"+date+"','"+location+"','"+budget+"')";
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

