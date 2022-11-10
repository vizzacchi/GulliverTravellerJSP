<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!----- Header ----->
<%@include file="../include/cabecalho_paginas.jsp"%>
<%@include file="../include/menu_paginas.jsp"%>
    
<main class="main-page container">
        <section class="mb-4">
            <h1 class="text-center">Dicas �teis</h1>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="../../index.html">Home</a></li>
                    <li class="breadcrumb-item"><a href="../destino.html">Destino</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Dicas �teis</li>
                </ol>
            </nav>
        </section>
        <article class="row row-cols-1 row-cols-sm-1">
            <div class="col">

                <!------- Descri��o ------->
                <p class="text-left">
                    S�o Paulo � um munic�pio brasileiro, capital do estado hom�nimo e principal centro financeiro,
                    corporativo e mercantil da Am�rica do Sul. � a cidade mais populosa do Brasil, do continente
                    americano, da lusofonia e de todo o hemisf�rio sul. S�o Paulo � a cidade brasileira mais influente
                    no cen�rio global, sendo, em 2016, a 11.� cidade mais globalizada do planeta, recebendo a
                    classifica��o de cidade global alfa, por parte do Globalization and World Cities Study Group &
                    Network (GaWC). O lema da cidade, presente em seu bras�o oficial, � Non ducor, duco, frase latina
                    que significa "N�o sou conduzido, conduzo". <br>S�o Paulo a cidade que nunca para.
                </p>
                <!------ Avalia��es ------>
                <div class="row mb-4">
                    <div class="col-md-6">
                        <h6>2.489 avalia��es, nota 4,4 estrelas</h6>
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
                            <button type="button" class="btn btn-green" data-bs-toggle="modal"
                                data-bs-target="#modal-comentarios">Coment�rios</button>
                        </div>
                    </div>
                </div>

                <!--- Modal Avalia��es --->
                <div class="modal fade" id="modal-comentarios" data-bs-backdrop="static" data-bs-keyboard="false"
                    tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-scrollable">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Todas as avalia��es</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="collapse" id="collapseExample">
                                    <div class="form-floating">
                                        <textarea class="form-control" id="floatingTextarea2"></textarea>
                                        <label for="floatingTextarea2">Deixe seu coment�rio...</label>
                                    </div>
                                </div>

                                <!----- Coment�rios ----->
                                <div class="border p-3 mb-3">
                                    <div class="row row-cols-1 row-cols-sm-1 row-cols-md-2 row-cols-lg-2 g-4 mb-4">
                                        <div class="col">
                                            <h5>Italo Santos</h5>
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
                                        Cidade maravilhosa, onde � poss�vel encontrar diferente culturas e op��es de laser.
                                    </p>
                                </div>
                                <div class="border p-3 mb-3">
                                    <div class="row row-cols-1 row-cols-sm-1 row-cols-md-2 row-cols-lg-2 g-4 mb-4">
                                        <div class="col">
                                            <h5>Guilerme Ribas</h5>
                                        </div>
                                        <div class="col text-end">
                                            <i class="bi bi-star-fill text-warning"></i>
                                            <i class="bi bi-star-fill text-warning"></i>
                                            <i class="bi bi-star-fill text-warning"></i>
                                            <i class="bi bi-star text-warning"></i>
                                            <i class="bi bi-star text-warning"></i>
                                        </div>
                                    </div>
                                    <p>
                                        Cidade onde � poss�vel encontrar todos os tipos de gastronomia.
                                    </p>
                                </div>
                                <div class="border p-3 mb-3">
                                    <div class="row row-cols-1 row-cols-sm-1 row-cols-md-2 row-cols-lg-2 g-4 mb-4">
                                        <div class="col">
                                            <h5>Douglas Jorge</h5>
                                        </div>
                                        <div class="col text-end">
                                            <i class="bi bi-star-fill text-warning"></i>
                                            <i class="bi bi-star-fill text-warning"></i>
                                            <i class="bi bi-star-fill text-warning"></i>
                                            <i class="bi bi-star-fill text-warning"></i>
                                            <i class="bi bi-star-fill text-warning"></i>
                                        </div>
                                    </div>
                                    <p>
                                        Adoooooro esse lugar...
                                        N�o importa sua origem, S�o Paulo ir� te surpreender.
                                    </p>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-green" data-bs-toggle="collapse"
                                    data-bs-target="#collapseExample">Inserir Coment�rios</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!------ Informa��es ------>
                <table class="table">
                    <tbody>
                        <tr>
                            <td class="fw-bold"><i class="bi bi-calendar-event mx-2"></i> Quando ir</td>
                            <td class="text-end">Os melhroes meses para se visitar S�o Paulo � Janeiro e Julho, meses de f�rias escolares a cidade fica mais vazia e a locomo��o � mais f�cil.</td>
                        </tr>
                        <tr>
                            <td class="fw-bold"><i class="bi bi-thermometer-sun mx-2"></i> Temperatura M�dia Anual</td>
                            <td class="text-end">18,5�C</td>
                        </tr>
                        <tr>
                            <td class="fw-bold"><i class="bi bi-clock mx-2"></i> Fuso Hor�rio</td>
                            <td class="text-end"> UTC-3 Hor�rio oficial de Brasilia</td>
                        </tr>
                        <tr>
                            <td class="fw-bold"><i class="bi bi-hourglass-split mx-2"></i> Tempo M�dio de Perman�ncia</td>
                            <td class="text-end">Lazer - 15 dias<br>Neg�cios - 7 dias<br></td>
                        </tr>
                        <tr>
                            <td class="fw-bold"><i class="bi bi-translate mx-2"></i>Idioma</td>
                            <td class="text-end">Portugues - Brasileiro</td>
                        </tr>
                        <tr>
                            <td class="fw-bold"><i class="bi bi-outlet mx-2"></i> Voltagem</td>
                            <td class="text-end">110V tomada NBR 14136 de 3 pinos</td>
                        </tr>
                        <tr>
                            <td class="fw-bold"><i class="bi bi-currency-dollar mx-2"></i> Moeda</td>
                            <td class="text-end">Real Brasileiro R$</td>
                        </tr>
                        <tr>
                            <td class="fw-bold"><i class="bi bi-clock mx-2"></i> Documentos Necess�rios</td>
                            <td class="text-end">
                                Se estrangeiro Passorte
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </article>
    </main>
    
  <!----- Footer ----->
<%@include file="../include/rodape_paginas.jsp"%>