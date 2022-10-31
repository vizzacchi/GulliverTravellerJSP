package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataSource;
import dao.LocadoraCarroDao;
import model.LocadoraCarro;

import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/locadora.do")
public class VisualizarLocadoraCarro extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String pagina = "";
		
		try {			
			//CONEXÃO COM O BANCO
			DataSource dataSource = new DataSource();
			LocadoraCarroDao  locadoraDao = new LocadoraCarroDao(dataSource);
			
			//CRIO O OBJETO LOCADORA PARA RECUPERAR OS DADOS VIA REQUEST DO GET (ID)
			LocadoraCarro locadoraGet = new LocadoraCarro();
			
			//PASSO O ID DO GET PARA O OBJETO locadoraGet
			locadoraGet.setId(Integer.parseInt(request.getParameter("id")));
			
			//LÊ OS DADOS QUE RETORNAM DO MÉTODO read(locadoraGet)
			LocadoraCarro locadora = locadoraDao.read(locadoraGet);
			
			if(locadora != null) {
				//SE CONSEGUIR CARREGAR OS DADOS NA INSTÂNCIA LOCADORA MANTÊM O USUÁRIO CONECTADO
				request.getSession().setAttribute("Locadora", locadora);
				pagina = "/views/locadoraCarro/visualizar.jsp";
			}
			else {
				request.setAttribute("ErroMSG", "Locadora não encontrada");
				pagina = "/erro.jsp";
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		}
		catch(Exception ex){
			System.out.println("Erro visualizar locadora" + ex.getMessage());
		}
	}
}