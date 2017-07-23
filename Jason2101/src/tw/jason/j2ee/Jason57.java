package tw.jason.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/Jason57",asyncSupported=true)
public class Jason57 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext =  getServletContext();
		List<AsyncContext> asyncs =(List)servletContext.getAttribute("asyncs");
		MyAsyncListener  asyncListener =
				(MyAsyncListener )servletContext.getAttribute("asyncListener");
		
		synchronized (asyncs) {
			AsyncContext async = request.startAsync();
			async.addListener(asyncListener);
			async.setTimeout(900000000);
			asyncs.add(async);
		}
		
		
	}

}
