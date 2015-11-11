<%@page import="org.apache.jasper.tagplugins.jstl.*" %>
<%@page import="br.com.caelum.agenda.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,br.com.caelum.agenda.dao.*,br.com.caelum.agenda.modelo.*, java.sql.Connection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scriptlet porcão</title>
</head>
<body>

	<table>
		<%
		   // Busca a conexão pendurada na requisição, pela FiltroConexao
		    Connection connection = (Connection) request.getAttribute("conexao");
		
			ContatoDao dao = new ContatoDao(connection);
			List<Contato> contatos = dao.getLista();

			for (Contato contato : contatos) {
		%>

		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=contato.getDataNascimento().getTime()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>