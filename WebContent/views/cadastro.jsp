<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!----- Header ----->
<%@include file="../include/cabecalho_paginas.jsp"%>
<%@include file="../include/menu_paginas.jsp"%>

	<!----- Content ----->
	<main>
		<section>
		   	<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-6">
						<h1 class="fw-bold">Cadastro</h1>
					</div>
					<div class="col-sm-12 col-md-6 d-md-flex justify-content-md-end">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="../index.jsp">Index</a></li>
								<li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">Cadastro</li>
							</ol>
						</nav>                        
					</div>
				</div>
			</div>
		</section>
	    <article class="container">
		    <form method="POST" action="" class="content" autocomplete="off">
		    	<h6 class="mb-2 text-primary">Destino:</h6>
	            <div class="row">
	            	<div class="col-md-7 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="destino" name="destino">
	                        <label for="cep">Destino</label>
	                    </div>
	                </div>
	                <div class="col-md-5 mb-3">
	                    <div class="form-floating">
						  	<select class="form-select" id="categoria" name="categoria">
							    <option selected>Selecione um categoria</option>
							    <option value="1">Aluguel de carros</option>
								<option value="2">Cultura</option>
								<option value="3">Entretenimento</option>
								<option value="4">Gastronomia</option>
								<option value="5">História</option>
								<option value="6">Hotéis</option>
								<option value="7">Parques</option>
								<option value="8">Vida noturna</option>
						  	</select>
							<label for="floatingSelect">Categoria</label>
						</div>
	                </div>
	                <div class="col-md-12 mb-3">
						<div class="form-floating">
							<textarea class="form-control" placeholder="Digite um descrição sobre o destino..." id="descricao" name="descricao" style="height: 100px"></textarea>
						  	<label for="floatingTextarea2">Descrição</label>
						</div>
	                </div>
	                <div class="col-md-4 mb-3">
	                    <label for="formFile" class="form-label">Imagem 1</label>
  						<input class="form-control" type="file" id="formFile">
	                </div>
	                <div class="col-md-4 mb-3">
	                    <label for="formFile" class="form-label">Imagem 3</label>
  						<input class="form-control" type="file" id="formFile">
	                </div>
	                <div class="col-md-4 mb-3">
	                    <label for="formFile" class="form-label">Imagem 3</label>
  						<input class="form-control" type="file" id="formFile">
	                </div>
	                
	                <!----- Contatos ----->
	                <h6 class="mb-2 text-primary">Contato:</h6>
	                <div class="col-md-3 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="telefone" name="telefone">
	                        <label for="cep">Telefone</label>
	                    </div>
	                </div>
	                <div class="col-md-3 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="celular" name="celular">
	                        <label for="cep">Celular</label>
	                    </div>
	                </div>
	                <div class="col-md-6 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="email" name="email">
	                        <label for="cep">E-mail</label>
	                    </div>
	                </div>
	            </div>
		    
				<!----- Endereço ----->
	            <h6 class="mb-2 text-primary">Endereço:</h6>
	            <div class="row">
	                <div class="col-md-2 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="cep" name="cep" maxlength="9">
	                        <label for="cep">Cep</label>
	                    </div>
	                </div>
	                <div class="col-md-4 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="logradouro" name="logradouro">
	                        <label for="logradouro">Endereço</label>
	                    </div>
	                </div>
	                <div class="col-md-2 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="numero" name="numero">
	                        <label for="numero">Número</label>
	                    </div>
	                </div>
	                <div class="col-md-4 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="complemento" name="complemento">
	                        <label for="complemento">Complemento</label>
	                    </div>
	                </div>
	                <div class="col-md-5 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="bairro" name="bairro">
	                        <label for="bairro">Bairro</label>
	                    </div>
	                </div>
	                <div class="col-md-5 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="localidade" name="localidade">
	                        <label for="localidade">Localidade</label>
	                    </div>
	                </div>
	                <div class="col-md-2 mb-3">
	                    <div class="form-floating">
	                        <input type="text" class="form-control" id="uf" name="uf" maxlength="2">
	                        <label for="uf">UF</label>
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