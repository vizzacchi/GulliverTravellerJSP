<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="Mensagem" type="java.lang.String" scope="request"/>

<!----- Header ----->
<%@include file="include/cabecalho_index.jsp"%>

	<h1>Erro!</h1>
	<hr>
	Mensagem de Erro: <c:out value="${Mensagem}"/>
	<br>
	<a href="./index.jsp">Voltar ao Inicio</a>

<!----- Footer ----->
<%@include file="include/rodape_index.jsp"%>