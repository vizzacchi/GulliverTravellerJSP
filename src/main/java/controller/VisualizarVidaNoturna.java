package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.VidaNoturna;
import dao.VidaNoturnaDao;
import dao.DataSource;

import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/vidaNoturna.do")
public class VisualizarVidaNoturna extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String pagina = "";
		
		try {
			//Crio a conexao com o banco
			DataSource dataSource = new DataSource();
			//Passa o DataSource para o VidaNoturnaDAO
			VidaNoturnaDao  vidaNoturnaDao = new VidaNoturnaDao(dataSource);
			
			//Agora crio um objeto VidaNoturna para reecuperar o dados via request do Get Id
			
			VidaNoturna vidaNoturnaGet = new VidaNoturna();
			
			//Passando o ID do Get para o objeto vidaNoturnaGet
			vidaNoturnaGet.setId(Integer.parseInt(request.getParameter("id")));
			
			//Lendo os dados que retornaram do metodo read(vidaNoturnaGet)
			VidaNoturna vidaNoturna = vidaNoturnaDao.read(vidaNoturnaGet);
			
			if(vidaNoturna != null) {
				// Se consegui carregar os dados na instância vidaNoturna
				// mantenho o usuário conectado
				request.getSession().setAttribute("VidaNoturna", vidaNoturna);
				pagina = "/views/vidaNoturna/visualizar.jsp";
			}
			else {
				request.setAttribute("ErroMSG", "VidaNoturna não encontrado");
				pagina = "/erro.jsp";
			}
			// redirecionando para a página resultante
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		}
		catch(Exception ex){
			System.out.println("Erro visualizar vidaNoturna" + ex.getMessage());
		}
		
	}		
		
}