<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- =======================
Header -->
<%@include file="include/cabecalho.jsp"%>

	<!-- =======================
	Content START -->
	<main class="bg-destino">
		<div class="bg-destino-overlay"></div>
		<article class="content-destino">
			<img src="assets/images/GulliverTraveller.png" alt="Logo Gulliver Traveller">
			<form method="GET" action="views/home.jsp" class="input-box" autocomplete="off">
				<i class="bi bi-search"></i>
				<input type="text" class="input-search" placeholder="Escolha um destino..." autofocus>
				<input type="submit" class="btn btn-dark" value="Buscar">
			</form>
		</article>
	</main>
	<!-- =======================
	Content END -->

<!-- =======================
Footer -->
<%@include file="include/rodape.jsp"%>