<%@ attribute name="id" required="true"%>
<%@ attribute name="value" required="false" type="java.util.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:formatDate value="${value}" pattern= "dd/MM/yyyy" var="dataFormatada"/>

<input type="text" id="${id}" name="${id}" value="${dataFormatada}"/>

<script>
	$("#${id}").datepicker({dateFormat : 'dd/mm/yy'});
</script>