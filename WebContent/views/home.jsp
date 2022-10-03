<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!----- Header ----->
<%@include file="../include/cabecalho.jsp"%>
<%@include file="../include/menu.jsp"%>

	<!----- Content ----->
	<main>
		<div class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active" data-bs-interval="4000">
                    <img src="../assets/images/teatro_municipal.jpg" class="d-block w-100" alt="Foto do Teatro Municipal de São Paulo">
                </div>
                <div class="carousel-item" data-bs-interval="4000">
                    <img src="../assets/images/Museu_do_Ipiranga.jpg" class="d-block w-100" alt="Foto do Museu de Ipiranga">
                </div>
                <div class="carousel-item" data-bs-interval="4000">
                    <img src="../assets/images/PonteSpraiada.jpg" class="d-block w-100" alt="Foto do rio pinheiros com panoramica da ponte spraiada">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>		
		<form method="POST" action="hotel.jsp" class="form-viagem">
       		<div class="container">
                <h4>Selecione o tipo de viagem:</h4>
                <div class="mb-3">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="tipoTrabalho">
                        <label class="form-check-label" for="tipoTrabalho">Trabalho</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="tipoNegocio">
                        <label class="form-check-label" for="tipoNegocio">Negócio</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="tipoTurismo">
                        <label class="form-check-label" for="tipoTurismo">Turismo</label>
                    </div>
                </div>

                <!----- Input Buscar ----->
                <div class="row row-cols-1 row-cols-sm-1 row-cols-md-4 row-cols-lg-4">
                    <div class="col mb-3">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="origem" value="São Paulo" readonly>
                            <label for="origem">Origem</label>
                        </div>
                    </div>
                    <div class="col mb-3">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="destino" value="São Paulo" readonly>
                            <label for="destino">Destino</label>
                        </div>
                    </div>
                    <div class="col mb-3">
                        <div class="form-floating">
                            <input type="date" class="form-control" id="data_ida">
                            <label for="data_ida">Data Ida</label>
                        </div>
                    </div>
                    <div class="col mb-3">
                        <div class="form-floating">
                            <input type="date" class="form-control" id="data_volta">
                            <label for="data_volta">Data Volta</label>
                        </div>
                    </div>
                </div>
                
                <!----- Botão Buscar ----->
                <div class="d-flex justify-content-end">
                    <input type="submit" class="btn btn-green btn-lg" value="BUSCAR">
                </div>
       		</div>
        </form>
        <section>
		   	<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-6">
						<h1 class="fw-bold">São Paulo</h1>
					</div>
					<div class="col-sm-12 col-md-6 d-md-flex justify-content-md-end">
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
			</div>
		</section>
			    
	    <!------- Article ------->	    		  	    
	    <article class="container">
	        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
	            <div class="col d-flex">
	                <div class="card">
	                    <a href="hotel.jsp">
	                        <img src="../assets/images/destinoSP/Hospedagens.jpg" class="card-img-top" alt="Foto de um quarto de hotel aconchegante">
	                    </a>
	                    <div class="card-body">
	                        <h5 class="card-title text-center fw-bold">Melhores Hospedagens</h5>
	                        <div class="card-text">
	                            <p>
	                                Veja os <a href="hotel.jsp" class="cards-link">hotéis</a> 
	                                em destaque na cidade de São Paulo, explore suas acomodações e serviços.
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col d-flex">
	                <div class="card">
	                    <a href="restaurante.jsp">
	                        <img src="../assets/images/destinoSP/Gastronomia.jpg" class="card-img-top" alt="Um chefe de cozinha preparando um belo prato">
	                    </a>
	                    <div class="card-body">
	                        <h5 class="card-title text-center fw-bold">Destaques Gastronomicos</h5>
	                        <div class="card-text">
	                            <p>
	                                São Paulo impressiona qualquer visitante pela diversidade de sua
	                                <span class="cards-link">gastronomia</span>, veja os <a href="restaurante.jsp" class="cards-link">restaurantes</a> em destaque.
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col d-flex">
	                <div class="card">
	                    <a href="">
	                        <img src="../assets/images/destinoSP/Roteiros.jpg" class="card-img-top" alt="Um mapa aberto com fotos tiradas em diversos passeios.">
	                    </a>
	                    <div class="card-body">
	                        <h5 class="card-title text-center fw-bold">Roteiros em Alta</h5>
	                        <div class="card-text">
	                            <p>
	                                Veja alguns <a href="" class="cards-link">passeios</a> da cidade de São Paulo em destaque,
	                                roteiros exclusivos para parceiros Gulliver Traveller. 
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col d-flex">
	                <div class="card">
	                    <a href="">
	                        <img src="../assets/images/destinoSP/FestasNoturnas.jpg" class="card-img-top" alt="Pessoas curtindo uma festa em uma casa noturna">
	                    </a>
	                    <div class="card-body">
	                        <h5 class="card-title text-center fw-bold">Vida Noturna e Entretenimento</h5>
	                        <div class="card-text">
	                            <p>
	                                São Paulo a cidade que não dorme, possui uma noite vibrante com as melhores
	                                <a href="" class="cards-link">casas noturnas</a> do país.
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col d-flex">
	                <div class="card">
	                    <a href="">
	                        <img src="../assets/images/destinoSP/Dicas.jpg" class="card-img-top" alt="Um mapa mundo com fundo preto, com um avião miniatura sendo empurrado por uma mão">
	                    </a>
	                    <div class="card-body">
	                        <h5 class="card-title text-center fw-bold">Dicas Para Qualquer Viagem</h5>
	                        <div class="card-text">
	                            <p>
	                                Planeje sua viagem com segurança com nossas <a href="" class="cards-link">dicas</a>
	                                e experiência de outros usuários que visitaram a cidade de São Paulo.
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col d-flex">
	                <div class="card">
	                    <a href="">
	                        <img src="../assets/images/destinoSP/Cultura.jpg" class="card-img-top" alt="Pintura de um rosto indigena num grafite de rua.">
	                    </a>
	                    <div class="card-body">
	                        <h5 class="card-title text-center fw-bold">Passeios Culturais</h5>
	                        <div class="card-text">
	                            <p>
	                                São Paulo é uma <a href="" class="cards-link">cidade multi-cultural</a>,
	                                de museus as mais diversificadas feiras e exposições, explore.
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col d-flex">
	                <div class="card">
	                    <a href="">
	                        <img src="../assets/images/destinoSP/aluguelCarros.jpg" class="card-img-top" alt="Carros da mercedes enfileirados a 45 graus">
	                    </a>
	                    <div class="card-body">
	                        <h5 class="card-title text-center fw-bold">Aluguel de Carro</h5>
	                        <div class="card-text">
	                            <p>
	                                De carros populares a super esportivos, veja as principais
	                                <a href="" class="cards-link"> locadoras</a> de veículos da cidade de São Paulo. 
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col d-flex">
	                <div class="card">
	                    <a href="">
	                        <img src="../assets/images/destinoSP/parquesdeSP.jpg" class="card-img-top" alt="Foto de um belo parque com um lago ao fundo de folhas vermelhas">
	                    </a>
	                    <div class="card-body">
	                        <h5 class="card-title text-center fw-bold">Parques</h5>
	                        <div class="card-text">
	                            <p>
	                                Seja para dar uma caminhada,
	                                fazer um belo piqui-nique ou apenas para relaxar embaixo de uma árvore,
	                                São Paulo oferece diversos <a href="" class="cards-link">parques</a>.
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </article>
	</main>

<!----- Footer ----->
<%@include file="../include/rodape.jsp"%>