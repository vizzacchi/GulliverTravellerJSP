package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataSource;
import dao.UfDao;
import model.Uf;

@WebServlet("/mostrar_uf")
public class MostrarUf extends HttpServlet {
	private Uf retorno;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String pagina = "";
		try {
			pagina = "";
			
			Uf uf = this.buscarUfTeste();
			if(uf != null) {
				request.getSession().setAttribute("UF", uf);
				pagina = "/uf.jsp";
				
			}
			else {
				pagina = "/erro.jsp";
				request.setAttribute("ErroMSG", "UF não encontrada");
			}
		}
		catch(Exception e) {
			pagina = "/erro.jsp";
			
		}
		
		RequestDispatcher dispatecher = getServletContext().getRequestDispatcher(pagina);
		dispatecher.forward(request, response);
		
	}
	
	private int parseInt(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}



	private Uf buscarUfTeste() {
		DataSource dataSource = new DataSource();
		UfDao ufDao = new UfDao(dataSource);
		
		Uf retorno = ufDao.getUfTeste();
		
		return retorno;
	}	
	
}
