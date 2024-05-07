<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração</title>
</head>
<body>

<form action="Controller">
RA:<input type='text' name='ra' value='${ra}'/><br/>
nome:<input type='text' name='nome' value='${nome}'/><br/>
data de nascimento:<input type='text' name='dataNascimento'
                                             value='${dataNascimento}'/><br/>
renda:<input type='text' name='renda' value='${renda}'/><br/>
<input type='hidden' name='op' value='Alteracao'/>
<input type='submit' value='enviar'/>
</form>
<a href='/Projeto'>voltar</a>
</body>
</html>