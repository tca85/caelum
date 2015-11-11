<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Taglibs e JSTL!</title>
</head>
<body>

	<!-- Cria o DAO e percorre ca lista de contatos montando as linhas da tabela 
		 obs: vai pegar o resultado do método getter que retorna uma lista
		 ContatoDao.getLista()
		 quando faz isso, deve chamar sem o get na frente do nome ou seja, ${dao.lista} -->
		 
	<c:import url="cabecalho.jsp"/>

	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Endereço</th>
				<th>Data Nascimento</th>
			</tr>
		</thead>
		<tbody>
		    	<c:forEach var="contato" items="${contatos}">
				<tr>
					<td>${contato.nome}</td>
					<td>
					   <c:choose>
						 <c:when test="${not empty contato.email}">
						    <a href="mailto: ${contato.email}">${contato.email}</a>
						 </c:when>
						
						 <c:when test="${empty contato.email}">
						    E-mail não informado
						 </c:when>
						
						 <c:otherwise>Erro genérico</c:otherwise>
					   </c:choose>
					</td>

					<td>${contato.endereco}</td>
					<td>
					    ${contato.dataNascimento.time}
					</td>
					<td>
					    <a href="mvc?logica=RemoverContatoLogic&id=${contato.id}">Remover</a>
					</td>
					<td>
					    <a href="mvc?logica=SelecionarContatoLogic&id=${contato.id}">Alterar</a>
					</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
    <c:import url="rodape.jsp"/>
</body>
</html>