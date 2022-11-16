package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AvaliacaoDao;
import dao.DataSource;
import model.Avaliacao;
import model.Usuario;

@WebServlet("/avaliacao.do")
public class CadastrarAvaliacao extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String pagina = "";
		
		try {
			//Crio a conexao com o banco
			DataSource dataSource = new DataSource();
			//Passa o DataSource para o AvaliacaoDAO
			AvaliacaoDao  avaliacaoDao = new AvaliacaoDao(dataSource);
			
			//Agora crio um objeto Avaliacao para reecuperar o dados via request do Post
			
			Avaliacao avaliacaoPost = new Avaliacao();
			
			//Passando os dados do Post para o objeto hotelPost
			avaliacaoPost.setIdPonto(Integer.parseInt(request.getParameter("id-ponto")));
			avaliacaoPost.setNota(Double.parseDouble(request.getParameter("nota")));
			avaliacaoPost.setComentario(request.getParameter("avaliacao"));
			avaliacaoPost.setData( LocalDate.now());
			
			Usuario usuario = new Usuario();
			usuario.setId(1);
			
			avaliacaoPost.setUsuario(usuario);
			
			//Cadastrando os dados do metodo create(avaliacaoDAO)
			Avaliacao avaliacao = avaliacaoDao.create(avaliacaoPost);
			
			if(avaliacao != null) {
				// Se consegui carregar os dados na instância hotel
				// mantenho o usuário conectado
				//request.getSession().setAttribute("Hotel", hotel);
				pagina = "/views/hotel/visualizar.jsp";
			}
			else {
				request.setAttribute("ErroMSG", "Avaliação não cadastrada");
				pagina = "/erro.jsp";
			}
			// redirecionando para a página resultante
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		}
		catch(Exception ex){
			System.out.println("Erro cadastrar avaliação" + ex.getMessage());
		}	
	}
}