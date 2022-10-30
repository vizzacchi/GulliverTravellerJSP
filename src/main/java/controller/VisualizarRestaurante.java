package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataSource;
import dao.RestauranteDao;
import model.Restaurante;

import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/restaurante.do")
public class VisualizarRestaurante extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String pagina = "";
		
		try {			
			//CONEXÃO COM O BANCO
			DataSource dataSource = new DataSource();
			RestauranteDao  restauranteDao = new RestauranteDao(dataSource);
			
			//CRIO O OBJETO RESTAURANTE PARA RECUPERAR OS DADOS VIA REQUEST DO GET (ID)
			Restaurante restauranteGet = new Restaurante();
			
			//PASSO O ID DO GET PARA O OBJETO restauranteGet
			restauranteGet.setId(Integer.parseInt(request.getParameter("id")));
			
			//LÊ OS DADOS QUE RETORNAM DO MÉTODO read(restauranteGet)
			Restaurante restaurante = restauranteDao.read(restauranteGet);
			
			if(restaurante != null) {
				//SE CONSEGUIR CARREGAR OS DADOS NA INSTÂNCIA RESTAURANTE MANTÊM O USUÁRIO CONECTADO
				request.getSession().setAttribute("Restaurante", restaurante);
				pagina = "/views/restaurante/visualizar.jsp";
			}
			else {
				request.setAttribute("ErroMSG", "Restaurante não encontrado");
				pagina = "/erro.jsp";
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		}
		catch(Exception ex){
			System.out.println("Erro visualizar restaurante" + ex.getMessage());
		}
	}
}