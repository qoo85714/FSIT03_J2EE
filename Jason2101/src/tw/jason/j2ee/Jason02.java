package tw.jason.j2ee;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Jason02
 */
@WebServlet("/Jason02")
public class Jason02 extends HttpServlet {

	protected void doGet(HttpServletRequest request, 
		HttpServletResponse response) 
				throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			Enumeration<String> headers = request.getHeaderNames();
			
			
			
			while(headers.hasMoreElements()) {
				String header = headers.nextElement();
				String value = request.getHeader(header);
				System.out.println(header+":"+value);
			}
	
	
	}



}
