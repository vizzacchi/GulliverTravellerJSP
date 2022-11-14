<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- =======================
Header -->
<%@include file="../include/cabecalho_paginas.jsp"%>
<%@include file="../include/menu_paginas.jsp"%>

	<!-- =======================
	Content START -->
	<main>
		<section>
			<div class="container-home-img">
				<img src="..." class="img-fluid" alt="...">
			</div>
			<div class="container">
				<div class="container-home">
					<div class="row mb-3">
						<div class="col-md-6">
							<h1 class="fw-bold">São Paulo</h1>
						</div>
						<div class="col-md-6 d-md-flex justify-content-md-end">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item">
										<span id="valorDolar"></span>
										<img src="../assets/images/cotacao_dollar.png" width="22" height="22">
									</li>
		                            <li class="breadcrumb-item">
		                            	<span id="description"></span>
										<img src="../assets/images/weather.png" width="28" height="28">
		                            </li>
								</ol>
							</nav>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 d-grid gap-2">
							<a href="" class="btn btn-outline-primary btn-lg">
								<span>Tipo de Viagem</span>
								<i class="bi bi-airplane"></i>
							</a>
						</div>
						<div class="col-md-4 d-grid gap-2">
							<a href="" class="btn btn-outline-primary btn-lg">
								<span>Como Chegar</span>
								<i class="bi bi-geo-alt"></i>
							</a>
						</div>
						<div class="col-md-4 d-grid gap-2">
							<a href="dicasUteis.jsp" class="btn btn-outline-primary btn-lg">
								<span>Dicas Úteis</span>
								<i class="bi bi-info-circle"></i>
							</a>
						</div>			
					</div>
				</div>
			</div>
		</section>

		<!-- =======================
		SOBRE START -->		
		<article class="container">
			<div class="text-center">
				<h2>Gulliver Traveller</h2>
			</div>						
			<div class="text-justify">
				<p class="lead">
					Lorem Ipsum is simply dummy text of the printing and typesetting industry.
					Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
					when an unknown printer took a galley of type and scrambled it to make a type specimen book.
					It has survived not only five centuries.
				</p>					
			</div>
		</article>
		<!-- =======================
		SOBRE END -->
				
		<!-- =======================
		CARDS START -->
		<article class="container-home-wrapper">
			<div class="container swiper">
				<div class="slide-container">
					<div class="card-wrapper swiper-wrapper">
						<div class="card swiper-slide">
							<img src="../assets/images/home/card_locadora.jpg" class="card-img" alt="...">
							<div class="card-img-overlay d-flex">
								<div class="card-text mt-auto">
									<h5 class="card-title text-light fw-bold">Aluguel de Carro</h5>
									<p class="card-text">
										De carros populares a super esportivos, veja as principais locadoras de veículos da cidade de São Paulo.
									</p>
									<a href="aluguelCarros.jsp" class="btn btn-link text-white p-0 mb-0">Clique aqui
										<i class="fa-solid fa-arrow-right-long fa-fw"></i>
									</a>
								</div>
							</div>
						</div>
						<div class="card swiper-slide">
							<img src="../assets/images/home/card_cultura.jpg" class="card-img" alt="...">
							<div class="card-img-overlay d-flex">
								<div class="card-text mt-auto">
									<h5 class="card-title text-light fw-bold">Cultura</h5>
									<p class="card-text">
										São Paulo é uma cidade multi-cultural, de museus as mais diversificadas feiras e exposições, explore.
									</p>
									<a href="cultura.jsp" class="btn btn-link text-white p-0 mb-0">Clique aqui
										<i class="fa-solid fa-arrow-right-long fa-fw"></i>
									</a>
								</div>
							</div>
						</div>
						<div class="card swiper-slide">
							<img src="../assets/images/home/card_entretenimento.jpg" class="card-img" alt="...">
							<div class="card-img-overlay d-flex">
								<div class="card-text mt-auto">
									<h5 class="card-title text-light fw-bold">Entretenimento</h5>
									<p class="card-text">
										Os melhores entretenimentos para quem busca experiências incríveis e inesquecíveis na cidade de São Paulo.
									</p>
									<a href="entretenimento.jsp" class="btn btn-link text-white p-0 mb-0">Clique aqui
										<i class="fa-solid fa-arrow-right-long fa-fw"></i>
									</a>
								</div>
							</div>
						</div>
						<div class="card swiper-slide">
							<img src="../assets/images/home/card_gastronomia.jpg" class="card-img" alt="...">
							<div class="card-img-overlay d-flex">
								<div class="card-text mt-auto">
									<h5 class="card-title text-light fw-bold">Gastronomia</h5>
									<p class="card-text">
										São Paulo impressiona pela diversidade de sua gastronomia, veja os restaurantes em destaque.
									</p>
									<a href="restaurante.jsp" class="btn btn-link text-white p-0 mb-0">Clique aqui
										<i class="fa-solid fa-arrow-right-long fa-fw"></i>
									</a>
								</div>
							</div>
						</div>
						<div class="card swiper-slide">
							<img src="../assets/images/home/card_historia.jpg" class="card-img" alt="...">
							<div class="card-img-overlay d-flex">
								<div class="card-text mt-auto">
									<h5 class="card-title text-light fw-bold">História</h5>
									<p class="card-text">
										Os melhores passeios para quem quer explorar um pouco mais da história da cidade de São Paulo.
									</p>
									<a href="historia.jsp" class="btn btn-link text-white p-0 mb-0">Clique aqui
										<i class="fa-solid fa-arrow-right-long fa-fw"></i>
									</a>
								</div>
							</div>
						</div>
						<div class="card swiper-slide">
							<img src="../assets/images/home/card_hotel.jpg" class="card-img" alt="...">
							<div class="card-img-overlay d-flex">
								<div class="card-text mt-auto">
									<h5 class="card-title text-light fw-bold">Hospedagens</h5>
									<p class="card-text">
										Veja os hotéis em destaque na cidade de São Paulo, explore suas acomodações e serviços.
									</p>
									<a href="hotel.jsp" class="btn btn-link text-white p-0 mb-0">Clique aqui
										<i class="fa-solid fa-arrow-right-long fa-fw"></i>
									</a>
								</div>
							</div>
						</div>
						<div class="card swiper-slide">
							<img src="../assets/images/home/card_parque.jpg" class="card-img" alt="...">
							<div class="card-img-overlay d-flex">
								<div class="card-text mt-auto">
									<h5 class="card-title text-light fw-bold">Parques</h5>
									<p class="card-text">
										Seja para dar uma caminhada, fazer um belo piqui-nique ou apenas para relaxar embaixo de uma árvore, São Paulo oferece diversos parques.
									</p>
									<a href="parque.jsp" class="btn btn-link text-white p-0 mb-0">Clique aqui
										<i class="fa-solid fa-arrow-right-long fa-fw"></i>
									</a>
								</div>
							</div>
						</div>
						<div class="card swiper-slide">
							<img src="../assets/images/home/card_vida_noturna.jpg" class="card-img" alt="...">
							<div class="card-img-overlay d-flex">
								<div class="card-text mt-auto">
									<h5 class="card-title text-light fw-bold">Vida Noturna</h5>
									<p class="card-text">
										São Paulo a cidade que não dorme, possui uma noite vibrante com as melhores casas noturnas do país.
									</p>
									<a href="vidaNoturna.jsp" class="btn btn-link text-white p-0 mb-0">Clique aqui
										<i class="fa-solid fa-arrow-right-long fa-fw"></i>
									</a>
								</div>
							</div>
						</div>
		        	</div>
		      	</div>
		      	<div class="swiper-button-next swiper-navBtn"></div>
				<div class="swiper-button-prev swiper-navBtn"></div>					
				<!--<div class="swiper-pagination"></div>-->
			</div>
		</article>
		<!-- =======================
		CARDS END -->
				
		<!-- =======================
		DESCRIÇÃO START -->		
		<article class="container">
			<div class="text-center">
				<h2>Lugares em destaque</h2>
			</div>						
			<div class="text-justify">
				<p class="lead">
					Lorem Ipsum is simply dummy text of the printing and typesetting industry.
					Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
					when an unknown printer took a galley of type and scrambled it to make a type specimen book.
					It has survived not only five centuries.
				</p>					
			</div>			
			<div class="row">
				<div class="col-lg-10 m-auto text-center">
					<ul class="list-inline hstack gap-4 flex-wrap justify-content-center mt-4">
						<li class="list-inline-item">
							<h5 class="mb-0 fw-normal"><i class="bi bi-star fa-fw text-warning me-1"></i>Mais bem avaliados</h5>
						</li>
						<li class="list-inline-item"> 
							<h5 class="mb-0 fw-normal"><i class="bi bi-pin-map fa-fw text-primary me-1"></i>Lugares mais visitados</h5>
						</li>
					</ul>
				</div>
			</div>
		</article>
		<!-- =======================
		DESCRIÇÃO END -->
		
		<!-- =======================
		DESTAQUES START -->
		<article class="container-home-wrapper">
			<div class="container swiper">
				<div class="slide-container-destaques">
					<div class="card-wrapper swiper-wrapper">
						<div class="card swiper-slide swiper-slide-destaques" style="background-image:url(../assets/images/home/card_gastronomia_destaque.jpg);">
							<div class="row mt-auto mb-auto justify-content-end">
								<div class="col-md-8">
									<div class="card-body">
										<h4 class="text-truncate">Figueira Rubaiyat</h4>
										<div class="card-rate text-center row mb-2">
											<div class="col text-start text-nowrap">
												<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-half text-warning"></i>
											</div>
											<div class="col text-end">
												<i class="bi bi-currency-dollar text-success"></i>
												<i class="bi bi-currency-dollar text-success"></i>
												<i class="bi bi-currency-dollar text-success"></i>
												<i class="bi bi-currency-dollar text-success"></i>
											</div>
										</div>
										<div class="card-text">
											<p class="address">
										    	<strong>Endereço:</strong> Rua Haddock Lobo, 1738 - Jardins, São Paulo - SP, 01414-002
										    </p>
											<p class="phone">
										    	<strong>Telefone:</strong> (11) 3087-1399
										    </p>
										</div>
										<div class="d-grid gap-2 d-md-flex justify-content-md-end">
											<a href="#" class="btn btn-dark mb-0">Detalhes</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="card swiper-slide swiper-slide-destaques" style="background-image:url(../assets/images/home/card_hotel_destaque.jpg);">
							<div class="row mt-auto mb-auto justify-content-end">
								<div class="col-md-8">
									<div class="card-body">
										<h4 class="text-truncate">Blue Tree Premium Paulista</h4>
										<div class="card-rate text-center row mb-2">
											<div class="col text-start text-nowrap">
												<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-half text-warning"></i>
											</div>
											<div class="col text-end">
												<i class="bi bi-currency-dollar text-success"></i>
												<i class="bi bi-currency-dollar text-success"></i>
												<i class="bi bi-currency-dollar text-success"></i>
												<i class="bi bi-currency-dollar text-success"></i>
											</div>
										</div>
										<div class="card-text">
											<p class="address">
										    	<strong>Endereço:</strong> Rua Peixoto Gomide, 707 - Cerqueira César, São Paulo - SP, 01409-001
										    </p>
											<p class="phone">
										    	<strong>Telefone:</strong> (11) 3147-7000
										    </p>
										</div>
										<div class="d-grid gap-2 d-md-flex justify-content-md-end">
											<a href="#" class="btn btn-dark mb-0">Detalhes</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="card swiper-slide swiper-slide-destaques" style="background-image:url(../assets/images/home/card_entretenimento_destaque.jpg);">
							<div class="row mt-auto mb-auto justify-content-end">
								<div class="col-md-8">
									<div class="card-body">
										<h4 class="text-truncate">Jockey Club</h4>
										<div class="card-rate text-center row mb-2">
											<div class="col text-start text-nowrap">
												<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-fill text-warning"></i>
		                                      	<i class="bi bi-star-half text-warning"></i>
											</div>
											<div class="col text-end">
												<i class="bi bi-currency-dollar text-success"></i>
												<i class="bi bi-currency-dollar text-success"></i>
												<i class="bi bi-currency-dollar text-success"></i>
												<i class="bi bi-currency-dollar text-success"></i>
											</div>
										</div>
										<div class="card-text">
											<p class="address">
										    	<strong>Endereço:</strong> Av. Lineu de Paula Machado, 1263 - Cidade Jardim, São Paulo - SP, 05601-000
										    </p>
											<p class="phone">
										    	<strong>Telefone:</strong> (11) 2161-8300
										    </p>
										</div>
										<div class="d-grid gap-2 d-md-flex justify-content-md-end">
											<a href="#" class="btn btn-dark mb-0">Detalhes</a>
										</div>
									</div>
								</div>
							</div>
						</div>
		        	</div>
		      	</div>
		      	<div class="swiper-button-next swiper-navBtn"></div>
				<div class="swiper-button-prev swiper-navBtn"></div>
			</div>
		</article>
		<!-- =======================
		DESTAQUES END -->
	</main>
	<!-- =======================
	Content END -->

<!-- =======================
Footer -->
<%@include file="../include/rodape_paginas.jsp"%>