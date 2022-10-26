package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataSource;
import dao.HistoriaDao;
import model.Historia;

@WebServlet("/historia.do")
public class VisualizarHistoria extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
				String pagina = "";
				
				try {
					//Crio a conexao com o banco
					DataSource dataSource = new DataSource();
					//Passa o DataSource para o HotelDAO
					HistoriaDao  historiaDao = new HistoriaDao(dataSource);
					
					//Agora crio um objeto Hotel para reecuperar o dados via request do Get Id
					
					Historia historiaGet = new Historia();
					
					//Passando o ID do Get para o objeto hotelGet
					historiaGet.setId(Integer.parseInt(request.getParameter("id")));
					
					//Lendo os dados que retornaram do metodo read(hotelGet)
					Historia historia = historiaDao.read(historiaGet);
					
					if(historia != null) {
						// Se consegui carregar os dados na instância hotel
						// mantenho o usuário conectado
						request.getSession().setAttribute("Historia", historia);
						pagina = "/views/historia/visualizar.jsp";
					}
					else {
						request.setAttribute("ErroMSG", "Historia não encontrado");
						pagina = "/erro.jsp";
					}
					// redirecionando para a página resultante
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
					dispatcher.forward(request, response);
					
				}
				catch(Exception ex){
					System.out.println("Erro visualizar historia" + ex.getMessage());
				}
				
			}

}
