

<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.vemprafam.pojo.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="br.com.vemprafam.dao.DaoFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabela de Funcionários</title>
</head>
<body>
<%
DaoFuncionario dao = new DaoFuncionario();
List<Funcionario> lista = dao.getLista();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
%>
<table border='1'>
<tr>
	<th>RE</th>
	<th>nome</th>
	<th>data de admissão</th>
	<th>salário</th>
</tr>
<%
for( Funcionario f: lista ) {
	String dataf = dateFormat.format(f.getDataAdmissao());
	String salarioF = numberFormat.format(f.getSalario());
%>
<tr>
	<td><%= f.getRe() %></td>
	<td><%= f.getNome() %></td>
	<td><%= dataf %></td>
	<td><%= salarioF %></td>
</tr>

<%
}
%>

</table>

<a href='/Projeto'>voltar</a>
</body>
</html>