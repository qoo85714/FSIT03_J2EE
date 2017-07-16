<%@tag import="java.util.*"%>
<%@ tag dynamic-attributes="product" %>
<%@ attribute name="user" required="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	HashMap<String,String> ps =
		(HashMap<String,String>)jspContext.getAttribute("product");
	if(ps.containsKey("name")){
		out.println(ps.get("name"));
	}
%>
<table border="1" width="100%">
  <tr>
    <th>items</th>
    <th>value</th>
  </tr>
 
</table>

