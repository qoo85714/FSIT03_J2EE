package tw.jason.j2ee;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

//@WebListener

public class MyRequestAttibuteListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		String name = event.getName();
		String value = (String)event.getValue();
		System.out.println("request attribute add: " + name + " -> " + value);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		String name = event.getName();
		String value = (String)event.getValue();
		System.out.println("request attribute remove: " + name + " -> " + value);
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		String name = event.getName();
		System.out.println("request replace attribute: " + name);
		
		if (name.equals("x")) {
			String value = (String)event.getValue();
			System.out.println("request attribute replace before: " + name + " -> " + value);
			
			ServletRequest req = event.getServletRequest();
			String v2 = (String)req.getAttribute(name);
			System.out.println("request attribute replace after: " + name + " -> " + v2);
		}
	}

}