package tw.jason.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jason27")
public class Jason27 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		Cookie cookieRemember = new Cookie("remember", "true");
		cookieRemember.setMaxAge(1*60);
		response.addCookie(cookieRemember);
		
		Cookie cookieAccount = new Cookie("account", "Brad");
		cookieAccount.setMaxAge(1*60);
		response.addCookie(cookieAccount);
		
		Cookie cookiePasswd = new Cookie("passwd", "1234567");
		cookiePasswd.setMaxAge(1*60);
		response.addCookie(cookiePasswd);
		
		
		
		
	}	

}
