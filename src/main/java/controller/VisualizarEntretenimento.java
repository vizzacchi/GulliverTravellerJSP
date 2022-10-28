package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entretenimento;
import dao.EntretenimentoDao;
import dao.DataSource;

import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/entretenimento.do")
public class VisualizarEntretenimento extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String pagina = "";
		
		try {
			//Crio a conexao com o banco
			DataSource dataSource = new DataSource();
			//Passa o DataSource para o EntretenimentoDAO
			EntretenimentoDao  entretenimentoDao = new EntretenimentoDao(dataSource);
			
			//Agora crio um objeto Entretenimento para reecuperar o dados via request do Get Id
			
			Entretenimento entretenimentoGet = new Entretenimento();
			
			//Passando o ID do Get para o objeto entretenimentoGet
			entretenimentoGet.setId(Integer.parseInt(request.getParameter("id")));
			
			//Lendo os dados que retornaram do metodo read(entretenimentoGet)
			Entretenimento entretenimento = entretenimentoDao.read(entretenimentoGet);
			
			if(entretenimento != null) {
				// Se consegui carregar os dados na instância entretenimento
				// mantenho o usuário conectado
				request.getSession().setAttribute("Entretenimento", entretenimento);
				pagina = "/views/entretenimento/visualizar.jsp";
			}
			else {
				request.setAttribute("ErroMSG", "Entretenimento não encontrado");
				pagina = "/erro.jsp";
			}
			// redirecionando para a página resultante
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		}
		catch(Exception ex){
			System.out.println("Erro visualizar entretenimento" + ex.getMessage());
		}
		
	}		
		
}