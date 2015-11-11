<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<!DOCTYPE html>
<html>
<head>
   <link href="css/jquery.css" rel="stylesheet">
   <script type="text/javascript" src="js/jquery.js"></script>
   <script type="text/javascript" src="js/jquery-ui.js"></script>
<meta charset="UTF-8">
<title>Adiciona contatos</title>
</head>
<body>
    <c:import url="cabecalho.jsp"/>

	<h1>Adiciona contatos</h1>

	<form action="adicionaContato" method="post">

		Nome: <input type="text" name="nome" /> <br/> 
		E-mail: <input type="text" name="email" /> <br/> 
		Endereço: <input type="text" name="endereco" /> <br/> 
		Data de Nascimento: <caelum:campoData id="dataNascimento"></caelum:campoData> <br/> 
		
		<caelum:hello message="oi!"></caelum:hello>
		
	    <input type="submit" value="Gravar">
	</form>
	
	<c:import url="rodape.jsp"/>

</body>
</html>