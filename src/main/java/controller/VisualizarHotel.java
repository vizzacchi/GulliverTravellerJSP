package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataSource;
import dao.UfDao;
import model.Hotel;
import model.Uf;

@WebServlet("/recupera.do")
public class VisualizarHotel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		
		//LISTA OS HOTÉIS
		ArrayList<Hotel> lista = new ArrayList<Hotel>();
		lista.add(new Hotel(1, "Blue Tree Premium Morumbi", "", "../assets/images/hoteis/blue_tree_morumbi.jpg", "Av. Roque Petroni Júnior, 1000 - Vila Gertrudes, São Paulo - SP, 04707-000", null, 0, "(11) 5187-1200", null, null, null, null, null, null));
		lista.add(new Hotel(2, "Blue Tree Premium Paulista", "", "../assets/images/hoteis/blue_tree_paulista.jpg", "Rua Peixoto Gomide, 707 - Bela Vista, São Paulo - SP, 01409-001", null, 0, "(11) 3147-7000", null, null, null, null, null, null));
		lista.add(new Hotel(3, "Bourbon Convention Ibirapuera", "", "../assets/images/hoteis/bourbon_convention.jpg", "Av. Ibirapuera, 2927 - Ibirapuera, São Paulo - SP, 04029-200", null, 0, "(11) 2161-2200", null, null, null, null, null, null));
		lista.add(new Hotel(4, "Comfort Ibirapuera", "", "../assets/images/hoteis/comfort_ibirapuera.jpg", "Av. Sabiá, 825 - Indianópolis, São Paulo - SP, 04515-001", null, 0, "(11) 4673-0255", null, null, null, null, null, null));
		lista.add(new Hotel(5, "Golden Tulip Paulista Plaza", "", "../assets/images/hoteis/golden_tulip_paulista.jpg", "Alameda Santos, 85 - Jardins, São Paulo - SP, 01419-000", null, 0, "(11) 2627-1000", null, null, null, null, null, null));
		lista.add(new Hotel(6, "IBIS Styles São Paulo Anhembi", "", "../assets/images/hoteis/ibis_styles.jpg", "Av. Cruzeiro do Sul, 1709 - Santana, São Paulo - SP, 02031-000", null, 0, "(11) 3336-5400", null, null, null, null, null, null));
		lista.add(new Hotel(7, "Mercure São Paulo Pamplona", "", "../assets/images/hoteis/mercure_pamplona.jpg", "R. Pamplona, 1315 - Jardim Paulista, São Paulo - SP, 01405-002", null, 0, "(11) 2878-5500", null, null, null, null, null, null));
		lista.add(new Hotel(8, "Renaissance São Paulo Hotel", "", "../assets/images/hoteis/renaissance_sao.jpg", "Alameda Santos, 2233 - Jardim Paulista, São Paulo - SP, 01419-002", null, 0, "(11) 3069-2233", null, null, null, null, null, null));
		lista.add(new Hotel(9, "Sheraton São Paulo WTC Hotel", "", "../assets/images/hoteis/sheraton_WTC.jpg", "Av. das Nações Unidas, 12559 - Brooklin Novo, São Paulo - SP, 04578-903", null, 0, "(11) 3055-8000", null, null, null, null, null, null));
		
		//RECUPERA O ID DA REQUISIÇÃO
		int id = Integer.parseInt(request.getParameter("id"));
		Hotel result = null;
		for (Hotel hoteis : lista) {
			if (hoteis.getId() == id) {
				result = hoteis;
				break;
			}
		}
		
		//REDIRECIONA PARA A PÁGINA CORRETA
		String paginaDestino;
		if (result != null) {
			request.setAttribute("Hotel", result);
			paginaDestino ="/visualizar.jsp";
		}
		else {
			paginaDestino  ="/erro.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}

}