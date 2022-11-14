	<header>
	    <nav class="navbar navbar-expand-lg navbar-dark bg-blue fixed-top">
	        <div class="container-fluid">
	            <a href="../index.jsp" class="navbar-brand ps-3">
	                <img src="../assets/images/GulliverTravellerMenu.png" alt="Logo Gulliver Traveller">
	            </a>
	            <button type="button" class="navbar-toggler ms-auto" data-bs-toggle="collapse" data-bs-target="#nav-navbar" aria-expanded="false">
	                <span class="navbar-toggler-icon"></span>
	            </button>
	            <div class="collapse navbar-collapse" id="nav-navbar">
	                <ul class="navbar-nav">
	                	<li class="nav-item"><a href="../views/home.jsp" class="nav-link">Home</a></li>
	                    <li class="nav-item"><a href="../views/aluguelCarros.jsp" class="nav-link">Aluguel de carros</a></li>
	                    <li class="nav-item"><a href="../views/cultura.jsp" class="nav-link">Cultura</a></li>
	                    <li class="nav-item"><a href="../views/entretenimento.jsp" class="nav-link">Entretenimento</a></li>
	                    <li class="nav-item"><a href="../views/restaurante.jsp" class="nav-link">Gastronomia</a></li>
	                    <li class="nav-item"><a href="../views/historia.jsp" class="nav-link">História</a></li>
	                    <li class="nav-item"><a href="../views/hotel.jsp" class="nav-link">Hotéis</a></li>
	                    <li class="nav-item"><a href="../views/parque.jsp" class="nav-link">Parques</a></li>
	                    <li class="nav-item"><a href="../views/vidaNoturna.jsp" class="nav-link">Vida noturna</a></li>
	                </ul>
	            
	            	<!----- Cadastrar ----->
	            	<ul class="navbar-nav ms-auto pe-3">
	            		<li class="nav-item">
	            			<a href="../views/cadastro.jsp" class="btn btn-outline-warning">Cadastro</a>
	            		</li>
					</ul>
	            
		            <!--- Accessibility --->
		            <ul class="navbar-nav pe-3">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
								<i class="fas fa-universal-access nav-icon"></i>
							</a>
							<ul class="dropdown-menu dropdown-menu-end">
								<li class="dropdown-item">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="chk">
										<label class="form-check-label" for="chk">Contraste</label>
									</div>
								</li>
								<li><a href="#" class="dropdown-item" onclick="aumenta()"><i class="bi bi-zoom-in text-end pe-1"></i>Aumenta Fonte</a></li>
								<li><a href="#" class="dropdown-item" onclick="diminui()"><i class="bi bi-zoom-out text-end pe-1"></i>Diminui Fonte</a></li>
								<li><a href="#" class="dropdown-item" onclick="dislexia()"><i class="bi bi-type pe-1"></i>Fonte Dislexia</a></li>
								<li><a href="#" class="dropdown-item" onclick="roboto()"><i class="bi bi-type pe-1"></i>Fonte Padrão</a></li>
							</ul>
						</li>
					</ul>
		
		            <!------- Login ------->
					<ul class="navbar-nav">
						<li class="nav-item">
							<a href="#" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar">
			                    <i class="bi bi-person-circle nav-icon"></i>
			                </a>
						</li>
					</ul>
		        </div>
	        </div>
	    </nav>
	
	    <!----- Offcanvas ----->
	    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
	        <div class="offcanvas-header">
	            <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Login</h5>
	            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
	        </div>
	        <div class="offcanvas-body">
	            <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
	                <li class="nav-item" role="presentation">
	                    <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Entrar</button>
	                </li>
	                <li class="nav-item" role="presentation">
	                    <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Cadastre-se</button>
	                </li>
	            </ul>
	            <div class="tab-content" id="pills-tabContent">
	
	                <!------ Sign in ------>
	                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
	                    <form method="POST" action="../login" autocomplete="off">
	                        <div class="form-floating mb-3">
	                            <input type="email" class="form-control" id="email" name="email">
	                            <label for="email">E-mail</label>
	                        </div>
	                        <div class="form-floating mb-3">
	                            <input type="password" class="form-control" id="senha" name="senha">
	                            <label for="senha">Senha</label>
	                        </div>
	                        <div class="text-end">
	                            <button type="submit" class="btn btn-primary w-50">Login</button>
	                        </div>
	                    </form>
	                </div>
	
	                <!------ Sign up ------>
	                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
	                    <form method="POST" action="../cadastrar_usuario" autocomplete="off">
	                        <div class="form-floating mb-3">
	                            <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Usuário" value="user">
	                            <label for="usuario">User</label>
	                        </div>
	                        <div class="form-floating mb-3">
	                            <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" value="name@example.com">
	                            <label for="email">Email address</label>
	                        </div>
	                        <div class="form-floating mb-3">
	                            <input type="password" class="form-control" id="senha" name="senha" placeholder="Password" value="123456">
	                            <label for="senha">Password</label>
	                        </div>
	                        <div class="text-end">
	                            <button type="submit" class="btn btn-primary w-50">Cadastrar</button>
	                        </div>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	</header>