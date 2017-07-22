package tw.jason.j2ee;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name ="Jason40",
	urlPatterns= {"/Jason40","/Jason40.php","/Jason40.aspx"},
	initParams= {
		@WebInitParam(name="x",value="123"),
		@WebInitParam(name="y",value="456")
	}
)
public class Jason40 extends HttpServlet {
	private ServletConfig servletConfig;
	private ServletContext servletContext; 
	
	@Override
	public void init() throws ServletException {
		super.init();
		//System.out.println("init");
		
		servletConfig =getServletConfig();
		servletContext=getServletContext();	
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		super.service(req, resp);
		//System.out.println("service");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doGet");
		Enumeration<String> params = servletConfig.getInitParameterNames();
		while(params.hasMoreElements()) {
			String param = params.nextElement();
			System.out.println(param+ " = " +servletConfig.getInitParameter(param));
			
		}
		String realPath = servletContext.getRealPath("/");
		System.out.println(realPath);
		Set<String> paths = servletContext.getResourcePaths("/");
		for(String path:paths) {
			System.out.println(path);
		}
	}



}
