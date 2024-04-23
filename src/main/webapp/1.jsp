<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeira página JSP</title>
</head>
<body>
<p>Página JSP</p>
<%
String msg = "teste";

out.println(msg);
%>
<%=msg %>
<%
System.out.println("saída para console");
%>
</body>
</html>