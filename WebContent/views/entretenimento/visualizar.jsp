<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="Entretenimento" scope="session" type="model.Entretenimento"></jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!----- Header ----->
<%@include file="../../include/cabecalho_sub_paginas.jsp"%>
<%@include file="../../include/menu_sub_paginas.jsp"%>

<!----- Content ----->
<main>
	<section>
	   	<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-6">
					<h1 class="fw-bold"><c:out value="${Entretenimento.nome}"></c:out></h1>
				</div>
				<div class="col-sm-12 col-md-6 d-md-flex justify-content-md-end">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="../index.jsp">Index</a></li>
							<li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
							<li class="breadcrumb-item"><a href="views/entretenimento.jsp">Entretenimento</a></li>
							<li class="breadcrumb-item active" aria-current="page"><c:out value="${Entretenimento.nome}"></c:out></li>
						</ol>
					</nav>                        
				</div>
			</div>
		</div>
	</section>
	<article class="container">
		<div class="row row-cols-1 row-cols-sm-1 row-cols-md-2 row-cols-lg-2">
			<div class="col">
				<div class="card">
					<div class="card-body">
			
			
						<p class="mb-3">
							<c:out value="${Entretenimento.descricao }"></c:out>
						</p>
		
						<!------ Avaliações ------>
						<div class="row mb-3">
							<div class="col-md-6">
								<h6>4.852 avaliações nota 4,4 estrelas</h6>
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
														<c:out value="${Entretenimento.avaliacao.usuario.nome}"></c:out>
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
												<c:out value="${Entretenimento.avaliacao.comentario}"></c:out>
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
										<c:out value="${Entretenimento.telefone}"></c:out>
									</td>
								</tr>
								<tr>
									<td class="fw-bold text-nowrap"><i class="bi bi-display mx-2"></i> Site</td>
									<td class="text-end"><a href= "<c:out value="${Entretenimento.site}"></c:out>" target="_black"><c:out value="${Entretenimento.site}"></c:out></a></td>
								</tr>								
								<tr>
									<td class="fw-bold text-nowrap"><i class="bi bi-map mx-2"></i>Região</td>
									<td class="text-end"><c:out value="${Entretenimento.regiao}"></c:out></a></td>
								</tr>							
								<tr>
									<td class="fw-bold text-nowrap"><i class="bi bi-currency-dollar mx-2"></i>Preço</td>
									<td class="text-end"><c:out value="${Entretenimento.faixaPreco.descricao}"></c:out></a></td>
								</tr>						
								<tr>
									<td class="fw-bold text-nowrap"><i class="bi bi-clock mx-2"></i>Horário</td>
									<td class="text-end"><c:out value="${Entretenimento.horarioFuncionamento.dia} ${Entretenimento.horarioFuncionamento.abre} ${Entretenimento.horarioFuncionamento.fecha}"></c:out></a></td>
								</tr>
							</tbody>
						</table>
				
					</div>
				</div>
			</div>
			<div class="col">
				<h4>Imagens:</h4>
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-3 g-4 mb-4">
					<div class="col">
						<div class="card">
							<img src="<c:out value="${Entretenimento.fotos.foto}"></c:out>" class="card-img-top" alt="<c:out value="${Entretenimento.fotos.titulo}"></c:out>">
						</div>
					</div>
					<div class="col">
						<div class="card">
							<img src="./assets/images/hoteis/blue_tree_morumbi/area de lazer.webp" class="card-img-top" alt="blue tree premium morumbi area de lazer">
						</div>
					</div>
					<div class="col">
						<div class="card">
							<img src="../../images/hoteis/blue_tree_morumbi/quartosolteiro.jpeg" class="card-img-top" alt="ALTEr">
						</div>
					</div>
				</div>
				
				<!------ Como Chegar ------>
				<h4>Como Chegar:</h4>
				<div class="alert alert-primary mb-3">
					<div id="endereco"></div>
					<div id="distancia"></div>
					<div id="tempo"></div>
				</div>
				<div id="map"></div>
			</div>
		</div>
	</article>
</main>

<!----- Footer ----->
<%@include file="../../include/rodape_sub_paginas.jsp"%>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA32PDmcZkbv37_Jb-GU9ZOTu9OW4j1n4o" defer></script>
<script src="../../assets/js/geolocalizacao.js"></script>
<script>geolocation("<c:out value='${Entretenimento.endereco.tipoLogradouro}'></c:out><c:out value='${Entretenimento.endereco}'></c:out>,<c:out value='${Entretenimento.numero}'></c:out><c:out value='${Entretenimento.endereco.bairro}'></c:out> CEP: <c:out value='${Entretenimento.endereco.cep}'></c:out>");</script>