package tw.jason.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Main")
public class Main extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			
			Connection conn =
				DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/iii",prop);
			String delid = request.getParameter("delid");
			if(delid != null) {
				conn.createStatement().executeUpdate(
						"DELETE FROM cust WHERE id = "+delid);
			}
			
			
			
			PreparedStatement pstmt = 
			 conn.prepareStatement(
				"SELECT * FROM cust");

			rs =  pstmt.executeQuery();
			
		} catch (Exception e) {
			System.out.println(e);
		}	
		
		out.println("<meta http-equiv='Content-type' content = 'text/html;charset =UTF-8'>");
		out.println("<a href ='AddAccount'>Add</a>");
		out.println("<hr>");
		out.println("<table border='1' width='100%'>");
		
		out.println("	<tr>\r\n" + 
				"		<th>ID</th>\r\n" + 
				"		<th>Name</th>\r\n" + 
				"		<th>Password</th>\r\n" + 
				"		<th>Delete</th>\n" + 
				"	\r\n" + 
				"	</tr>");
		try {
		if(rs !=null) {
			while(rs.next()) {
			String id = rs.getString("id");	
			String account = rs.getString("account");	
			out.println("<tr>");
			out.println("<td>"+id+"</td>");
			//out.println("<td>"+rs.getString("id")+"</td>");
			out.println("<td>"+rs.getString("account")+"</td>");
			out.println("<td>"+rs.getString("passwd")+"</td>");
			out.println("<td><a href='?delid="+id+
					"'onclick =' return confirm(\"Delete"
					+account +"?\");'>Delete</a></td>");
			out.println("</tr>");
			
			}
			
		}
		}catch(Exception e) {
			
		}
		
		
		
		out.println("</table>");
	
		
		
		
		
	}



}
