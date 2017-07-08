package tw.jason.j2ee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Jason30")
public class Jason30 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = 
			request.getSession();//if it does not exsist ,create a new one
//		HttpSession session=
//			request.getSession(true);
//		HttpSession session=
//		request.getSession(false);
		Member member = new Member("brad", 51);
		session.setAttribute("who", member);
		
		
	}



}
