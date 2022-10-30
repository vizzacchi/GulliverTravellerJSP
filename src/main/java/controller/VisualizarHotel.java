package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hotel;
import dao.HotelDao;
import dao.DataSource;

import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/hotel.do")
public class VisualizarHotel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String pagina = "";
		
		try {
			//Crio a conexao com o banco
			DataSource dataSource = new DataSource();
			//Passa o DataSource para o HotelDAO
			HotelDao  hotelDao = new HotelDao(dataSource);
			
			//Agora crio um objeto Hotel para reecuperar o dados via request do Get Id
			
			Hotel hotelGet = new Hotel();
			
			//Passando o ID do Get para o objeto hotelGet
			hotelGet.setId(Integer.parseInt(request.getParameter("id")));
			
			//Lendo os dados que retornaram do metodo read(hotelGet)
			Hotel hotel = hotelDao.read(hotelGet);
			
			if(hotel != null) {
				// Se consegui carregar os dados na instância hotel
				// mantenho o usuário conectado
				request.getSession().setAttribute("Hotel", hotel);
				pagina = "/views/hotel/visualizar.jsp";
			}
			else {
				request.setAttribute("ErroMSG", "Hotel não encontrado");
				pagina = "/erro.jsp";
			}
			// redirecionando para a página resultante
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		}
		catch(Exception ex){
			System.out.println("Erro visualizar hotel" + ex.getMessage());
		}
		
	}
		
		
}