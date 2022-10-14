<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!----- Header ----->
<%@include file="include/cabecalho.jsp"%>

	<!----- Content ----->
	<main class="main-destino">
		<article class="article-destino">
			<img src="assets/images/GulliverTraveller.png" class="img-fluid" alt="Logo Gulliver Traveller">
			<div class="card">
				<div class="card-body pb-0">
					<form method="POST" action="views/home.jsp" class="row" autocomplete="off">
						<div class="col-12 col-md-9 col-lg-9">
							<div class="form-floating mb-3">
								<input type="text" class="form-control" name="txtdestino" placeholder="Escolha um destino...">
								<label for="destino">Escolha um destino...</label>
							</div>
						</div>
						<div class="col-12 col-md-3 col-lg-3 mb-3 d-grid gap-2">
							<input type="submit" class="btn btn-green btn-lg" value="Buscar">
						</div>
					</form>
				</div>
			</div>
		</article>
	</main>

<!----- Footer ----->
<%@include file="include/rodape.jsp"%>