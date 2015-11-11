<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.js"> </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tarefas (JSTL)</title>
</head>
<body>
  <a href="novaTarefa">Cria nova tarefa</a>
  
  <table>
    <tr>
      <th>Id</th>
      <th>Descrição</th>
      <th>Finalização</th>
      <th>Data de finalização</th>
      <th>Remover</th>
      <th>Excluir</th>
      <th>Alterar</th>
    </tr>
    
    <c:forEach items="${tarefas}" var="tarefa">
      <tr>
        <td>${tarefa.id}</td>
        <td>${tarefa.descricao}</td>
        
        <c:if test="${tarefa.finalizado eq false}">
            <td id="tarefa_${tarefa.id}">Não finalizado
               <a href="#" onClick="finalizaAgora(${tarefa.id})">Finalizar agora!</a>
            </td>
        </c:if>
        
        <c:if test="${tarefa.finalizado eq true }">
             <td>Finalizado</td>
        </c:if>
        
        <td>
          <fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
        </td>
        
        <td>
           <a href="removeTarefa?id=${tarefa.id}">Remover</a>
        </td>
        
        <td>
           <a href="#" onClick="removeTarefa(this, ${tarefa.id})">Remover (JavaScript)</a>
        </td>
        
        <td>
           <a href="mostraTarefa?id=${tarefa.id}">Alterar</a>
        </td>        
                
      </tr>
    </c:forEach>

  </table>

  <script type="text/javascript">
  
	// seleciona o elemento html através da id e altera o html dele
	// a requisição AJAX chama TarefasController.finaliza()
     function finalizaAgora(id){
    	 $.post("finalizaTarefa", {'id': id}, function(){
    		$("#tarefa_" + id).html("Finalizado");
    	 });
     }

	 // a requisição AJAX chama TarefasController.remove()
     function removeTarefa(elemento, id){
    	 $.post("removeTarefa", {'id': id}, function(){
    		$(elemento).closest("tr").fadeOut();
    	 });
     }
  </script>

</body>
</html>