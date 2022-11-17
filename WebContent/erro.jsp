<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="ErroMSG" scope="request" type="java.lang.String"></jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!----- Header ----->
<%@include file="include/cabecalho.jsp"%>
	
	<!----- Content ----->
	<main>
		<article class="container">
			<div class="row">
				<div class="col-6">
					<h1><c:out value="${ErroMSG}"/></h1>
				</div>
				<div class="col-6">
					<a href="index.jsp" class="btn btn-outline-primary">Voltar</a>
				</div>
			</div>
		</article>
	</main>

<!----- Footer ----->
<%@include file="include/rodape.jsp"%>