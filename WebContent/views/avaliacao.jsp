<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!----- Header ----->
<%@include file="../include/cabecalho_paginas.jsp"%>
<%@include file="../include/menu_paginas.jsp"%>

	<!----- Content ----->
	<main>
		<section class="section-page">
		   	<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-6">
						<h1 class="fw-bold">Cadastro de Avaliação</h1>
					</div>
					<div class="col-sm-12 col-md-6 d-md-flex justify-content-md-end">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="../index.jsp">Index</a></li>
								<li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">Cadastro Avaliação</li>
							</ol>
						</nav>                        
					</div>
				</div>
			</div>
		</section>
	    <article class="container">
		    <form method="POST" action="/avaliacao.do" class="content" autocomplete="off">
		    	<h6 class="mb-2 text-primary">Faça sua avaliação:</h6>
	            <div class="row">
	            	<div class="col-md-4 mb-6">
	                    <div class="form-floating">
	                        <div class="cadastro__dias__Semana">
              					<label for="nota">Qual a sua avaliação sobre este cadastro?</label>
                				<input id="nota" name="nota" type="range" class="form-control" oninput="getElementById('exibePercent').innerHTML = this.value;"
                    				min="0" max="5" value="5" step="0.1" />
                				<span id="exibePercent">5</span>
                      		</div>
	                	</div>
	                </div>
	                <div class="col-md-8 mb-6">
						<div class="form-floating">
							<textarea class="form-control" placeholder="Digite um descrição sobre o destino..." id="descricao" name="descricao" style="height: 100px"></textarea>
						  	<label for="floatingTextarea2">Descrição</label>
						</div>
	                </div>
	            </div>
	            
	            <!---- Botão ---->
	            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
	                <button type="submit" class="btn btn-primary">Salvar</button>
					<button type="button" class="btn btn-secondary">Cancelar</button>
	            </div>
            </form>
  		</article>
	</main>

<!----- Footer ----->
<%@include file="../include/rodape_paginas.jsp"%>