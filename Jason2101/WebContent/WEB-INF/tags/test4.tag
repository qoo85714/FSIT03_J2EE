<%@ tag dynamic-attributes="product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	out.println("<h1>J B C</h1>");
%>

<table border="1" width="100%">
  <tr>
    <th>items</th>
    <th>value</th>
  </tr>
  <c:forEach var="prod" items="${product }">
    <tr>
   	 	<td>${prod.key }</td>
    	<td>${prod.value }</td>
  	</tr>
  
  
  </c:forEach>
</table>

