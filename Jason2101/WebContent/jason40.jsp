<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Jason Big Company</h1>
<%
	int a =10,b=3;
	int lottery =(int)(Math.random()*49+1);
	//out.write(lottery);
	
	
%>
<%= lottery %><br/>
<%= Calendar.getInstance().get(Calendar.YEAR) %>

</body>
</html>