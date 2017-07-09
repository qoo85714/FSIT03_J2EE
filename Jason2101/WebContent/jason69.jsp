<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="member" class="tw.jason.beans.Member"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 	pageContext.setAttribute("x", "123");
%>
<c:out value="${'Hello,World' }"/><br>
<c:out value="${x }" default="no value"/><br>
<c:set var="var1" value="123" scope="page" />
${var1}<br>
<c:set var="var2">
<% out.println("OK");
%>
</c:set>
${var2}<br>
<c:set target="${member }" property="id">
009
</c:set>
<c:set target="${member }" property="name">
John
</c:set>
${member }<br>
<c:remove var="var1"/>
<c:out value="${var1 }" default="no value"/><br>



</body>
</html>