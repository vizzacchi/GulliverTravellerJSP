package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import dao.DataSource;
import dao.UfDao;
import model.Uf;

@WebServlet("/mostrar_uf")
public class MostrarUf extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String pagina = "";
		System.out.println("MOSTRARUF");
		try {
			//crio a conexao com o banco
			DataSource dataSource = new DataSource();
			//passo o DataSource para o DAO
			UfDao ufDao = new UfDao(dataSource);
			
			//agora crio um UF para recuperar os dados do form via request
			Uf ufForm = new Uf();
			ufForm.setId(Integer.parseInt(request.getParameter("id")));
			
			Uf uf = ufDao.read(ufForm);
			if(uf != null) {
				//aqui um segredo importantissiomo manter o usupario conectado
				System.out.println("UfDao.read");
				request.getSession().setAttribute("Uf", uf);
					pagina = "/uf.jsp";
			}
			else {
				request.setAttribute("ErroMSG","Uf não encontrado");
				pagina = "/erro.jsp";
			}
			//só nos resta redirecionar para a oágina resultante
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
		catch(Exception e) {
			pagina = "/erro.jsp";
			
		}
	}	
}
