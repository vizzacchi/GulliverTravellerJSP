<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="Restaurante" scope="request" type="model.Restaurante"></jsp:useBean>

<!----- Header ----->
<%@include file="../../include/cabecalho_sub_paginas.jsp"%>
<%@include file="../../include/menu_sub_paginas.jsp"%>

	<!----- Content ----->
	<main>
		<section>
		   	<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-6">
						<h1 class="fw-bold"><%=Restaurante.getNome() %></h1>
					</div>
					<div class="col-sm-12 col-md-6 d-md-flex justify-content-md-end">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="index.jsp">Index</a></li>
								<li class="breadcrumb-item"><a href="views/home.jsp">Home</a></li>
								<li class="breadcrumb-item"><a href="views/restaurante.jsp">Restaurantes</a></li>
								<li class="breadcrumb-item active" aria-current="page"><%=Restaurante.getNome() %></li>
							</ol>
						</nav>                        
					</div>
				</div>
			</div>
		</section>
		
		<article class="container">
		
		</article>
	</main>

<!----- Footer ----->
<%@include file="../../include/rodape_sub_paginas.jsp"%>