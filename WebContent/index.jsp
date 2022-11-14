<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- =======================
Header -->
<%@include file="include/cabecalho.jsp"%>

	<!-- =======================
	CONTENT START -->
	<main class="bg-destino">
		<div class="bg-destino-overlay"></div>
		<article class="content-destino">
			<img src="assets/images/GulliverTraveller.png" alt="Logo Gulliver Traveller">
			<form method="GET" action="views/home.jsp" class="input-box" autocomplete="off">
				<i class="bi bi-search"></i>
				<input type="text" class="input-search" id="destino" name="destino" placeholder="Escolha um destino..." autofocus>
				<input type="submit" class="btn btn-dark" value="Buscar">
			</form>
		</article>
		
		<!-- =======================
		COOKIE START -->
		<div class="wrapper-cookie">
			<div class="wrapper-cookie-header">
				<i class="bx bx-cookie"></i>
				<h4>Esse site usa cookies</h4>
			</div>
			<div class="wrapper-cookie-body">
				<p>
					Nós armazenamos dados temporariamente para melhorar a sua experiência
					de navegação e recomendar conteúdo de seu interesse. Ao utilizar nossos
					serviços, você concorda com tal monitoramento.
				</p>
				<a href="https://www.via.com.br/privacidade/?area=politicas" target="_blabk">Política de privacidade</a>
			</div>
			<div class="wrapper-cookie-button">
				<button type="button" class="btn btn-primary btn-cookie" id="cookieAccept">Aceitar</button>
  				<button type="button" class="btn btn-primary btn-cookie" id="cookieDecline">Rejeitar</button>
			</div>
		</div>
		<!-- =======================
		COOKIE END -->
	</main>
	<!-- =======================
	CONTENT END -->

<!-- =======================
Footer -->
<%@include file="include/rodape.jsp"%>