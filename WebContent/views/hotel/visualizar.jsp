<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="Hotel" scope="session" type="model.Hotel"></jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Foto" %>

<!----- Header ----->
<%@include file="../../include/cabecalho_sub_paginas.jsp"%>
<%@include file="../../include/menu_sub_paginas.jsp"%>

<!----- Content ----->
<main>
	<section>
	   	<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-6">
					<h1 class="fw-bold"><c:out value="${Hotel.nome}"></c:out></h1>
				</div>
				<div class="col-sm-12 col-md-6 d-md-flex justify-content-md-end">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="../index.jsp">Index</a></li>
							<li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
							<li class="breadcrumb-item"><a href="views/hotel.jsp">Hotéis</a></li>
							<li class="breadcrumb-item active" aria-current="page"><c:out value="${Hotel.nome}"></c:out></li>
						</ol>
					</nav>                        
				</div>
			</div>
		</div>
	</section>
	<article class="container">
		<div id="photo-gallery" class="mb-3 px-0 py-0">
			<%
		    	ArrayList<Foto> lista = Hotel.getFotos();
		    %>			
			<% for (Foto r: lista) { %>
				<img src="<%=r.getFoto() %>" class="<% if (lista.indexOf(r) == 0) { %> image-grid-col-2 image-grid-row-2 <% } %>" alt="<%=r.getDescricao() %>" title="<%=r.getTitulo() %>">			
			<% } %>
		</div>
		<div class="row">
			<div class="col-md-12 mb-3">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Descrição</h4>
						<p><c:out value="${Hotel.descricao}"></c:out></p>
					</div>
				</div>
			</div>

			<!------ Informações ------>
			<div class="col-md-7 mb-3">
				<div class="card card-d-flex">
					<div class="card-body">
						<h4 class="card-title">Avaliações e informações</h4>
						<div class="row mb-3">
							<div class="col-md-6">
								<h5>4.852 avaliações nota 4,4 estrelas</h5>
								<div class="card-rate">
									<i class="bi bi-star-fill text-warning"></i>
									<i class="bi bi-star-fill text-warning"></i>
									<i class="bi bi-star-fill text-warning"></i>
									<i class="bi bi-star-fill text-warning"></i>
									<i class="bi bi-star-half text-warning"></i>
								</div>
							</div>
							<div class="col-md-6">
								<div class="d-grid gap-2 d-md-flex justify-content-md-end">
									<button type="button" class="btn btn-green" data-bs-toggle="modal" data-bs-target="#modal-comentarios">Comentários</button>
								</div>
							</div>
						</div>
		
						<!--- Modal Avaliações --->
						<div class="modal fade" id="modal-comentarios" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg modal-dialog-scrollable">
								<div class="modal-content">
									<div class="modal-header">
									<h5 class="modal-title" id="staticBackdropLabel">Todas as avaliações</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<div class="collapse" id="collapseExample">
											<div class="form-floating">
												<textarea class="form-control" id="floatingTextarea2"></textarea>
												<label for="floatingTextarea2">Deixe seu comentário...</label>
											</div>
										</div>
		
										<!----- Comentários ----->
										<div class="border p-3 mb-3">
											<div class="row row-cols-1 row-cols-sm-1 row-cols-md-2 row-cols-lg-2 g-4 mb-4">
												<div class="col">
													<h5>
														<c:out value="${Hotel.avaliacao.usuario.nome}"></c:out>
													</h5>
												</div>
												<div class="col text-end">
													<i class="bi bi-star-fill text-warning"></i>
													<i class="bi bi-star-fill text-warning"></i>
													<i class="bi bi-star-fill text-warning"></i>
													<i class="bi bi-star-fill text-warning"></i>
													<i class="bi bi-star-half text-warning"></i>
												</div>
											</div>
											<p>
												<c:out value="${Hotel.avaliacao.comentario}"></c:out>
											</p>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-green" data-bs-toggle="collapse" data-bs-target="#collapseExample">Inserir Comentários</button>
										<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
									</div>
								</div>
							</div>
						</div>
		
						<!------ Informações ------>
						<table class="table">
							<tbody>
								<tr>
									<td class="fw-bold text-nowrap"><i class="bi bi-telephone mx-2"></i> Telefone</td>
									<td class="text-end">
										<c:out value="${Hotel.telefone}"></c:out>
									</td>
								</tr>
								<tr>
									<td class="fw-bold text-nowrap"><i class="bi bi-display mx-2"></i> Site</td>
									<td class="text-end"><a href= "<c:out value="${Hotel.site}"></c:out>" target="_black"><c:out value="${Hotel.site}"></c:out></a></td>
								</tr>
								<tr>
									<td class="fw-bold text-nowrap"><i class="bi bi-calendar-event mx-2"></i>Melhor Dia</td>
									<td class="text-end"><c:out value="${Hotel.melhorDia}"></c:out></a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<!------ Como Chegar ------>
			<div class="col-md-5 mb-3">
				<div class="card card-d-flex">
					<div class="card-body">
						<div id="map" class="mb-3"></div>
						<table class="table">
							<tbody>
								<tr>
									<td class="fw-bold">
										<i class="bi bi-geo-alt-fill mx-2"></i>
									</td>
									<td id="endereco"></td>
								</tr>
								<tr>
									<td class="fw-bold">
										<i class="bi bi-car-front-fill mx-2"></i>
									</td>
									<td id="distancia"></td>
								</tr>
								<tr>
									<td class="fw-bold">
										<i class="bi bi-clock mx-2"></i>
									</td>
									<td id="tempo"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</article>
</main>

<!----- Footer ----->
<%@include file="../../include/rodape_sub_paginas.jsp"%>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA32PDmcZkbv37_Jb-GU9ZOTu9OW4j1n4o" defer></script>
<script src="../../assets/js/geolocalizacao.js"></script>
<script>geolocation("<c:out value='${Hotel.endereco.tipoLogradouro}'></c:out><c:out value='${Hotel.endereco}'></c:out>,<c:out value='${Hotel.numero}'></c:out><c:out value='${Hotel.endereco.bairro}'></c:out> CEP: <c:out value='${Hotel.endereco.cep}'></c:out>");</script>