<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="edu.avale1648.classwork_2024_03_22.pgsql.*"%>
<%@page import="edu.avale1648.classwork_2024_03_22.pgsql.entities.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Math Test</title>
</head>
<body>
	<%
		Question q = new Question();
		StoreData store = new StoreData();
		store.saveQuestion(q);
	%>
	<form action='check' method='post'>
	<input type='hidden' name='questionId' value='<%=q.getId()%>'>
		<%=q.getContent()%>
		<input type='number' name='answer'> 
		<input type='submit' value='check'>
	</form>
</body>
</html>