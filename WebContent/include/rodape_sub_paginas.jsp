		
		<!------- Footer ------->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-9">
						<div class="text-primary">
							<i class="bi bi-twitter"></i>
							<i class="bi bi-instagram ms-3"></i>
							<i class="bi bi-facebook ms-3"></i>
						</div>
						<p>Gulliver Traveller | FIAP &copy;2022 - Todos os direitos reservados.</p>
                    </div>
                    <div class="col-sm-12 col-md-3 text-end">
						<button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Deixe sua opinião.</button>
					</div>
                </div>
            </div>
        </footer>        
        
        <!------ Avaliação ------>
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5">Gulliver Traveller</h1>
					</div>
					<div class="modal-body">
						<p class="">
							Gostaríamos de saber a sua opinião, conte-nos um pouco da sua experiência.
						</p>
						<div class="text-center">									
							<div class="stars">
							    <input class="star star-5" id="star-5" type="radio" name="star"/>							
							    <label class="star star-5" for="star-5"></label>
							
							    <input class="star star-4" id="star-4" type="radio" name="star"/>							
							    <label class="star star-4" for="star-4"></label>
							
							    <input class="star star-3" id="star-3" type="radio" name="star"/>							
							    <label class="star star-3" for="star-3"></label>
							
							    <input class="star star-2" id="star-2" type="radio" name="star"/>							
							    <label class="star star-2" for="star-2"></label>
							
							    <input class="star star-1" id="star-1" type="radio" name="star"/>							
							    <label class="star star-1" for="star-1"></label>
							</div>
						</div>
						<div class="form-floating">
							<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
							<label for="floatingTextarea">Deixe seu comentário...</label>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-outline-primary">Avaliar</button>
					</div>
				</div>
			</div>
		</div>

		<!------ V Libras ------>
		<div vw class="enabled">
			<div vw-access-button class="active"></div>
			<div vw-plugin-wrapper>
				<div class="vw-plugin-top-wrapper"></div>
			</div>
		</div>

		<!----- JavaScript ----->
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript" src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
		<script type="text/javascript">new window.VLibras.Widget('https://vlibras.gov.br/app');</script>
		<script type="text/javascript" src="assets/js/accessibility-dark-mode.js"></script>
		<script type="text/javascript" src="assets/js/cotacao-dolar.js"></script>
		<script type="text/javascript" src="assets/js/geolocalizacao.js"></script>
		<script type="text/javascript" src="assets/js/weather.js"></script>
	</body>
</html>