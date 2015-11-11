<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<!DOCTYPE html>
<html>
<head>
   <link href="css/jquery.css" rel="stylesheet">
   <script type="text/javascript" src="js/jquery.js"></script>
   <script type="text/javascript" src="js/jquery-ui.js"></script>
<meta charset="UTF-8">
<title>Alterar contatos</title>
</head>
<body>
    <c:import url="cabecalho.jsp"/>

	<h1>Alterar contatos</h1>

	<form action="mvc" method="post">
       <input type="hidden" name="id" value="${contato.id}"/>
       
		Nome: <input type="text" name="nome" value="${contato.nome}"/> <br/> 
		E-mail: <input type="text" name="email" value="${contato.email}"/> <br/> 
		Endereço: <input type="text" name="endereco" value="${contato.endereco}"/> <br/> 
		Data de Nascimento: <caelum:campoData id="dataNascimento" value="${contato.dataNascimento.time}"></caelum:campoData> <br/> 
		
	    <!-- <input type="hidden" value="AlterarContatoLogic">  -->
	    <input type="submit" value="Alterar Contato">
	</form>
	
	<c:import url="rodape.jsp"/>

</body>
</html>