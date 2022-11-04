<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controller.ListarCultura"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Cultura" %>

<!----- Header ----->
<%@include file="../include/cabecalho_paginas.jsp"%>
<%@include file="../include/menu_paginas.jsp"%>

	<!----- Content ----->
	<main>
		<section>
		   	<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-6">
						<h1 class="fw-bold">Cultura</h1>
					</div>
					<div class="col-sm-12 col-md-6 d-md-flex justify-content-md-end">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="../index.jsp">Index</a></li>
								<li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">Cultura</li>
							</ol>
						</nav>                        
					</div>
				</div>
			</div>
		</section>
			
	    <!------ Card ------>
	    <article class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
				<%
			    ListarCultura cultura = new ListarCultura();
			            ArrayList<Cultura> lista = cultura.listarCultura();
			    %>			
			   <% for (Cultura r: lista) { %>
				   <div class="col d-flex">
				       <div class="card">
				           <a href="../cultura.do?id=<%=r.getId() %>">
				               <img src="<%=r.getFotoPerfil() %>" class="card-img-top" alt="<%=r.getNome() %>">
				           </a>
				           <div class="card-body pb-0">
				               <h5 class="card-title text-center fw-bold"><%=r.getNome() %></h5>
				               <div class="card-rate text-center mb-2">
				                   <i class="bi bi-star-fill text-warning"></i>
				                   <i class="bi bi-star-fill text-warning"></i>
				                   <i class="bi bi-star-fill text-warning"></i>
				                   <i class="bi bi-star-fill text-warning"></i>
				                   <i class="bi bi-star-half text-warning"></i>
				               </div>
				               <div class="card-text">
				                   <p class="address">
				                       <strong>Endereço:</strong> <%=r.getEndereco() %>
				                   <p class="phone">
				                       <strong>Telefone:</strong> <%=r.getTelefone() %>
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