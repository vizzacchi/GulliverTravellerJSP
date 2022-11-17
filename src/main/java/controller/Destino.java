package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataSource;
import dao.DestinoDao;
import model.Cidade;

@WebServlet("/destino")
public class Destino extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String destino = request.getParameter("destino");
            String pagina = "";
            
            System.out.println(destino);
            
            Cidade cidade = this.buscarDestino(destino);
            if(cidade != null) {
                request.getSession().setAttribute("Destino", cidade);
                pagina = "/home.jsp";
            } else {
                pagina = "/erro.jsp";
                request.setAttribute("ErroMSG", "Destino não encontrado");
            }
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar destino: " + e.getMessage());
        }
    }
    
    //BUSCA O DESTINO
    private Cidade buscarDestino(String destino) {
        DataSource dataSource = new DataSource();
        DestinoDao destinoDao = new DestinoDao(dataSource);
        
        Cidade retorno = destinoDao.getByDestino(destino);
        return retorno;
    }
}