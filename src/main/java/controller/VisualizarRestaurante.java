package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Restaurante;

@WebServlet("/restaurante.do")
public class VisualizarRestaurante extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		
		//LISTA OS RESTAURANTES
		ArrayList<Restaurante> lista = new ArrayList<Restaurante>();
		lista.add(new Restaurante(1, "D.O.M.", "", "../assets/images/restaurantes/dom.jpg", "R. Barão de Capanema, 549 - Jardins, São Paulo - SP, 01411-011", null, 0, "(11) 96918-9947", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(2, "Figueira Rubaiyat", "", "../assets/images/restaurantes/figueira_rubaiyat.jpg", "Endereço: Rua Haddock Lobo, 1738 - Jardins, São Paulo - SP, 01414-002", null, 0, "(11) 3087-1399", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(3, "Fasano", "", "../assets/images/restaurantes/fasano.jpg", "R. Vitório Fasano, 88 - Cerqueira César, São Paulo - SP, 01414-020", null, 0, "(11) 3896-4000", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(4, "Estadão Bar e Lanches", "", "../assets/images/restaurantes/estadao_bar_lanches.jpg", "Viaduto Nove de Julho, 193 - Centro Histórico de São Paulo, São Paulo - SP, 01050-060", null, 0, "(11) 3257-7121", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(5, "Ponto Chic", "", "../assets/images/restaurantes/ponto_chic.jpg", "L. Padre Péricles, 139 - Perdizes, São Paulo - SP, 01156-040", null, 0, "(11) 3826-0500", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(6, "Pastelaria Yokoyama", "", "../assets/images/restaurantes/yokoyama.jpg", "Av. Lins de Vasconcelos, 1365 - Cambuci, São Paulo - SP, 01537-001", null, 0, "(11) 3207-9613", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(7, "Bar do Alemão", "", "../assets/images/restaurantes/bar_do_alemao.jpg", "R. Dr. Mário Ferraz, 490 - Itaim Bibi, São Paulo - SP, 01453-011", null, 0, "(11) 3078-3828", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(8, "Famiglia Mancini", "", "../assets/images/restaurantes/famiglia_mancini.jpg", "Rua Avanhandava, 81, Bela Vista - Centro Histórico de São Paulo, São Paulo - SP, 01050-000", null, 0, "(11) 3256-4320", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(9, "Terraço Itália", "", "../assets/images/restaurantes/terraco_italia.jpg", "Av. Ipiranga, 344 - 41º andar - República, São Paulo - SP, 01046-010", null, 0, "(11) 2189-2929", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(10, "Eataly", "", "../assets/images/restaurantes/eataly.jpg", "Av. Pres. Juscelino Kubitschek, 1489 - Vila Nova Conceição, São Paulo - SP, 04543-011", null, 0, "(11) 3279-3300", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(11, "Bella Paulista", "", "../assets/images/restaurantes/bella_paulista.jpg", "Rua Haddock Lobo, 354 - Cerqueira César, São Paulo - SP, 01414-000", null, 0, "(11) 3214-3347", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(12, "KOF - King Of The Fork", "", "../assets/images/restaurantes/kof.jpg", "R. Artur de Azevedo, 1317 - Pinheiros, São Paulo - SP, 05404-013", null, 0, "(11) 2533-9391", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(13, "Butantan Food Park", "", "../assets/images/restaurantes/butantan_food.jpg", "R. Agostinho Cantu, 47 - Butantã, São Paulo - SP, 05501-010", null, 0, "(11) 3564-8731", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(14, "Calçadão Urbanoide", "", "../assets/images/restaurantes/calcadao_urbanoide.jpg", "R. Frei Caneca, 1024 - Consolação, São Paulo - SP, 01307-002", null, 0, "", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(15, "Coco Bambu", "", "../assets/images/restaurantes/coco_bambu.jpg", "Av. Braz Leme, 201 - Casa Verde, São Paulo - SP, 02511-000", null, 0, "(11) 2373-7552", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(16, "Mocotó", "", "../assets/images/restaurantes/mocoto.jpg", "Av. Nossa Sra. do Loreto, 1100 - Vila Medeiros, São Paulo - SP, 02219-001", null, 0, "(11) 2951-3056", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(17, "Tatini", "", "../assets/images/restaurantes/tatini.jpg", "R. Batataes, 558 - Jardim Paulista, São Paulo - SP, 01423-010", null, 0, "(11) 3885-7601", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(18, "Era uma vez um chalezinho", "", "../assets/images/restaurantes/chalezinho.jpg", "Rua Itapimirum, 11 - Morumbi, São Paulo - SP, 05716-090", null, 0, "(11) 3501-9322", null, null, null, null, null, false, false, false, null, null));
		lista.add(new Restaurante(19, "Le Jazz Brasserie", "", "../assets/images/restaurantes/le_jazz_brasserie.jpg", "R. dos Pinheiros, 254 - Pinheiros, São Paulo - SP, 05422-012", null, 0, "(11) 2359-8141", null, null, null, null, null, false, false, false, null, null));
		
		//RECUPERA O ID DA REQUISIÇÃO
		int id = Integer.parseInt(request.getParameter("id"));
		Restaurante result = null;
		for (Restaurante restaurante : lista) {
			if (restaurante.getId() == id) {
				result = restaurante;
				break;
			}
		}
		
		//REDIRECIONA PARA A PÁGINA CORRETA
		String paginaDestino;
		if (result != null) {
			request.setAttribute("Restaurante", result);
			paginaDestino ="/./views/restaurante/visualizar.jsp";
		}
		else {
			paginaDestino  ="/erro.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}
}