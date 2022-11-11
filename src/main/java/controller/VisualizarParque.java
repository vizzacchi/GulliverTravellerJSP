package controller;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataSource;
import dao.ParqueDao;
import model.Parque;

@WebServlet("/parque.do")
public class VisualizarParque extends HttpServlet  {
		
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			
					String pagina = "";
					
					try {
						//Crio a conexao com o banco
						DataSource dataSource = new DataSource();
						//Passa o DataSource para o HotelDAO
						ParqueDao  parqueDao = new ParqueDao(dataSource);
						
						//Agora crio um objeto Hotel para reecuperar o dados via request do Get Id
						
						Parque parqueGet = new Parque();
						
						//Passando o ID do Get para o objeto hotelGet
						parqueGet.setId(Integer.parseInt(request.getParameter("id")));
						
						//Lendo os dados que retornaram do metodo read(hotelGet)
						Parque parque = parqueDao.read(parqueGet);
						
						if(parque != null) {
							// Se consegui carregar os dados na instância hotel
							// mantenho o usuário conectado
							request.getSession().setAttribute("Parque", parque);
							pagina = "/views/parque/visualizar.jsp";
						}
						else {
						    pagina = "/erro.jsp";
							request.setAttribute("ErroMSG", "Parque não encontrado");
						}
						// redirecionando para a página resultante
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
						dispatcher.forward(request, response);
						
					}
					catch(Exception ex){
						System.out.println("Erro visualizar parque" + ex.getMessage());
					}
					
				}

	}
