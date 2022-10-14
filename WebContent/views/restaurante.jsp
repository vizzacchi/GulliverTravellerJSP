<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controller.ListarRestaurante"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Restaurante" %>

<!----- Header ----->
<%@include file="../include/cabecalho_paginas.jsp"%>
<%@include file="../include/menu_paginas.jsp"%>

	<!----- Content ----->
	<main>
		<section>
		   	<div class="container">
				<div class="row mb-3">
					<div class="col-sm-12 col-md-6">
						<h1 class="fw-bold">Gastronomia</h1>
					</div>
					<div class="col-sm-12 col-md-6 d-md-flex justify-content-md-end">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="../index.jsp">Index</a></li>
								<li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
		                        <li class="breadcrumb-item active" aria-current="page">Gastronomia</li>
							</ol>
						</nav>                        
					</div>
				</div>				
				<div class="row">
				    <div class="col-12 col-md-6"> 
				        <h6>São Paulo é uma cidade muito rica em Gastronomia, veja alguns números:</h6>
				        <span class="badge rounded-pill fs-6 bg-info text-dark">15 mil restaurantes</span>
				        <span class="badge rounded-pill fs-6 bg-warning text-dark">20 mil bares</span>
				        <span class="badge rounded-pill fs-6 bg-danger">6 mil pizzarias</span>
				    </div>
				    <div class="col-12 col-md-6">
				        <form action="">
				            <h6>Filtre por tipo de culinária:</h6>
				            <div class="input-group">
				                <select class="form-select" name="pesquise" id="pesquise">
				                    <option value="">Escolha...</option>
				                    <option value="">Bistro</option>
				                    <option value="">Brasileira</option>
				                    <option value="">Chinesa</option>
				                    <option value="">Churrascaria</option>
				                    <option value="">Comida de Buteco</option>
				                    <option value="">Fast Food</option>
				                    <option value="">FOOD Truck</option>
				                    <option value="">Italiana</option>
				                    <option value="">Japonesa</option>
				                    <option value="">Padarias</option>
				                    <option value="">Outras</option>
				                </select>
				                <input type="submit" class="btn btn-green col-3" Value="Filtrar">
				            </div>
				        </form>
				    </div>
				</div>
			</div>
		</section>
	
		<!------ Card ------>
	    <article class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
				<%
			    ListarRestaurante restaurante = new ListarRestaurante(); 
			            ArrayList<Restaurante> lista = restaurante.getLista();
			    %>			
			   <% for (Restaurante r: lista) { %>
				   <div class="col d-flex">
				       <div class="card">
				           <a href="../restaurante.do?id=<%=r.getId() %>">
				               <img src="<%=r.getFotoPerfil() %>" class="card-img-top" alt="<%=r.getNome() %>">
				           </a>
				           <div class="card-body pb-0">
				               <h5 class="card-title text-center fw-bold"><%=r.getNome() %></h5>
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
				                       <strong>Endereço:</strong> <%=r.getDescricao() %>
				                   <p class="phone">
				                       <strong>Telefone:</strong> <%=r.getComplemento() %>
				                   </p>
				               </div>
				           </div>
						   <div class="d-grid mx-auto reserva">
						   		<a href="<%=r.getSite() %>"target="_blank" class="btn btn-green">Faça sua reserva</a>
						   </div>
				       </div>
				   </div>
				<% } %>
			</div>		     
  		</article>
	</main>

<!----- Footer ----->
<%@include file="../include/rodape_paginas.jsp"%>