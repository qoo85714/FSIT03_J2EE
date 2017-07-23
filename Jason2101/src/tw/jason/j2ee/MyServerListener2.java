package tw.jason.j2ee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServerListener2 implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext servletContext = event.getServletContext(); 
		
		List<AsyncContext> asyncs = new LinkedList<>();
		servletContext.setAttribute("asyncs", asyncs);
		
		MyAsyncListener myAsyncListener = new MyAsyncListener(); 
		
	
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
		
	}



