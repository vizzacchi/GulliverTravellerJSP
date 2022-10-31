package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cultura;
import dao.CulturaDao;
import dao.DataSource;
import java.util.ArrayList;

import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/Cultura.do")
public class VisualizarCultura extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String pagina = "";
		
		try {
			//Crio a conexao com o banco
			DataSource dataSource = new DataSource();
			//Passa o DataSource para o CulturaDAO
			CulturaDao  culturaDao = new CulturaDao(dataSource);
			
			//Agora crio um objeto Hotel para reecuperar o dados via request do Get Id
			
			Cultura culturaGet = new Cultura();
			
			//Passando o ID do Get para o objeto culturaGet
			culturaGet.setId(Integer.parseInt(request.getParameter("id")));
			
			//Lendo os dados que retornaram do metodo read(hotelGet)
			Cultura cultura = culturaDao.read(culturaGet);
			
			if(cultura != null) {
				// Se consegui carregar os dados na instância hotel
				// mantenho o usuário conectado
				request.getSession().setAttribute("Cultura", cultura);
				pagina = "/views/Cultura/cultura.jsp";
			}
			else {
				request.setAttribute("ErroMSG", "pagina não encontrado");
				pagina = "/erro.jsp";
			}
			// redirecionando para a página resultante
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		}
		catch(Exception ex){
			System.out.println("Erro visualizar pagina" + ex.getMessage());
		}
		
	}
		
		
		
}