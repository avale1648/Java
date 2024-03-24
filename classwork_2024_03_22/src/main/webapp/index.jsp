<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.concurrent.ThreadLocalRandom, edu.avale1648.classwork_2024_03_22.Check"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Math Test</title>
</head>
<body>
	<%!
	long a = Check.getA();
		long b = Check.getB();
		String act = Check.getAction();
	%>
	<form action='check' method='post'>
		How many is <%=a%> <%=act %> <%=b%> = <input type='number' name='answer'>? <input
			type='submit' value='check'>
	</form>
</body>
</html>