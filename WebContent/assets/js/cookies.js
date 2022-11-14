const cookieBox = document.querySelector(".wrapper-cookie"),
	buttons = document.querySelectorAll(".btn-cookie");
	
//console.log(cookieBox, buttons);
	
const executeCodes = () => {
	
	//Se exixtir o cookie gullivertraveller ele será retornado e o código abaixo não será executado
	if(document.cookie.includes("gullivertraveller")) return;
	cookieBox.classList.add("show");
	
	buttons.forEach((button) => {
		button.addEventListener("click", () => {
			cookieBox.classList.remove("show");
			
			//Caso Aceite
			if(button.id == "cookieAccept") {
				
				//Armazena cookies por 1 mês. 60 = 1 min, 60 = 1 hora, 24 = 1 dia, 30 = 30 dias
				document.cookie = "cookieBy= gullivertraveller; max-age=" + 60 * 60 * 24 * 30;
			}
		});
	});
};

//A função executeCodes será chamada no carregamento da página da web
window.addEventListener("load", executeCodes);