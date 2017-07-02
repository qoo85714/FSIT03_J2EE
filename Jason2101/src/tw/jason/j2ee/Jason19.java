package tw.jason.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Controller
@WebServlet("/Jason19")
public class Jason19 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//prepare
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		if (x ==null ) x="0";
		if (y ==null ) y="0";
		
		//model
		Jason20 model = new Jason20(x,y);
		int result = model.add();
		
		// forward -> view
		request.setAttribute("x", x);
		request.setAttribute("y", y);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("Jason21").forward(request, response);
			
		
	}

}
